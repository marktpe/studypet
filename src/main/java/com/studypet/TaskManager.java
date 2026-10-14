package com.studypet;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private Pet pet;

    public TaskManager(Pet pet) {
        this.tasks = new ArrayList<>();
        this.pet = pet;
    }

    // Add a new task to the list
    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Added task: " + task.getTitle());
    }

    // Complete a task by its ID and automatically award XP to the pet
    public boolean completeTask(String id) {
        for (Task task : tasks) {
            if (task.getId().equals(id) && !task.isCompleted()) {
                task.markComplete();
                pet.addXp(task.getXpReward());
                System.out.println("Completed: " + task.getTitle() + " (+" + task.getXpReward() + " XP)");
                return true;
            }
        }
        System.out.println("Task with ID " + id + " not found or already completed.");
        return false;
    }

    // Get all tasks
    public List<Task> getTasks() {
        return tasks;
    }
}