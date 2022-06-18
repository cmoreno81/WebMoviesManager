/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moreno.dao;

import com.moreno.models.Genero;
import com.moreno.models.Movies;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author cristina
 */
//Ámbito 'RequestScope': los objetos creados con este ámbito solo existen 
//mientras lo haga la petición HTTP a la que están asociados
// Otros ámbitos: @SessionScope, @ApplicationScoped
@RequestScoped
@Named("mm")
public class MoviesManager {

    @EJB
    private MoviesFacade moviesFacade;

    private List<Movies> movies;
    private Genero genero;
    private Movies movie;
    private String status;
    private boolean errors;

    public MoviesManager() {

    }

    public void create(Movies movie) {
        moviesFacade.create(movie);
    }

    public void update(Movies movie) {
        moviesFacade.update(movie);
    }

    public void delete(Movies movie) {
        moviesFacade.delete(movie);
    }

    public Movies findMovie(int id) {
        return moviesFacade.findMovie(id);
    }

    public List<Movies> findAllMovies() {
        return moviesFacade.findAllMovies();
    }

    public List<Movies> findMoviesByName(String titulo) {
        return moviesFacade.findMoviesByName(titulo);
    }

    public List<Movies> findMoviesByFormato(String formato) {
        return moviesFacade.findMoviesByFormato(formato);
    }

    public List<Movies> findMoviesByVisto(boolean visto, String formato) {
        return moviesFacade.findMoviesByVisto(visto, formato);
    }

    public List<Movies> getMovies() {
        return movies;
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isErrors() {
        return errors;
    }

    public void setErrors(boolean errors) {
        this.errors = errors;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

}
