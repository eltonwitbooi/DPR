package com.observerpattern;

public class RatingObserver implements IObserver {
	
	private IUser user;
	private ISubject subject;
	
	public RatingObserver(ISubject subject, IUser user) {
		// TODO Auto-generated constructor stub
		this.setUser(user);
		this.setSubject(subject);
		this.getSubject().register(this);
		this.getUser().addMediaObserved(subject);
	}

	// Push interface
	@Override
	public void update(ISubject subject) {
		// TODO Auto-generated method stub
		getUser().notifyUI(subject);
	}

	
	// Pull interface
	@Override
	public void update() {
		// TODO Auto-generated method stub
		getUser().notifyUI(this.getSubject());
	}

	public ISubject getSubject() {
		return subject;
	}

	public void setSubject(ISubject subject) {
		this.subject = subject;
	}

	public IUser getUser() {
		return user;
	}

	public void setUser(IUser user) {
		this.user = user;
	}
	
	

}
