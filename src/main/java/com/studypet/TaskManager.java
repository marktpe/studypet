package com.studypet;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private Pet pet;

    public TaskManager(Pet pet) {
        this.pet = pet;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    // ADD THIS METHOD: Searches for a task by ID and removes it
    public boolean removeTask(String id) {
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            if (t.getId().equals(id)) {
                tasks.remove(i);
                return true; // Successfully found and removed
            }
        }
        return false; // Task ID was not found
    }

    public List<Task> getPendingTasks() {
        List<Task> pending = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            if (!t.isCompleted()) {
                pending.add(t);
            }
        }
        return pending;
    }

    public void completeTask(String id) {
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            if (t.getId().equals(id) && !t.isCompleted()) {
                t.setCompleted(true);
                pet.addXp(t.getXpReward());
                System.out.println("🎉 Completed task: " + t.getTitle() + "! Earned " + t.getXpReward() + " XP.");
                return;
            }
        }
        System.out.println("❌ Task ID not found or already completed!");
    }
}