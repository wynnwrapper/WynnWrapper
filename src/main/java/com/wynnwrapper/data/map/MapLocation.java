package com.wynnwrapper.data.map;

import java.util.List;

public record MapLocation(
        String name,
        String icon,
        int x,
        int y,
        int z
) {

    @Override
    public String toString() {
        return "MapLocation{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MapLocation that)) return false;

        if (x != that.x) return false;
        if (y != that.y) return false;
        if (z != that.z) return false;
        if (!name.equals(that.name)) return false;
        return icon.equals(that.icon);
    }
}

