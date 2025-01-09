/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author 2dam
 */
public class Artist implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long idArtist;

    protected String nombre;
    
    protected String tipoMusica;
    
    protected String descripcion;

    public Artist() {

    }

    public Artist(Long idArtist, String nombre, String tipoMusica, String descripcion) {
        this.idArtist = idArtist;
        this.nombre = nombre;
        this.tipoMusica = tipoMusica;
        this.descripcion = descripcion;
    }
    
    public Long getId() {
        return idArtist;
    }

    public void setId(Long idArtista) {
        this.idArtist = idArtista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoMusica() {
        return tipoMusica;
    }

    public void setTipoMusica(String tipoMusica) {
        this.tipoMusica = tipoMusica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "entities.ArtistEntity[ id=" + idArtist + " ]";
    }

}
