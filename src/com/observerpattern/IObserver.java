/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.observerpattern;

import java.util.List;

/**
 *
 * @author Elton
 */
public interface IObserver {
    
    public void update(List<Movie> movies);//push interface
    public void updateLuxuryObserver();//for pull interface
    
    
}
