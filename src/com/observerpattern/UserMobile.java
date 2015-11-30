/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.observerpattern;

import java.util.ArrayList;

import com.clockworksms.ClockWorkSmsService;
import com.clockworksms.ClockworkException;
import com.clockworksms.ClockworkSmsResult;
import com.clockworksms.SMS;
import com.observerpattern.UserInterface.UserGUI;


/**
 *
 * @author Elton
 */
public class UserMobile implements IUser{
	
	private String email;
	private double telephoneNumber;
	private UserGUI form;
	private MovieRaterManager mvr;
	// Movies the user is being looking at.
	
	public UserMobile(String email, double tel, MovieRaterManager mvr) {
		this.email = email;
		this.telephoneNumber = tel;
		this.mvr = mvr; 		
		this.form = new UserGUI(this);
		this.form.run(this.form);
	}
	
	
	@Override
	public void notifyUI(ISubject subject) {
		// TODO Auto-generated method stub
		this.form.notifyChange(subject);
		this.sendSMS();
	}
	
	/**
	 * Send an sms to the user owning a telephone number
	 */
	public void sendSMS(){
		ClockWorkSmsService clockWorkSmsService;
		try {
			clockWorkSmsService = new ClockWorkSmsService("");
			SMS sms = new SMS(Double.toString(this.telephoneNumber), "Hello World");    
        	ClockworkSmsResult result = clockWorkSmsService.send(sms);
		} catch (ClockworkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
    /*
     * Getter and setters 
     */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(int telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}


	@Override
	public void addMediaObserved(ISubject s) {
		// TODO Auto-generated method stub
		this.form.addMedia(s.getName());
	}


	@Override
	public void removeMediaObserved(ISubject s) {
		// TODO Auto-generated method stub
		this.form.removeMedia(s.getName());
	}


	@Override
	public void rate(String name,int rank) {
		this.mvr.getMedia(name).vote(rank);
	}

	
	


	
    
}
