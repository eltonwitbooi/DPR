/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.observerpattern;

/**
 *
 * @author Elton
 */
public interface IObserver {
    // push update
	public void update(ISubject subject);
    // pull update
    public void update();
   
}
