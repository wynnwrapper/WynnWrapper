package com.wynnwrapper.data.map;

import java.util.List;

public record PlayerLocation(
        String uuid,
        String name,
        String nickname,
        String server,
        int x,
        int y,
        int z,
        List<PlayerLocationMember> friends,
        List<PlayerLocationMember> party,
        List<PlayerLocationMember> guild
) {

    public record PlayerLocationMember(
            String uuid,
            String name,
            String nickname,
            String server,
            int x,
            int y,
            int z
    ) {
        @Override
        public String toString() {
            return "PlayerLocationMember{" +
                    "uuid='" + uuid + '\'' +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", server='" + server + '\'' +
                    ", x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PlayerLocationMember that)) return false;

            if (x != that.x) return false;
            if (y != that.y) return false;
            if (z != that.z) return false;
            if (!uuid.equals(that.uuid)) return false;
            if (!name.equals(that.name)) return false;
            if (!nickname.equals(that.nickname)) return false;
            return server.equals(that.server);
        }
    }

    @Override
    public String toString() {
        return "PlayerLocation{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", server='" + server + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", friends=" + friends +
                ", party=" + party +
                ", guild=" + guild +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerLocation that)) return false;

        if (x != that.x) return false;
        if (y != that.y) return false;
        if (z != that.z) return false;
        if (!uuid.equals(that.uuid)) return false;
        if (!name.equals(that.name)) return false;
        if (!nickname.equals(that.nickname)) return false;
        if (!server.equals(that.server)) return false;
        if (!friends.equals(that.friends)) return false;
        if (!party.equals(that.party)) return false;
        return guild.equals(that.guild);
    }
}