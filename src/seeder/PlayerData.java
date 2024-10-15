package seeder;

import model.Player;
import service.PlayerService;

public class PlayerData {
    public static void seedPlayers(PlayerService playerService) {
        playerService.addPlayer(new Player("Alice", "Warrior"));
        playerService.addPlayer(new Player("Bob", "Mage"));
        playerService.addPlayer(new Player("Charlie", "Archer"));
        playerService.addPlayer(new Player("David", "Paladin"));
        playerService.addPlayer(new Player("Eve", "Thief"));
        playerService.addPlayer(new Player("Frank", "Bard"));
        playerService.addPlayer(new Player("Grace", "Sorceress"));
        playerService.addPlayer(new Player("Heidi", "Druid"));
        playerService.addPlayer(new Player("Ivan", "Monk"));
        playerService.addPlayer(new Player("Judy", "Necromancer"));
        playerService.addPlayer(new Player("Mallory", "Ranger"));
        playerService.addPlayer(new Player("Niaj", "Cleric"));
        playerService.addPlayer(new Player("Olivia", "Warlock"));
        playerService.addPlayer(new Player("Peggy", "Assassin"));
        playerService.addPlayer(new Player("Rupert", "Berserker"));
        playerService.addPlayer(new Player("Sybil", "Summoner"));
        playerService.addPlayer(new Player("Trent", "Spellblade"));
        playerService.addPlayer(new Player("Victor", "Elementalist"));
        playerService.addPlayer(new Player("Walter", "Knight"));
        playerService.addPlayer(new Player("Xena", "Valkyrie"));
        playerService.addPlayer(new Player("Yara", "Enchanter"));
        playerService.addPlayer(new Player("Zane", "Hunter"));
        playerService.addPlayer(new Player("Quinn", "Rogue"));
        playerService.addPlayer(new Player("Liam", "Alchemist"));
        playerService.addPlayer(new Player("Sophia", "Priestess"));
        playerService.addPlayer(new Player("Henry", "Warrior"));
        playerService.addPlayer(new Player("Emma", "Sorcerer"));
        playerService.addPlayer(new Player("James", "Knight"));
        playerService.addPlayer(new Player("Lucas", "Druid"));
        playerService.addPlayer(new Player("Amelia", "Monk"));
        playerService.addPlayer(new Player("Martin", "Paladin"));
    }
}
