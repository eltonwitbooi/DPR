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
public interface ISubject {
    
    public void register(IObserver observer);
    public void unRegister(IObserver observer);
    public void notifyObservers();
    public void notifyGUI();
}
