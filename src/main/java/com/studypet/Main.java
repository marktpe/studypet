package com.studypet;

public class Main {
    public static void main(String[] args) {
        Pet myPet = new Pet("Byte");
        TaskManager manager = new TaskManager(myPet);

        // Add multiple tasks
        manager.addTask(new Task("1", "Finish Calc Homework", 50));
        manager.addTask(new Task("2", "Read CSE Chapter 3", 60));

        // Complete one task
        manager.completeTask("1");

        // Complete second task (should trigger level up!)
        manager.completeTask("2");
    }
}