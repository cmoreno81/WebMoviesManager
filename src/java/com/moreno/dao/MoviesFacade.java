/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.moreno.dao;

import com.moreno.models.Movies;
import com.moreno.models.Roles;
import com.moreno.models.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;

/**
 *
 * @author cristina
 */
@Stateless
@LocalBean
public class MoviesFacade {

    @PersistenceContext(unitName = "WebMoviesManagerPU")
    private EntityManager em;

    public void create(@Valid Movies movie) {
        em.persist(movie);
    }

    public void update(@Valid Movies movie) {
        em.merge(movie);
    }

    public void delete(Movies movie) {
        if (!em.contains(movie)) {
            movie = em.merge(movie);
        }
        em.remove(movie);
    }

    public Movies findMovie(int id) {
        return em.find(Movies.class, id);
    }

    public List<Movies> findAllMovies() {
        Query moviesAllQuery = em.createNamedQuery("Movies.findAll");
        return moviesAllQuery.getResultList();
    }

    public List<Movies> findMoviesByName(String titulo) {
        Query movieNameQuery = em.createNamedQuery("Movies.findByTitulo");
        movieNameQuery.setParameter("titulo", titulo);
        return movieNameQuery.getResultList();
    }

    public List<Movies> findMoviesByGenero(String genero) {
        Query movieGeneroQuery = em.createNamedQuery("Movies.findByGenero");
        movieGeneroQuery.setParameter("genero", genero);
        return movieGeneroQuery.getResultList();
    }

    public List<Movies> findMoviesByFormato(String formato) {
        Query movieFormatoQuery = em.createNamedQuery("Movies.findByFormato");
        movieFormatoQuery.setParameter("formato", formato);
        return movieFormatoQuery.getResultList();
    }

    public List<Movies> findMoviesByVisto(boolean visto, String formato) {
        Query movieVistoQuery = em.createNamedQuery("Movies.findByVisto");
        movieVistoQuery.setParameter("visto", visto);
        movieVistoQuery.setParameter("formato", formato);
        return movieVistoQuery.getResultList();
    }

    public Object[] findTotal() {
        Query moviesTotalQuery = em.createNamedQuery("Movies.findAll");
        return (Object[]) moviesTotalQuery.getSingleResult();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void validateMovie(@Valid Movies movie) {
    }
    
    public void create(@Valid Usuario user) {
        em.persist(user);
    }

    public void update(@Valid Usuario user) {
        em.merge(user);
    }

    public void delete(Usuario user) {
        if (!em.contains(user)) {
            user = em.merge(user);
        }
        em.remove(user);
    }

    public Usuario findUsuario(int id) {
        return em.find(Usuario.class, id);
    }
    public Usuario findUsuarioByName(String usuario) {
        Query userNameQuery = em.createNamedQuery("Usuario.findByUsuario");
        userNameQuery.setParameter("usuario", usuario);
        return (Usuario) userNameQuery.getSingleResult();
    }
    
     public void create(@Valid Roles rol) {
        em.persist(rol);
    }

    public void update(@Valid Roles rol) {
        em.merge(rol);
    }

    public void delete(Roles rol) {
        if (!em.contains(rol)) {
            rol = em.merge(rol);
        }
        em.remove(rol);
    }

    public Roles findRoles(int id) {
        return em.find(Roles.class, id);
    }

}
