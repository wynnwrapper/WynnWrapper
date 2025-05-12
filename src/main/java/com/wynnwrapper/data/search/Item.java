package com.wynnwrapper.data.search;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public record Item(
        String material,
        String tier,
        int powderSlots,
        String type,
        String lore,
        String dropRestriction,
        String armorType,
        String attackSpeed,
        String internalName,
        DropMeta dropMeta,
        BaseStats base,
        Requirements requirements,
        Map<String, Identification> identifications
) {

    public record DropMeta(
            List<Integer> coordinates,
            String name,
            Object type //can be a string or a list of strings
    ) {
    }

    public record BaseStats(
            DamageRange waterDamage,
            int averageDPS
    ) {}

    public record DamageRange(
            int min,
            int max
    ) {}

    public record Requirements(
            int level,
            int strength,
            int dexterity,
            int intelligence,
            int defense,
            int agility
    ) {}


    public record Identification(

            int rawIdentification,
            int min,
            int max

    ) {

        public static class IdentificationDeserializer implements JsonDeserializer<Identification> {
            @Override
            public Identification deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                if (json.isJsonPrimitive()) {
                    int value = json.getAsInt();
                    return new Identification(value, value, value);
                } else {
                    JsonObject obj = json.getAsJsonObject();

                    if (obj.has("rawIdentification") && obj.has("identification")) {

                        int rawIdentification = obj.get("rawIdentification").getAsInt();
                        JsonObject identificationObj = obj.get("identification").getAsJsonObject();
                        int min = identificationObj.get("min").getAsInt();
                        int max = identificationObj.get("max").getAsInt();
                        return new Identification(rawIdentification, min, max);
                    } else {
                        int rawValue = obj.has("raw") ? obj.get("raw").getAsInt() : 0;
                        int min = obj.has("min") ? obj.get("min").getAsInt() : 0;
                        int max = obj.has("max") ? obj.get("max").getAsInt() : 0;
                        return new Identification(rawValue, min, max);
                    }
                }
            }
        }
    }


    @Override
    public String toString() {
        return "Item{" +
                "material='" + material + '\'' +
                ", tier='" + tier + '\'' +
                ", powderSlots=" + powderSlots +
                ", type='" + type + '\'' +
                ", lore='" + lore + '\'' +
                ", dropRestriction='" + dropRestriction + '\'' +
                ", armorType='" + armorType + '\'' +
                ", attackSpeed='" + attackSpeed + '\'' +
                ", internalName='" + internalName + '\'' +
                ", dropMeta=" + dropMeta +
                ", base=" + base +
                ", requirements=" + requirements +
                ", identifications=" + identifications +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;

        if (powderSlots != item.powderSlots) return false;
        if (!material.equals(item.material)) return false;
        if (!tier.equals(item.tier)) return false;
        if (!type.equals(item.type)) return false;
        if (!lore.equals(item.lore)) return false;
        if (!dropRestriction.equals(item.dropRestriction)) return false;
        if (!armorType.equals(item.armorType)) return false;
        if (!attackSpeed.equals(item.attackSpeed)) return false;
        if (!internalName.equals(item.internalName)) return false;
        if (!dropMeta.equals(item.dropMeta)) return false;
        if (!base.equals(item.base)) return false;
        if (!requirements.equals(item.requirements)) return false;
        return identifications.equals(item.identifications);
    }
}
