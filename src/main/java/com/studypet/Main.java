package com.studypet;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random rand = new Random();

        Pet myPet = new Pet("Byte");
        TaskManager manager = new TaskManager(myPet);

        System.out.println("--- Welcome to StudyPet! ---");

        boolean running = true;
        int nextTaskId = 1;

        while (running) {
            System.out.println("\n-------------------------------------------");
            System.out.print("Enter '1' (View Pet), '2' (Add Task), '3' (Complete Task), or 'q' (Quit): ");
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
                // Dynamically read task details from console
                System.out.print("Enter task title: ");
                String title = console.nextLine();

                System.out.print("Enter XP reward (e.g. 30): ");
                int xpReward = console.nextInt();
                console.nextLine(); // Clear newline buffer from scanner

                // Instantiate new Task and pass it to TaskManager
                String idStr = "" + nextTaskId;
                Task newTask = new Task(idStr, title, xpReward);
                manager.addTask(newTask);

                System.out.println("✅ Added Task #" + idStr + ": " + title + " (" + xpReward + " XP)");
                nextTaskId++;

            } else if (choice.equals("3")) {
                System.out.print("Enter Task ID to complete: ");
                String targetId = console.nextLine();

                manager.completeTask(targetId);

                // Roll for random bonus XP
                int bonusXp = rand.nextInt(21);
                if (bonusXp > 10) {
                    System.out.println("🎲 Critical hit! You found " + bonusXp + " bonus XP!");
                    myPet.addXp(bonusXp);
                }

            } else if (choice.equalsIgnoreCase("q")) {
                System.out.println("Goodbye! Keep up the studying!");
                running = false;
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
    }
}