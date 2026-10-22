package com.studypet;

public class Task {
    private String id;
    private String title;
    private int xpReward;
    private boolean completed; // Tracks whether task is finished

    public Task(String id, String title, int xpReward) {
        this.id = id;
        this.title = title;
        this.xpReward = xpReward;
        this.completed = false; // Tasks start as incomplete by default
    }

    // --- Getters ---
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getXpReward() {
        return xpReward;
    }

    // Getter for boolean status
    public boolean isCompleted() {
        return completed;
    }

    // --- Setter ---
    // ADD THIS METHOD: Allows TaskManager to mark task as done
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}