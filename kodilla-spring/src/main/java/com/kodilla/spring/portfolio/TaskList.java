package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<String> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String newTask){
        tasks.add(newTask);
    }

    public String getTask(int number){
        String result = tasks.get(number);
        return result;
    }
}
