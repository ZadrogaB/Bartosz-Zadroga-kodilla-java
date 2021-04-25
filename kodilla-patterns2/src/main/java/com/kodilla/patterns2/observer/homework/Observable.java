package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.homework.Observer;

public interface Observable {
    void registerObserver(Observer observer);
    void notifyObservers();
}
