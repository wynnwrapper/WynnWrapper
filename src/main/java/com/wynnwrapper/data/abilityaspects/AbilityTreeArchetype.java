package com.wynnwrapper.data.abilityaspects;

import com.google.gson.*;
import com.wynnwrapper.data.classes.ArchetypeName;

import java.lang.reflect.Type;

public record AbilityTreeArchetype(
    ArchetypeName name,
    String description,
    String shortDescription,
    AbilityIcon icon,
    int slot
) {

    @Override
    public String toString() {
        return "AbilityTreeArchetype{" +
            "name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", shortDescription='" + shortDescription + '\'' +
            ", icon=" + icon +
            ", slot=" + slot +
            '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (AbilityTreeArchetype) obj;
        return this.name.equals(that.name) &&
            this.description.equals(that.description) &&
            this.shortDescription.equals(that.shortDescription) &&
            this.icon.equals(that.icon) &&
            this.slot == that.slot;
    }

    public static class AbilityTreeArchetypeDeserializer implements JsonDeserializer<AbilityTreeArchetype> {
        @Override
        public AbilityTreeArchetype deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject obj = json.getAsJsonObject();
            ArchetypeName name = obj.has("name") && !obj.get("name").isJsonNull() ? ArchetypeName.valueOf(obj.get("name").getAsString().toUpperCase()) : null;
            String description = obj.get("description").getAsString();
            String shortDescription = obj.get("shortDescription").getAsString();
            AbilityIcon icon = context.deserialize(obj.get("icon"), AbilityIcon.class);
            int slot = obj.get("slot").getAsInt();

            return new AbilityTreeArchetype(name, description, shortDescription, icon, slot);
        }
    }
}