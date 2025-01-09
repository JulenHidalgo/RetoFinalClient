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

/**
 *
 * @author 2dam
 */
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String dniComprador;

    private Long idEvento;

    private Set<String> dniAsistentes;

    private Double importeCompra;

    private Date fechaCompra;

    private Integer cantidad;

    private FormaPago formapago;

    public Ticket(String dniComprador, Long idEvento, Set<String> dniAsistentes, Double importeCompra, Integer cantidad, FormaPago formapago) {
        this.dniComprador = dniComprador;
        this.idEvento = idEvento;
        this.dniAsistentes = dniAsistentes;
        this.importeCompra = importeCompra;
        this.fechaCompra = valueOf(LocalDate.now());
        this.cantidad = cantidad;
        this.formapago = formapago;
    }

    public Ticket() {
    }

    public String getDniComprador() {
        return dniComprador;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public Set getDniAsistentes() {
        return dniAsistentes;
    }

    public Double getImporteCompra() {
        return importeCompra;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public FormaPago getFormapago() {
        return formapago;
    }

    public void setDniComprador(String dniComprador) {
        this.dniComprador = dniComprador;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public void setDniAsistentes(Set dniAsistentes) {
        this.dniAsistentes = dniAsistentes;
    }

    public void setImporteCompra(Double importeCompra) {
        this.importeCompra = importeCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setFormapago(FormaPago formapago) {
        this.formapago = formapago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "entities.Ticket[ id=" + id + " ]";
    }

}
