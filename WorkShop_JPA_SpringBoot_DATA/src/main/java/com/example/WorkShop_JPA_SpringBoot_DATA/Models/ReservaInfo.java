package com.example.WorkShop_JPA_SpringBoot_DATA.Models;

import java.time.LocalDate;

public class ReservaInfo {
    private LocalDate fechaReserva;
    private double totalPagar;

    private  Integer codigoReserva;

    private Integer numeroHabitacion;

    public ReservaInfo() {

    }

    public ReservaInfo(LocalDate fechaReserva, double totalPagar, Integer codigoReserva, Integer numeroHabitacion) {
        this.fechaReserva = fechaReserva;
        this.totalPagar = totalPagar;
        this.codigoReserva = codigoReserva;
        this.numeroHabitacion = numeroHabitacion;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public Integer getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(Integer codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public Integer getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(Integer numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }
}
