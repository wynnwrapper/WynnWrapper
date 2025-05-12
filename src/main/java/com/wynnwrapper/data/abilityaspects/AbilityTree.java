package com.wynnwrapper.data.abilityaspects;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class AbilityTree{
    private Map<String, AbilityTreeArchetype> archetype;
    private List<Map<String, AbilityTreeAbility>> pages;


    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (AbilityTree) obj;
        return this.archetype.equals(that.archetype) &&
                this.pages.equals(that.pages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(archetype, pages);
    }

    @Override
    public String toString() {
        return "AbilityTree{" +
                "archetype=" + archetype +
                ", pages=" + pages +
                '}';
    }

    public static class AbilityTreeDeserializer implements JsonDeserializer<AbilityTree> {
        @Override
        public AbilityTree deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject obj = json.getAsJsonObject();

            try {
                Map<String, AbilityTreeArchetype> archetype = obj.has("archetype") && !obj.get("archetype").isJsonNull()
                        ? context.deserialize(obj.get("archetype"), new TypeToken<Map<String, AbilityTreeArchetype>>() {}.getType())
                        : null;

                List<Map<String, AbilityTreeAbility>> pages;
                if (obj.has("pages") && !obj.get("pages").isJsonNull()) {

                    Map<String, Map<String, AbilityTreeAbility>> pagesMap = context.deserialize(
                            obj.get("pages"),
                            new TypeToken<Map<String, Map<String, AbilityTreeAbility>>>() {}.getType()
                    );
                    pages = pagesMap != null ? List.copyOf(pagesMap.values()) : null;
                } else {
                    pages = null;
                }

                return new AbilityTree(archetype, pages);
            } catch (JsonParseException e) {
                throw new JsonParseException("Failed to parse AbilityTree", e);
            }
        }
    }
}