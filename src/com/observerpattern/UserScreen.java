/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.observerpattern;

import java.util.ArrayList;

import com.observerpattern.UserInterface.UserGUI;

/**
 *
 * @author Lorenzo
 */
public class UserScreen implements IUser{

	private String email;
	private UserGUI form;
	private ArrayList<IObserver> observers ;
	
	/**
	 * TO BE IMPLEMENTED
	 * @param email
	 * @param form
	 */
	public UserScreen(String email, UserGUI form) {
		this.setEmail(email);
		this.form = new UserGUI(this);
		this.form.run(this.form);
	}
	


	@Override
	public void notifyUI(ISubject s) {
		// TODO Auto-generated method stub
		this.form.notifyChange(s);
	}

	@Override
	public void addMediaObserved(ISubject s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeMediaObserved(ISubject s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rate(String mediaName, int rank) {
		// TODO Auto-generated method stub
		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
