package com.studypet;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task("1", "Finish Calc Homework", 50);

        System.out.println("Task: " + task1.getTitle());
        System.out.println("Is complete? " + task1.isCompleted());

        task1.markComplete();
        System.out.println("After marking complete: " + task1.isCompleted());
    }
}