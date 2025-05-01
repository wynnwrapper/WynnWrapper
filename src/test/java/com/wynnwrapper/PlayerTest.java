package com.wynnwrapper;

import com.wynnwrapper.data.classes.ClassType;
import com.wynnwrapper.data.player.DetailedPlayer;
import com.wynnwrapper.data.player.Player;
import com.wynnwrapper.data.player.ability.AbilityMapType;
import com.wynnwrapper.data.player.ability.PlayerAbilityEntry;
import com.wynnwrapper.data.player.character.Character;
import com.wynnwrapper.data.player.character.DetailedCharacter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PlayerTest {

    static WynncraftAPI api;

    @BeforeAll
    static void setup() {
        api = new WynncraftAPI();
    }

    @Test
    void testPlayerMainStats() {
        Player player = api.player().playerStats("42nao");
        Assertions.assertEquals(player.username(), "42nao");
    }

    @Test
    void testPlayerDetailedStats() {
        DetailedPlayer player = api.player().playerDetailedStats("42nao");
        Assertions.assertEquals(player.username(), "42nao");
        Assertions.assertTrue(player.characters().stream().anyMatch((c) -> c.type() == ClassType.ARCHER));
    }

    @Test
    void testPlayerCharacterList() {
        Map<UUID, Character> characters = api.player().playerCharacterList("42nao");
        Assertions.assertEquals(characters.get(UUID.fromString("9cb823ee-9895-419a-bd1e-39d9243bc2ec")).type(), ClassType.ARCHER);
    }

    @Test
    void testPlayerCharacter() {
        DetailedCharacter character = api.player().playerCharacter("42nao", UUID.fromString("9cb823ee-9895-419a-bd1e-39d9243bc2ec"));
        Assertions.assertEquals(character.type(), ClassType.ARCHER);
    }

    @Test
    void testPlayerCharacterAbilityMap() {
        List<PlayerAbilityEntry> abilityList = api.player().playerCharacterAbilityMap("42nao", UUID.fromString("9cb823ee-9895-419a-bd1e-39d9243bc2ec"));
        Assertions.assertEquals(abilityList.stream().filter(s -> s.coordinateX() == 5 && s.coordinateY() == 1).findFirst().get().type(), AbilityMapType.ABILITY);
    }
}
