package com.wynnwrapper.data.classes;

public record ClassMetaData(
        String name,
        int overallDifficulty
) {

    @Override
    public String toString() {
        return "ClassMetaData{" +
                "name='" + name + '\'' +
                ", overallDifficulty=" + overallDifficulty +
                '}';
    }

}
