/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 2dam
 */
public class Club implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nombre;

    private String ubicacion;

    private String ciudad;

    private String instagram;

    public Club() {
        
    }

    public Club(Long id, String nombre, String ubicacion, String ciudad, String instagram) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.ciudad = ciudad;
        this.instagram = instagram;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getInstagram() {
        return instagram;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

}
