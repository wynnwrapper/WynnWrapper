package com.wynnwrapper.data.item;

public record IngredientPositionModifiers(
        Integer left,
        Integer right,
        Integer above,
        Integer under,
        Integer touching,
        Integer not_touching
) {}