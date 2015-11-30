/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.observerpattern;

import java.util.ArrayList;

import com.observerpattern.UserInterface.GUI;
import com.observerpattern.UserInterface.UserGUI;

/**
 *
 * @author Elton
 */
public class MovieRaterManager {

	// Movies are being observed in the system but they both 
	// are unique in the system.
	private ArrayList<IUser> users;
	private ArrayList<ISubject> medias;
	private ArrayList<RatingObserver> observers;
   //TODO: Create GUI
	protected GUI userInterface; 
    /**
     * 
     */
	public MovieRaterManager()
	{
		
		this.users= new ArrayList<>();
		this.medias= new ArrayList<>();
		this.observers = new ArrayList<>();
		// Add dummy data (Observers)
		this.addMovie(new MovieSubject("Titanic", "A good movie about a sinking ship.", 1999));
		this.addMovie(new MovieSubject("Shrek", "An orc and a donkey", 2001));
		this.addMovie(new MovieSubject("Bambi", "Sad cartoon about a sweet dear.", 1950));
		this.addMovie(new MovieSubject("", "A good movie about a sinking ship.", 1999));
		// Add user data (Subjects)		
		this.addUser(new UserMobile("lore.verri@gmail.com", 0634527222, this));
		this.addUser(new UserMobile("gigi.d@gmail.ci", 0634527222, this));
		
		userInterface = new GUI(this);
		userInterface.run();
	}

	/**
	 * 
	 * @param movieName
	 */
	public void addObserverToSubject(String nameUser, String nameMedia)
	{
		int i;
		int usersLength = this.getUsers().size();
		int mediaLength = this.getMedias().size();
		
		IUser user = null;
		ISubject media = null;
		
		for(i = 0 ; i < usersLength; i++ ){
			if(this.getUsers().get(i).getEmail() == nameUser){
				user = this.getUsers().get(i);
			}
		}
		for(i = 0 ; i < mediaLength; i++){
			if(this.getMedias().get(i).getName() == nameMedia){
				media = this.getMedias().get(i);
			}
				
		}
		
		//System.out.println(user.getEmail() + " is now watching" + media.getName());
		this.observers.add(new RatingObserver(media, user));
	}
	
	/**
	 * 
	 * @param user
	 * @param media
	 */
	public void removeObserverFromSubject(String nameUser, String nameMedia)
	{
		int i;
		int mediaLength = this.getMedias().size();
		
		ISubject media = null;
		IUser user = null;
		
		for(i = 0 ; i < mediaLength; i++){
			if(this.getMedias().get(i).getName() == nameMedia){
				media = this.getMedias().get(i);
			}
				
		}
		
		for(i = 0 ; i < getUsers().size(); i++){
			if(this.getUsers().get(i).getEmail() == nameUser){
				user = this.getUsers().get(i);
			}
				
		}
		user.removeMediaObserved(media);
		
		for(i = 0; i < this.observers.size(); i ++){
			if(this.observers.get(i).getSubject().getName() == nameMedia && this.observers.get(i).getUser().getEmail() == nameUser){
				media.unRegister(this.observers.get(i));
				
			}
		}	
		
		
	}
	
	/**
	 * 
	 */
	public ISubject getMedia(String name){
		for(ISubject s : medias){
			if (s.getName() == name) return s;
		}
		return null;
	}
	
	/**
	 * 
	 * @param name
	 * @param tel
	 */
	public void addUser(IUser user){
		getUsers().add(user);
	}
	/**
	 * 
	 * @param user
	 */
	public void removeUser(IObserver user){
		int userIndex = getUsers().indexOf(user);
		getUsers().remove(userIndex);
	}

	/**
	 * 
	 * @param movieName
	 * @param movieDescription
	 * @param yearRelease
	 */
	public void addMovie(ISubject movie)
	{
		getMedias().add(movie);
	}

	public ArrayList<IUser> getUsers() {
		return users;
	}


	public ArrayList<ISubject> getMedias() {
		return medias;
	}

	
	
	
	
}
