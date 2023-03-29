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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;


@Service
public class ServiceReserva {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public ReservaInfo crearReserva(Integer numHabitacion, LocalDate fecha, Integer DinCliente) {
        Reserva reserva = new Reserva();
        ReservaInfo reservaInfo = new ReservaInfo();
        reserva.setFechaReserva(fecha);
        reserva.setHabitacion(this.habitacionRepository.findByNumero(numHabitacion));
        reserva.setCliente(this.clienteRepository.findByCedula(DinCliente));
        reserva.setTotalPagar(this.habitacionRepository.findByNumero(numHabitacion).getPrecioBase());
        Random random = new Random();
        reserva.setCodigoReserva(random.nextInt(1000000)); // Genera un valor aleatorio entero de hasta 6 dígitos
        reservaRepository.save(reserva);
        reservaInfo.setFechaReserva(reserva.getFechaReserva());
        reservaInfo.setTotalPagar(reserva.getTotalPagar());
        reservaInfo.setCodigoReserva(reserva.getCodigoReserva());
        reservaInfo.setNumeroHabitacion(reserva.getHabitacion().getNumero());
        return reservaInfo;
    }

    public List<Reserva> buscarReservaPorCliente(Integer cedula){
        Cliente cliente = this.clienteRepository.findByCedula(cedula);
        return this.reservaRepository.findByCliente(cliente);
    }

    public  List<Habitacion> buscarHabitacionesDisponibles(LocalDate fecha, String tipoHabitacion){

        Reserva reservaFecha = this.reservaRepository.findByFechaReserva(fecha);
        List<Habitacion> habitacionesDisponibles = new ArrayList<>();
        habitacionesDisponibles.add(reservaFecha.getHabitacion());
        return  habitacionesDisponibles;
    }


}
