package com.example.WorkShop_JPA_SpringBoot_DATA.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="reserva")
public class Reserva {

    @Column
    private LocalDate fechaReserva;

    @JoinColumn(name="numero")
    @OneToOne(fetch = FetchType.EAGER)
    private Habitacion habitacion;

    @JoinColumn(name="cedula")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;
    @Id
    @Column
    private Integer codigoReserva;
    @Column
    private double totalPagar;

    public Reserva() {
    }

    public Reserva(LocalDate fechaReserva, Habitacion habitacion, Cliente cliente, double totalPagar, Integer codigoReserva) {
        this.fechaReserva = fechaReserva;
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.codigoReserva = codigoReserva;
        this.totalPagar = totalPagar;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Integer getCodigoReserva() {
        return codigoReserva;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCodigoReserva(Integer codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }
}
