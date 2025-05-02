package com.wynnwrapper.data.item;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class Item {
    private String internalName;
    private String type;
    private String subType;
    private Icon icon;
    private boolean identifier;
    private boolean allow_craftsman;

    // Variable fields based on type
    private String armourMaterial;
    private String attackSpeed;
    private int averageDPS;
    private int gatheringSpeed;
    private String tier;
    private String rarity;
    private ConsumableOnlyIDs consumableOnlyIDs;
    private IngredientPositionModifiers ingredientPositionModifiers;
    private ItemOnlyIDs itemOnlyIDs;
    private Map<String, String> majorIds;
    private List<String> craftable;
    private int powderSlots;
    private String lore;
    private String dropRestriction;
    private String restriction;
    private boolean raidReward;
    private DropMeta dropMeta;
    private Base base;
    private Requirements requirements;
    private Map<String, Object> identifications;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Item) obj;
        return this.internalName.equals(that.internalName) &&
                this.type.equals(that.type) &&
                this.subType.equals(that.subType) &&
                this.icon.equals(that.icon) &&
                this.identifier == that.identifier &&
                this.allow_craftsman == that.allow_craftsman &&
                this.armourMaterial.equals(that.armourMaterial) &&
                this.attackSpeed.equals(that.attackSpeed) &&
                this.averageDPS == that.averageDPS &&
                this.gatheringSpeed == that.gatheringSpeed &&
                this.tier.equals(that.tier) &&
                this.rarity.equals(that.rarity) &&
                this.consumableOnlyIDs.equals(that.consumableOnlyIDs) &&
                this.ingredientPositionModifiers.equals(that.ingredientPositionModifiers) &&
                this.itemOnlyIDs.equals(that.itemOnlyIDs) &&
                this.majorIds.equals(that.majorIds) &&
                this.craftable.equals(that.craftable) &&
                this.powderSlots == that.powderSlots &&
                this.lore.equals(that.lore) &&
                this.dropRestriction.equals(that.dropRestriction) &&
                this.restriction.equals(that.restriction) &&
                this.raidReward == that.raidReward &&
                this.dropMeta.equals(that.dropMeta) &&
                this.base.equals(that.base) &&
                this.requirements.equals(that.requirements);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(internalName, type, subType, icon, identifier, allow_craftsman, armourMaterial,
                attackSpeed, averageDPS, gatheringSpeed, tier, rarity, consumableOnlyIDs,
                ingredientPositionModifiers, itemOnlyIDs, majorIds, craftable, powderSlots,
                lore, dropRestriction, restriction, raidReward, dropMeta, base,
                requirements);
    }

    @Override
    public String toString() {
        return "Item{" +
                "internalName='" + internalName + '\'' +
                ", type='" + type + '\'' +
                ", subType='" + subType + '\'' +
                ", icon=" + icon +
                ", identifier=" + identifier +
                ", allow_craftsman=" + allow_craftsman +
                ", armourMaterial='" + armourMaterial + '\'' +
                ", attackSpeed='" + attackSpeed + '\'' +
                ", averageDPS=" + averageDPS +
                ", gatheringSpeed=" + gatheringSpeed +
                ", tier='" + tier + '\'' +
                ", rarity='" + rarity + '\'' +
                ", consumableOnlyIDs=" + consumableOnlyIDs +
                ", ingredientPositionModifiers=" + ingredientPositionModifiers +
                ", itemOnlyIDs=" + itemOnlyIDs +
                ", majorIds=" + majorIds +
                ", craftable=" + craftable +
                ", powderSlots=" + powderSlots +
                ", lore='" + lore + '\'' +
                ", dropRestriction='" + dropRestriction + '\'' +
                ", restriction='" + restriction + '\'' +
                ", raidReward=" + raidReward +
                ", dropMeta=" + dropMeta +
                ", base=" + base +
                ", requirements=" + requirements +
                '}';
    }
}