package com.wynnwrapper.data.item.enums;

public enum ItemType {
    // Categories of items
    WEAPON("Weapon"),
    ARMOR("Armor"),
    ACCESSORY("Accessory"),
    TOME("Tome"),
    CHARM("Charm"),
    TOOL("Tool"),
    INGREDIENT("Ingredient"),
    MATERIAL("Material"),

    // Weapons
    BOW("Bow"),
    RELIK("Relik"),
    WAND("Wand"),
    DAGGER("Dagger"),
    SPEAR("Spear"),

    // Armor
    HELMET("Helmet"),
    CHESTPLATE("Chestplate"),
    LEGGINGS("Leggings"),
    BOOTS("Boots"),

    // Accessories
    NECKLACE("Necklace"),
    RING("Ring"),
    BRACELET("Bracelet"),

    // Tomes
    WEAPON_TOME("Weapon Tome"),
    ARMOUR_TOME("Armour Tome"),
    GUILD_TOME("Guild Tome"),
    EXPERTISE_TOME("Expertise Tome"),
    MYSTICISM_TOME("Mysticism Tome"),
    MARATHON_TOME("Marathon Tome"),
    LOOTRUN_TOME("Lootrun Tome"),

    // Charms - Doesn't have subcategories

    // Tools
    AXE("Axe"),
    PICKAXE("Pickaxe"),
    ROD("Rod"),
    SCYTHE("Scythe");


    private final String type;

    ItemType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
