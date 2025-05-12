package com.wynnwrapper.data.abilityaspects;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public record AbilityTreeAbility(
    String name,
    AbilityIcon icon,
    int slot,
    int[] coordinates,
    List<String> description,
    AbilityRequirements requirements,
    List<String> links,
    List<String> locks,
    int page
) {

    @Override
    public String toString() {
        return "AbilityTreeAbility{" +
            "name='" + name + '\'' +
            ", icon=" + icon +
            ", slot=" + slot +
            ", coordinates=" + Arrays.toString(coordinates) +
            ", description=" + description +
            ", requirements=" + requirements +
            ", links=" + links +
            ", locks=" + locks +
            ", page=" + page +
            '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (AbilityTreeAbility) obj;
        return this.name.equals(that.name) &&
            this.icon.equals(that.icon) &&
            this.slot == that.slot &&
                Arrays.equals(this.coordinates, that.coordinates) &&
            this.description.equals(that.description) &&
            this.requirements.equals(that.requirements) &&
            this.links.equals(that.links) &&
            this.locks.equals(that.locks) &&
            this.page == that.page;
    }

    public static class AbilityTreeAbilityDeserializer implements JsonDeserializer<AbilityTreeAbility> {
        @Override
        public AbilityTreeAbility deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject obj = json.getAsJsonObject();
            String name = obj.get("name").getAsString();
            AbilityIcon icon = context.deserialize(obj.get("icon"), AbilityIcon.class);
            int slot = obj.get("slot").getAsInt();

            JsonObject coordsObj = obj.getAsJsonObject("coordinates");
            int[] coordinates = new int[2];
            coordinates[0] = coordsObj.get("x").getAsInt();
            coordinates[1] = coordsObj.get("y").getAsInt();

            List<String> description = context.deserialize(obj.get("description"), new TypeToken<List<String>>() {}.getType());
            AbilityRequirements requirements = context.deserialize(obj.get("requirements"), AbilityRequirements.class);
            List<String> links = context.deserialize(obj.get("links"), new TypeToken<List<String>>() {}.getType());
            List<String> locks = context.deserialize(obj.get("locks"), new TypeToken<List<String>>() {}.getType());
            int page = obj.get("page").getAsInt();

            return new AbilityTreeAbility(name, icon, slot, coordinates, description, requirements, links, locks, page);
        }
    }
}