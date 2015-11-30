package com.observerpattern.UserInterface;

import javax.swing.DefaultListModel;

public class MoviesList extends DefaultListModel<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void update(int index)
    {
        fireContentsChanged(this, index, index);
    }
}
