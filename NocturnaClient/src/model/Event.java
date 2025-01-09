/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import static java.sql.Date.valueOf;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author 2dam
 */
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long idEvent;
     
    private String nombre = "";
    
    private Date fecha = valueOf(LocalDate.now());
    
    private Integer numEntradas = 0;
    
    private Integer consumicion = 0;
    
    private Double precioEntrada = 0.0;
    
    /**
     * Constructor vacio
     */
    public Event() {
    }

    public Event(Long idEvent, Date fecha, Integer numEntradas, Integer consumicion, Double precioEntrada) {
        this.idEvent = idEvent;
        this.fecha = fecha;
        this.numEntradas = numEntradas;
        this.consumicion = consumicion; 
        this.precioEntrada = precioEntrada;
    }
    
    public Long getId() {
        return idEvent;
    }

    public void setId(Long idEvent) {
        this.idEvent = idEvent;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumEntradas() {
        return numEntradas;
    }

    public void setNumEntradas(int NumEntradas) {
        this.numEntradas = NumEntradas;
    }

    public int getConsumicion() {
        return consumicion;
    }

    public void setConsumicion(int consumicion) {
        this.consumicion = consumicion;
    }

    public Double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(Double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    
    @Override
    public String toString() {
        return "enties.EventEntity[ id=" + idEvent + " ]";
    }
    
}
