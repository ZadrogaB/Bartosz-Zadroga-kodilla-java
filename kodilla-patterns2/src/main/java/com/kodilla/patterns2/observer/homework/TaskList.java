package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.homework.Observer;

import java.util.ArrayList;
import java.util.List;

public class TaskList implements Observable {
    private final List<Observer> observers;
    private final List<String> tasks;
    private final String name;

    public TaskList(String name) {
        observers = new ArrayList<>();
        tasks = new ArrayList<>();
        this.name = name;
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public List<String> getTasks() {
        return tasks;
    }
}
