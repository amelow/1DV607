package model.observer;

import java.util.ArrayList;

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
