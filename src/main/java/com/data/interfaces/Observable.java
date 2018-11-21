package com.data.interfaces;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyAllObservers();
}
