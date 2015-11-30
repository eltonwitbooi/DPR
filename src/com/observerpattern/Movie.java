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
public class Movie {
    
    String name;
    int rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    //constructor
    public Movie(String name){
        this.name = name;
        this.rating = 0; //set initial rating to 0.
    }
    
}
