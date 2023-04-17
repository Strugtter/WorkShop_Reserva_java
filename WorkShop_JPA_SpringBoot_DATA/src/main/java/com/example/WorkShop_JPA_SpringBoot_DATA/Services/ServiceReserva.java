package com.example.WorkShop_JPA_SpringBoot_DATA.Services;

import com.example.WorkShop_JPA_SpringBoot_DATA.Models.Cliente;
import com.example.WorkShop_JPA_SpringBoot_DATA.Models.Habitacion;
import com.example.WorkShop_JPA_SpringBoot_DATA.Models.Reserva;
import com.example.WorkShop_JPA_SpringBoot_DATA.Models.ReservaInfo;
import com.example.WorkShop_JPA_SpringBoot_DATA.Repository.ClienteRepository;
import com.example.WorkShop_JPA_SpringBoot_DATA.Repository.HabitacionRepository;
import com.example.WorkShop_JPA_SpringBoot_DATA.Repository.ReservaRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.stream.Collectors;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;


@Service
public class ServiceReserva {

    private ReservaRepository reservaRepository;
    private HabitacionRepository habitacionRepository;
    private ClienteRepository clienteRepository;

    @Autowired
    public ServiceReserva(HabitacionRepository habitacionRepository, ClienteRepository clienteRepository, ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
        this.habitacionRepository = habitacionRepository;
        this.clienteRepository = clienteRepository;
    }

    public ReservaInfo crearReserva(Integer numHabitacion, LocalDate fecha, Integer DinCliente) {
        Reserva reserva = new Reserva(fecha, this.habitacionRepository.findByNumero(numHabitacion), this.clienteRepository.findByCedula(DinCliente), this.habitacionRepository.findByNumero(numHabitacion).getPrecioBase(), new Random().nextInt(1000000));
        ReservaInfo reservaInfo = new ReservaInfo(reserva.getFechaReserva(), reserva.getTotalPagar(), reserva.getCodigoReserva(), reserva.getHabitacion().getNumero());
        reservaRepository.save(reserva);
        return reservaInfo;
    }



    public List<Reserva> buscarReservaPorCliente(Integer cedula){
        Cliente cliente = this.clienteRepository.findByCedula(cedula);
        return this.reservaRepository.findByCliente(cliente);
    }

    public  List<Habitacion> buscarHabitacionesDisponibles(LocalDate fecha, String tipoHabitacion){
        List<Reserva> reservaFecha = this.reservaRepository.findByFechaReserva(fecha);
        List<Habitacion> habitacionesNoDisponibles = new ArrayList<>();
        for(Reserva HabitacionesReservadas: reservaFecha){
            habitacionesNoDisponibles.add(HabitacionesReservadas.getHabitacion());
        }
        List<Habitacion> todasLasHabitaciones = this.habitacionRepository.findAll();
        List<Habitacion> habitacionesDisponibles = new ArrayList<>(todasLasHabitaciones);
        habitacionesDisponibles.removeAll(habitacionesNoDisponibles);
        List<Habitacion> habitacionDisponiblesParaReservar = habitacionesDisponibles.stream()
                .filter(h -> h.getTipoHabitacion().equals(tipoHabitacion))
                .collect(Collectors.toList());
        return  habitacionDisponiblesParaReservar;
    }

}

