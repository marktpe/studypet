package com.studypet;

public class Pet {
    // 1. Private fields}
    private String name;
    private int level;
    private int currentXp;
    private int xpToNextLevel;

    // 2. Constructor
    public Pet(String name) {
        this.name = name;
        this.level = 1;
        this.currentXp = 0;
        this.xpToNextLevel = 100; // Default 100 XP per level
    }

    // 3. Action method to award XP and handle leveling up
    public void addXp(int amount) {
        this.currentXp += amount;
        while (this.currentXp >= this.xpToNextLevel) {
            this.currentXp -= this.xpToNextLevel;
            this.level++;
            System.out.println("🎉 " + name + " leveled up to Level " + level + "!");
        }
    }

    // 4. Getters
    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getCurrentXp() { return currentXp; }
    public int getXpToNextLevel() { return xpToNextLevel; }
}
