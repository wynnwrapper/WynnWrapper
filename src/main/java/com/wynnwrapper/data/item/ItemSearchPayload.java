package com.wynnwrapper.data.item;

import com.wynnwrapper.data.item.enums.*;
import com.wynnwrapper.data.item.enums.Identification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record ItemSearchPayload(
        String query,
        List<String> type,
        List<Integer> tier,
        List<String> attackSpeed,
        int[] levelRange,
        List<String> professions,
        List<String> identifications,
        List<String> majorIds
) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String query;
        private final List<String> type = new ArrayList<>();
        private final List<Integer> tier = new ArrayList<>();
        private final List<String> attackSpeed = new ArrayList<>();
        private int[] levelRange = {1, 110};
        private final List<String> professions = new ArrayList<>();
        private final List<String> identifications = new ArrayList<>();
        private final List<String> majorIds = new ArrayList<>();

        public Builder query(String query) {
            this.query = query;
            return this;
        }

        public Builder type(ItemType itemType) {
            this.type.add(itemType.getType());
            return this;
        }

        public Builder type(ItemType... itemTypes) {
            Arrays.stream(itemTypes)
                    .map(ItemType::getType)
                    .forEach(this.type::add);
            return this;
        }

        public Builder tier(ItemRarity rarity) {
            this.tier.add(rarity.ordinal());
            return this;
        }

        public Builder tier(ItemRarity... rarities) {
            Arrays.stream(rarities)
                    .map(Enum::ordinal)
                    .forEach(this.tier::add);
            return this;
        }

        public Builder attackSpeed(Attackspeed attackSpeed) {
            this.attackSpeed.add(attackSpeed.getSpeed());
            return this;
        }

        public Builder attackSpeed(List<Attackspeed> attackSpeeds) {
            attackSpeeds.stream()
                    .map(Attackspeed::getSpeed)
                    .forEach(this.attackSpeed::add);
            return this;
        }

        public Builder levelRange(int[] levelRange) {
            if (levelRange.length != 2 || levelRange[0] > levelRange[1] || levelRange[0] < 1 || levelRange[1] > 110) {
                throw new IllegalArgumentException("Level range must be an array of two integers.");
            }
            this.levelRange = levelRange;
            return this;
        }

        public Builder professions(Profession profession) {
            this.professions.add(profession.getProfession());
            return this;
        }

        public Builder professions(List<Profession> professions) {
            professions.stream()
                    .map(Profession::getProfession)
                    .forEach(this.professions::add);
            return this;
        }

        public Builder identifications(Identification identification) {
            this.identifications.add(identification.getIdentification());
            return this;
        }

        public Builder identifications(List<Identification> identifications) {
            identifications.stream()
                    .map(Identification::getIdentification)
                    .forEach(this.identifications::add);
            return this;
        }

        public Builder majorIds(MajorID majorId) {
            this.majorIds.add(majorId.getMajorID());
            return this;
        }

        public Builder majorIds(List<MajorID> majorIds) {
            majorIds.stream()
                    .map(MajorID::getMajorID)
                    .forEach(this.majorIds::add);
            return this;
        }

        public ItemSearchPayload build() {
            return new ItemSearchPayload(
                    query, type, tier, attackSpeed, levelRange,
                    professions, identifications, majorIds
            );
        }
    }
}