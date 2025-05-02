package com.wynnwrapper.data.item.enums;

public enum Identification {

    // General
    BASE_DAMAGE("Base Damage"),
    DAMAGE("Damage"),
    RAW_DAMAGE("Raw Damage"),
    RAW_NEUTRAL_DAMAGE("Raw Neutral Damage"),

    // Mana
    RAW_MAX_MANA("Raw Max Mana"),
    MANA_STEAL("Mana Steal"),
    MANA_REGEN("Mana Regen"),

    // Earth Element
    STRENGTH("Strength"),
    EARTH_DEFENCE("Earth Defence"),
    PERCENT_EARTH_DAMAGE("earth Damage"),
    RAW_EARTH_DAMAGE("Raw Earth Damage"),
    PERCENT_EARTH_MAIN_ATTACK_DAMAGE("Earth Main Attack Damage"),
    RAW_EARTH_MAIN_ATTACK_DAMAGE("Raw Earth Main Attack Damage"),
    PERCENT_EARTH_SPELL_DAMAGE("Earth Spell Damage"),
    RAW_EARTH_SPELL_DAMAGE("Raw Earth Spell Damage"),

    // Thunder Element
    DEXTERITY("Dexterity"),
    THUNDER_DEFENCE("Thunder Defence"),
    PERCENT_THUNDER_DAMAGE("Thunder Damage"),
    RAW_THUNDER_DAMAGE("Raw Thunder Damage"),
    PERCENT_THUNDER_MAIN_ATTACK_DAMAGE("Thunder Main Attack Damage"),
    RAW_THUNDER_MAIN_ATTACK_DAMAGE("Raw Thunder Main Attack Damage"),
    PERCENT_THUNDER_SPELL_DAMAGE("Thunder Spell Damage"),
    RAW_THUNDER_SPELL_DAMAGE("Raw Thunder Spell Damage"),

    // Water Element
    INTELLIGENCE("Intelligence"),
    WATER_DEFENCE("Water Defence"),
    PERCENT_WATER_DAMAGE("Water Damage"),
    RAW_WATER_DAMAGE("Raw Water Damage"),
    RAW_WATER_MAIN_ATTACK_DAMAGE("Raw Water Main Attack Damage"),
    PERCENT_WATER_SPELL_DAMAGE("Water Spell Damage"),
    RAW_WATER_SPELL_DAMAGE("Raw Water Spell Damage"),

    // Fire Element
    DEFENCE("Defence"),
    FIRE_DEFENCE("Fire Defence"),
    PERCENT_FIRE_DAMAGE("Fire Damage"),
    RAW_FIRE_DAMAGE("Raw Fire Damage"),
    PERCENT_FIRE_MAIN_ATTACK_DAMAGE("Fire Main Attack Damage"),
    RAW_FIRE_MAIN_ATTACK_DAMAGE("Raw Fire Main Attack Damage"),
    PERCENT_FIRE_SPELL_DAMAGE("Fire Spell Damage"),
    RAW_FIRE_SPELL_DAMAGE("Raw Fire Spell Damage"),

    // Air Element
    AGILITY("Agility"),
    AIR_DEFENCE("Air Defence"),
    PERCENT_AIR_DAMAGE("Air Damage"),
    RAW_AIR_DAMAGE("Raw Air Damage"),
    PERCENT_AIR_MAIN_ATTACK_DAMAGE("Air Main Attack Damage"),
    RAW_AIR_MAIN_ATTACK_DAMAGE("Raw Air Main Attack Damage"),
    PERCENT_AIR_SPELL_DAMAGE("Air Spell Damage"),
    RAW_AIR_SPELL_DAMAGE("Raw Air Spell Damage"),

    // Elemental Bonuses
    RAW_ELEMENTAL_SPELL_DAMAGE("Raw Elemental Spell Damage"),
    PERCENT_ELEMENTAL_DAMAGE_("Elemental Damage"),
    RAW_ELEMENTAL_DAMAGE("Raw Elemental Damage"),
    RAW_ELEMENTAL_MAIN_ATTACK_DAMAGE("Raw Elemental Main Attack Damage"),
    PERCENT_ELEMENTAL_SPELL_DAMAGE("Elemental Spell Damage"),
    ELEMENTAL_DEFENCE("Elemental Defence"),

    // Main Attack
    PERCENT_MAIN_ATTACK_DAMAGE("Main Attack Damage"),
    RAW_ATTACK_SPEED("Raw Attack Speed"),
    RAW_MAIN_ATTACK_DAMAGE("Raw Main Attack Damage"),
    POISON("Poison"),

    // Spells
    PERCENT_SPELL_DAMAGE("Spell Damage"),
    RAW_SPELL_DAMAGE("Raw Spell Damage"),
    RAW_1ST_SPELL_COST("Raw 1st Spell Cost"),
    RAW_2ND_SPELL_COST("Raw 2nd Spell Cost"),
    RAW_3RD_SPELL_COST("Raw 3rd Spell Cost"),
    RAW_4TH_SPELL_COST("Raw 4th Spell Cost"),
    PERCENT_1ST_SPELL_COST("1st Spell Cost"),
    PERCENT_2ND_SPELL_COST("2nd Spell Cost"),
    PERCENT_3RD_SPELL_COST("3rd Spell Cost"),
    PERCENT_4TH_SPELL_COST("4th Spell Cost"),
    RAW_NEUTRAL_SPELL_DAMAGE("Raw Neutral Spell Damage"),

    // Health
    BASE_HEALTH("Base Health"),
    RAW_HEALTH_REGEN("Health Regen Raw"),
    LIFE_STEAL("Life Steal"),
    PERCENT_HEALTH_REGEN("Health Regen"),

    // Mobility
    WALK_SPEED("Walk Speed"),
    SPRINT_REGEN("Sprint Regen"),
    JUMP_HEIGHT("Jump Height"),
    SPRINT("Sprint"),

    // XP, Looting, Gathering
    LOOT_BONUS("Loot Bonus"),
    XP_BONUS("XP Bonus"),
    STEALING("Stealing"),
    LOOT_QUALITY("Loot Quality"),
    GATHER_XP_BONUS("Gather XP Bonus"),
    GATHER_SPEED("Gather Speed"),

    // Misc
    REFLECTION("Reflection"),
    THORNS("Thorns"),
    LEVELED_XP_BONUS("Leveled Xp Bonus"),
    LEVELED_LOOT_BONUS("Leveled Loot Bonus"),
    WEAKEN_ENEMY("Weaken Enemy"),
    EXPLODING("Exploding"),
    CRITICAL_DAMAGE_BONUS("Critical Damage Bonus"),
    DAMAGE_FROM_MOBS("damageFromMobs");

    private final String identification;

    Identification(String identification) {
        this.identification = identification;
    }

    public String getIdentification() {
        return identification;
    }

    @Override
    public String toString() {
        return identification;
    }
}
