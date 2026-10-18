package com.studypet;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random rand = new Random();

        Pet myPet = new Pet("Byte");
        TaskManager manager = new TaskManager(myPet);

        // Pre-load a couple of tasks to work with
        manager.addTask(new Task("1", "Read CSE Chapter 4", 40));
        manager.addTask(new Task("2", "Practice For Loops", 50));

        System.out.println("--- Welcome to StudyPet! ---");
        System.out.print("Enter '1' to view pet, '2' to complete task 1, or 'q' to quit: ");
        String choice = console.nextLine();

        if (choice.equals("1")) {
            System.out.println("\nPet Name: " + myPet.getName());
            System.out.println("Level: " + myPet.getLevel());
            System.out.print("XP Progress: [");

            // Definite for loop: prints a character for each chunk of XP
            int progressBlocks = myPet.getCurrentXp() / 10;
            for (int i = 0; i < progressBlocks; i++) {
                System.out.print("=");
            }
            System.out.println("] " + myPet.getCurrentXp() + "/" + myPet.getXpToNextLevel() + " XP");

        } else if (choice.equals("2")) {
            // Complete task 1
            manager.completeTask("1");

            // Random bonus XP calculation
            int bonusXp = rand.nextInt(21); // Random integer from 0 to 20
            if (bonusXp > 10) {
                System.out.println("🎲 Critical hit! You found " + bonusXp + " bonus XP!");
                myPet.addXp(bonusXp);
            }

        } else if (choice.equalsIgnoreCase("q")) {
            System.out.println("Goodbye!");
        } else {
            System.out.println("Invalid choice!");
        }
    }
}