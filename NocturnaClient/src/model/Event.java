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
import javax.validation.constraints.Future;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author 2dam
 */

@XmlRootElement
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long idEvent;
     
    private String nombre = "";
    
    @Future
    private Date fecha = valueOf(LocalDate.now());
    
    private Integer NumEntradas = 0;
    
    private Integer consumicion = 0;
    
    private Double precioEntrada = 0.0;
    
    private Club club; 
    
    private Set<Artist> artists;
    
    private Set<Ticket> tickets;
    
    /**
     * Constructor vacio
     */
    public Event() {
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
        return NumEntradas;
    }

    public void setNumEntradas(int NumEntradas) {
        this.NumEntradas = NumEntradas;
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
 
    public Club getClub(){
       return this.club;    
    }

    public void setClub(Club club) {
        this.club = club;
    }
    

    public Set<Artist> getArtits(){
       return  this.artists;     
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }
    
    @XmlTransient
    public Set<Ticket> getTickets(){
       return this.tickets;
        
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvent != null ? idEvent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.idEvent == null && other.idEvent != null) || (this.idEvent != null && !this.idEvent.equals(other.idEvent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enties.EventEntity[ id=" + idEvent + " ]";
    }
    
}