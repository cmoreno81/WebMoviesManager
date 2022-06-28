/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moreno.dao;

import com.moreno.models.Genero;
import com.moreno.models.Movies;
import com.moreno.models.Roles;
import com.moreno.models.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author cristina
 */
//Ámbito 'RequestScoped': los objetos creados con este ámbito solo existen 
//mientras lo haga la petición HTTP a la que están asociados
// Otros ámbitos: @SessionScoped, @ApplicationScoped
@SessionScoped
@Named("mm")
public class MoviesManager implements Serializable{

    @EJB
    private MoviesFacade moviesFacade;

    private Usuario usuario;
    private Roles rol;
    private List<Movies> movies;
    private Genero genero;
    private Movies movie;
    private String status;
    private boolean errors;

    public MoviesManager() {

    }

    public MoviesFacade getMoviesFacade() {
        return moviesFacade;
    }

    public void setMoviesFacade(MoviesFacade moviesFacade) {
        this.moviesFacade = moviesFacade;
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

    public List<Movies> findMoviesByGenero(String genero) {
        return moviesFacade.findMoviesByGenero(genero);
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

    public void create(Usuario user) {
        moviesFacade.create(user);
    }

    public void update(Usuario user) {
        moviesFacade.update(user);
    }

    public void delete(Usuario user) {
        moviesFacade.delete(user);
    }

    public Usuario findByUser(String usuario) {
        return moviesFacade.findUsuarioByName(usuario);
    }

    public void create(Roles rol) {
        moviesFacade.create(rol);
    }

    public void update(Roles rol) {
        moviesFacade.update(rol);
    }

    public void delete(Roles rol) {
        moviesFacade.delete(rol);
    }

    public Roles findRoles(int id) {
        return moviesFacade.findRoles(id);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

}
