package com.studypet;

public class Task {
    // 1. Private Fields (Encapsulation)
    private String id;
    private String title;
    private int xpReward;
    private boolean completed;

    // 2. Constructor
    public Task(String id, String title, int xpReward) {
            this.id = id;
            this.title = title;
            this.xpReward = xpReward;
            this.completed = false; // Tasks start incomplete by default
    }

    // 3. Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public int getXpReward() { return xpReward; }
    public boolean isCompleted() { return completed; }

    // 4. Action method
    public void markComplete() {
        this.completed = true;
    }
}
