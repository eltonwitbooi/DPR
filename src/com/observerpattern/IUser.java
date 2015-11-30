package com.observerpattern;

public interface IUser {
	
	public void notifyUI(ISubject subject);
	public String getEmail();
	public void rate(String mediaName, int rank);
	// Media observed
	public void addMediaObserved(ISubject s);
	public void removeMediaObserved(ISubject s);
}
