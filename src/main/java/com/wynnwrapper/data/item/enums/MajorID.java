package com.wynnwrapper.data.item.enums;

public enum MajorID {
    // Major IDs
    ALTER_EGO("Alter Ego"),
    ALTRUISM("Altruism"),
    BRACHIATE("Brachiation"),
    CANNULATE("Cannulate"),
    CAVALRYMAN("Cavalryman"),
    CHERRY_BOMBS("Cherry Bombs"),
    COAGULATE("Coagulate"),
    DAUNTLESS_INFERNO("Dauntless Inferno"),
    DEAD_WEIGHT("Dead Weight"),
    DISPLACE("Displace"),
    DIVINE_HONOR("Divine Honor"),
    EFFLORESCENCE("Efflorescence"),
    ENTROPY("Entropy"),
    ERGOSPHERE("Ergosphere"),
    ESCAPE_ROUTE("Escape Route"),
    EVERSHOT("Evershot"),
    EXPLOSIVE_IMPACT("Explosive Impact"),
    EXPUNGE("Expunge"),
    FALLOUT("Fallout"),
    FAUSTIAN_GAMBIT("Faustian Gambit"),
    FESTIVE_SPIRIT("Festive Spirit"),
    FIND_THYSELF("Find Thyself"),
    FISSION("Fission"),
    FIXATE("Fixate"),
    FLASHFREEZE("Flashfreeze"),
    FLASHFREEZE_2("Flashfreeze2"),
    FLURRY_OF_BLOWS("Flurry of Blows"),
    FORESTS_BLESSING("Forest's Blessing"),
    FRIGHT_OR_FLIGHT("Fright or Flight"),
    FREERUNNER("Freerunner"),
    FRENETIC_SPIRIT("Frenetic Spirit"),
    FURIOUS_EFFIGY("Furious Effigy"),
    GENTLE_GLOW("Gentle Glow"),
    GEOCENTRISM("Geocentrism"),
    GRAVITY_WELL("Gravity Well"),
    GREED("Greed"),
    GRUESOME_KNOTS("Gruesome Knots"),
    GUARDIAN("Guardian"),
    HAWKEYE("Hawkeye"),
    HEAT_SHIMMER("Heat Shimmer"),
    HELLFIRE("Hellfire"),
    HURRICANES_EYE("Hurricane's Eye"),
    INSOLUBLE("Insoluble"),
    INVERSION("Inversion"),
    JUGGLE("Juggle"),
    LAST_RESORT("Last Resort"),
    LIFESTREAM("Lifestream"),
    LIGHTWEIGHT("Lightweight"),
    LOCKDOWN("Lockdown"),
    LUNGE("Lunge"),
    LUSTRATE("Lustrate"),
    MADNESS("Madness"),
    MAGNET("Magnet"),
    MANGLE("Mangle"),
    METEOR_CRASH("Meteor Crash"),
    METHODICAL("Methodical"),
    NAPALM("Napalm"),
    ORBITAL_CHAIN("Orbital Chain"),
    OVERWHELM("Overwhelm"),
    PARAGON("Paragon"),
    PEACEFUL_EFFIGY("Peaceful Effigy"),
    PERFECT_RECALL("Perfect Recall"),
    PERILOUS_FLARE("Perilous Flare"),
    PHOENIX_BORN("Phoenix Born"),
    PIONEERS_ECHO("Pioneer's Echo"),
    PLAGUE("Plague"),
    POUNCE("Pounce"),
    POWER_FIST("Power Fist"),
    PUNISHMENT("Punishment"),
    RALLY("Rally"),
    RECKLESS_ABANDON("Reckless Abandon"),
    ROCK_SHIELD("Rock Shield"),
    ROVING_ASSASSIN("Roving Assassin"),
    RUSTED_ICHOR("Rusted Ichor"),
    SAVIOURS_SACRIFICE("Saviour's Sacrifice"),
    SCARCE_COMFORT("Scarce Comfort"),
    SEEKING_MODULE("Seeking Module"),
    SELF_SUFFICIENT("Self Sufficient"),
    SNOWY_STEPS("Snowy Steps"),
    SORCERY("Sorcery"),
    SOUL_EATER("Soul Eater"),
    STRINGS_OF_FATE("Strings of Fate"),
    SUBLIMATION("Sublimation"),
    SUN_EATER("Sun Eater"),
    SUPERCONDUCTOR("Superconductor"),
    TACKLE("Tackle"),
    TAUNT("Taunt"),
    TEMBLOR("Temblor"),
    TOTEMIC_FUSE("Totemic Fuse"),
    TRANSCENDENCE("Transcendence"),
    TWISTING_THREADS("Twisting Threads"),
    VEDETTE("Vedette"),
    VITRIOL("Vitriol"),
    WINDSURF("Windsurf"),
    WORMHOLE("Wormhole"),

    // Misc
    REFLECTION("Reflection"),
    THORNS("Thorns"),
    LEVELED_XP_BONUS("Leveled Xp Bonus"),
    LEVELED_LOOT_BONUS("Leveled Loot Bonus"),
    WEAKEN_ENEMY("Weaken Enemy"),
    EXPLODING("Exploding"),
    CRITICAL_DAMAGE_BONUS("Critical Damage Bonus"),
    DAMAGE_FROM_MOBS("Damage from Mobs");



    private final String identification;

    MajorID(String identification) {
        this.identification = identification;
    }

    public String getMajorID() {
        return identification;
    }

    @Override
    public String toString() {
        return identification;
    }
}
