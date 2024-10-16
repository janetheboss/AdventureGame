package seeder;

import enums.PlayerClass;
import model.Player;
import service.PlayerService;

public class PlayerData {
    public static void seedPlayers(PlayerService playerService) {
        playerService.addPlayer(new Player("Alice", PlayerClass.warrior));
        playerService.addPlayer(new Player("Bob", PlayerClass.assassin));
        playerService.addPlayer(new Player("Charlie", PlayerClass.hunter));
        playerService.addPlayer(new Player("David", PlayerClass.mage));
        playerService.addPlayer(new Player("Eve", PlayerClass.druid));
        playerService.addPlayer(new Player("Frank", PlayerClass.monk));
        playerService.addPlayer(new Player("Grace", PlayerClass.paladin));
        playerService.addPlayer(new Player("Heidi", PlayerClass.paladin));
        playerService.addPlayer(new Player("Ivan", PlayerClass.priest));
        playerService.addPlayer(new Player("Judy", PlayerClass.samurai));
        playerService.addPlayer(new Player("Mallory", PlayerClass.warrior));
        playerService.addPlayer(new Player("Niaj",PlayerClass.priest));
        playerService.addPlayer(new Player("Olivia", PlayerClass.samurai));
        playerService.addPlayer(new Player("Peggy", PlayerClass.hunter));
        playerService.addPlayer(new Player("Rupert", PlayerClass.priest));
        playerService.addPlayer(new Player("Sybil", PlayerClass.mage));
        playerService.addPlayer(new Player("Trent", PlayerClass.hunter));
        playerService.addPlayer(new Player("Victor", PlayerClass.warrior));
        playerService.addPlayer(new Player("Walter", PlayerClass.druid));
        playerService.addPlayer(new Player("Xena", PlayerClass.priest));
        playerService.addPlayer(new Player("Yara", PlayerClass.samurai));
        playerService.addPlayer(new Player("Zane", PlayerClass.hunter));
        playerService.addPlayer(new Player("Quinn", PlayerClass.druid));
        playerService.addPlayer(new Player("Liam", PlayerClass.samurai));
        playerService.addPlayer(new Player("Sophia", PlayerClass.mage));
        playerService.addPlayer(new Player("Henry",PlayerClass.priest));
        playerService.addPlayer(new Player("Emma",PlayerClass.hunter));
        playerService.addPlayer(new Player("James", PlayerClass.druid));
        playerService.addPlayer(new Player("Lucas", PlayerClass.warrior));
        playerService.addPlayer(new Player("Amelia", PlayerClass.monk));
        playerService.addPlayer(new Player("Martin", PlayerClass.ninja));
    }
}
