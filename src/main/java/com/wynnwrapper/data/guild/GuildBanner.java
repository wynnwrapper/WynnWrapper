package com.wynnwrapper.data.guild;

import java.util.List;

public record GuildBanner(
        String base,
        int tier,
        String structure,
        List<BannerLayer> layers
) { }