/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;
/**
 *
 * @author 2dam
 */
public class Client extends User implements Serializable {

    private String nombre;

    private String apellido;

    private String ciudad;

    private Integer telefono;

    private Date fechaNacimiento; 

    private String dni;
            
    public Client(){
        super();
        super.setIsAdmin(false);
    }

    public Client(String nombre, String apellido, String ciudad, Integer telefono, Date fechaNacimiento, String dni, String mail, String passwd) {
        super(mail, passwd, false);
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fehcaNacimiento) {
        this.fechaNacimiento = fehcaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
}
