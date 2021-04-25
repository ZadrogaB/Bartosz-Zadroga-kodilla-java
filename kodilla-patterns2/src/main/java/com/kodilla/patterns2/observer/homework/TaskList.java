package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class TaskList implements Observable{
    private final Observer mentor;
    private List<String> tasks = new ArrayList<>();

    public TaskList(Observer mentor) {
        this.mentor = mentor;
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        mentor.update(this);
    }

    public List<String> getTasks() {
        return tasks;
    }
}
