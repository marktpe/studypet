package com.studypet;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random rand = new Random();

        Pet myPet = new Pet("Byte");
        TaskManager manager = new TaskManager(myPet);

        // Pre-load a task to test with
        manager.addTask(new Task("1", "Read CSE Chapter 4", 40));

        System.out.println("--- Welcome to StudyPet! ---");

        // Sentinel-controlled indefinite loop
        boolean running = true;
        while (running) {
            System.out.println("\n-------------------------------------------");
            System.out.print("Enter '1' (View Pet), '2' (Complete Task 1), or 'q' (Quit): ");
            String choice = console.nextLine();

            if (choice.equals("1")) {
                System.out.println("\nPet Name: " + myPet.getName());
                System.out.println("Level: " + myPet.getLevel());
                System.out.print("XP Progress: [");

                int progressBlocks = myPet.getCurrentXp() / 10;
                for (int i = 0; i < progressBlocks; i++) {
                    System.out.print("=");
                }
                System.out.println("] " + myPet.getCurrentXp() + "/" + myPet.getXpToNextLevel() + " XP");

            } else if (choice.equals("2")) {
                manager.completeTask("1");

                int bonusXp = rand.nextInt(21);
                if (bonusXp > 10) {
                    System.out.println("🎲 Critical hit! You found " + bonusXp + " bonus XP!");
                    myPet.addXp(bonusXp);
                }

            } else if (choice.equalsIgnoreCase("q")) {
                System.out.println("Goodbye! Thanks for playing StudyPet.");
                running = false; // Breaks out of the loop
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
    }
}