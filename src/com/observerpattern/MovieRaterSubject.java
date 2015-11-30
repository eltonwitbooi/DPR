/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.observerpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Elton
 */
public class MovieRaterSubject implements ISubject {

    List<IObserver> observers;
    List<Movie> movies;
    List<Movie> topratedMovies; //for consumption by LuxuryObserver
    MovieRaterManager manager;

    public List<Movie> getTopratedMovies() {
        return topratedMovies;
    }

    //constructor
    public MovieRaterSubject(MovieRaterManager manager) {

        this.manager = manager;

        //init observer collection
        observers = new ArrayList();

        //initialise movie collections
        movies = new ArrayList();
        movies.add(new Movie("Spectre - James Bond"));
        movies.add(new Movie("Half of a Yellow Sun - Oyellowo"));
        movies.add(new Movie("Katutura - Hangula"));

        topratedMovies = new ArrayList<>();

    }

    @Override
    public void register(IObserver observer) {

        observers.add(observer);
    }

    @Override
    public void unRegister(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver o : observers) {
            o.update(movies);
            o.updateLuxuryObserver();
        }
    }

    public void updateRatings() {
        Random randomGenerator = new Random();

        int randomMovieIndex = randomGenerator.nextInt(movies.size());
        Movie selectedMovie = movies.get(randomMovieIndex);//select random movie

        int randomRating = randomGenerator.nextInt(5) + 1; //generates a rating between 1 and 5
        selectedMovie.rating = randomRating;//set rating

        updateTopRatedMovies(selectedMovie);

        //notify observers
        notifyObservers();

    }

    private void updateTopRatedMovies(Movie selectedMovie) {
        List<Movie> temp = new ArrayList<>();
        temp.addAll(topratedMovies);
        if (!temp.isEmpty() && temp.contains(selectedMovie)) {
            int index = temp.indexOf(selectedMovie);

            if (selectedMovie.getRating() >= 4) {
                topratedMovies.get(index).setRating(selectedMovie.getRating());//update it
            } else if (selectedMovie.getRating() < 4) {
                topratedMovies.remove(selectedMovie);//remove it if it's rating has dropped
            }

        } else {//if it is not in the list at all
            if (selectedMovie.rating >= 4) {
                topratedMovies.add(selectedMovie);//add it if it's rating is  4 or higher
            }
        }

    }

   

}
