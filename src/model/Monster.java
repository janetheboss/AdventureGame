package model;

public class Monster {
    private String name;
    private String race;
    private int attack;
    private int defense;
   private int health;
   private int specialAttack;
   private int specialDefense;

    public Monster(String name, String race, int attack, int defense, int health, int specialAttack, int specialDefense) {
        this.name = name;
        this.race = race;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }
}
