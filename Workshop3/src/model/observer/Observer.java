package model.observer;

import java.util.ArrayList;
/*
 * Code provided by Tobias Ohlsson for the 1DV607 course.
 * Changes are made by Amelie Löwe and Johan Eriksson
 */

public abstract class Observer {
	private ArrayList<IObserver> observers = new ArrayList<IObserver>();

    public void addGameObserver(IObserver gameObserver){
        observers.add(gameObserver);
    }
    
    public void pingGameObserver(){
        for(int i=0;i<observers.size();i++){
            observers.get(i).infoToObservers();
        }
    }
}
