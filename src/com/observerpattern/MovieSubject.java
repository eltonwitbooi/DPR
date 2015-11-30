/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.observerpattern;
import java.util.ArrayList;
/**
 *
 * @author Elton
 */
public class MovieSubject implements ISubject{

	private String movieName;
	private String description;
	private int year;
	private double rating;
	private int userNumb;
	
	ArrayList<IObserver> usersSubscribed;
	
	
	public MovieSubject(String name, String desc, int year){
		this.movieName = name;
		this.description = desc;
		this.year = year;
		// meaning: not rated yet.
		this.rating = 0; 
		this.userNumb = 0;
		// List of observers
		this.usersSubscribed = new ArrayList<>();
	}
	
	@Override
    public void register(IObserver observer) {
		int index = usersSubscribed.indexOf(observer);
		if(index == -1){
			usersSubscribed.add(observer);
		}
	}

    @Override
    public void unRegister(IObserver observer) {
    	int index = 0;
    	for(int i = 0 ; i < usersSubscribed.size(); i ++){
    		if(usersSubscribed.get(i).equals(observer)) index = i;
    	}
    	if(index > -1){
    		usersSubscribed.remove(index);
    	}
    }

    @Override
    public void notifyObservers() {
    	for(IObserver o : this.usersSubscribed){
    			o.update(this);
    	}
    }
    
	@Override
	public ArrayList<IObserver> getObservers() {
		// TODO Auto-generated method stub
		return this.usersSubscribed;
	}

	public double vote(int value){
		userNumb++;
		rating += value;
		this.rating = rating/userNumb ;
		notifyObservers();
		return this.rating;
	}
	
	
	@Override
	public String getName() {
		return this.movieName;
	}



	
}
