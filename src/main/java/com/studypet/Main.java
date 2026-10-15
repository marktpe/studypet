package com.studypet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Pet myPet = new Pet("Byte");
        TaskManager manager = new TaskManager(myPet);

        System.out.println("--- Welcome to StudyPet! ---");
        System.out.print("Enter '1' to view pet, '2' to add task, or 'q' to quit: ");
        String choice = console.nextLine();

        // Check user decision using string equality and if/else logic
        if (choice.equals("1")) {
            System.out.println(myPet.getName() + " - Level " + myPet.getLevel() + " (" + myPet.getCurrentXp() + " XP)");
        } else if (choice.equals("2")) {
            System.out.print("Enter task title: ");
            String title = console.nextLine();
            manager.addTask(new Task("1", title, 50));
        } else if (choice.equalsIgnoreCase("q")) {
            System.out.println("Goodbye!");
        } else {
            System.out.println("Invalid choice!");
        }
    }
}