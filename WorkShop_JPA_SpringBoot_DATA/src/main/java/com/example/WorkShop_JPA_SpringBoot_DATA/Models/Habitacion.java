package com.example.WorkShop_JPA_SpringBoot_DATA.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name="habitacion")
public class Habitacion {

    @Id
    @Column(name="numero")
    private Integer numero;
    @Column(name="tipoHabitacion")
    private String tipoHabitacion;
    @Column(name="precioBase")
    private double precioBase;

    @OneToOne(mappedBy = "habitacion")
    private Reserva reserva;



    public Habitacion() {
    }

    public Habitacion(Integer numero, String tipoHabitacion, double precioBase) {
        this.numero = numero;
        this.tipoHabitacion = tipoHabitacion;
        this.precioBase = precioBase;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }


}
