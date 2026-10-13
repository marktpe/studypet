package com.studypet;

public class Main {
    public static void main(String[] args) {
        Pet myPet = new Pet("Byte");
        Task task1 = new Task("1", "Finish Homework", 120);

        System.out.println(myPet.getName() + " starts at Level " + myPet.getLevel() + " with " + myPet.getCurrentXp() + " XP.");

        // Complete task and reward pet
        task1.markComplete();
        if (task1.isCompleted()) {
            myPet.addXp(task1.getXpReward());
        }

        System.out.println(myPet.getName() + " now has " + myPet.getCurrentXp() + " XP (Level " + myPet.getLevel() + ").");
    }
}