package com.example.WorkShop_JPA_SpringBoot_DATA;

import com.example.WorkShop_JPA_SpringBoot_DATA.Models.Cliente;
import com.example.WorkShop_JPA_SpringBoot_DATA.Models.Habitacion;
import com.example.WorkShop_JPA_SpringBoot_DATA.Models.Reserva;
import com.example.WorkShop_JPA_SpringBoot_DATA.Models.ReservaInfo;
import com.example.WorkShop_JPA_SpringBoot_DATA.Repository.ClienteRepository;
import com.example.WorkShop_JPA_SpringBoot_DATA.Repository.HabitacionRepository;
import com.example.WorkShop_JPA_SpringBoot_DATA.Repository.ReservaRepository;
import com.example.WorkShop_JPA_SpringBoot_DATA.Services.ServiceReserva;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class ServiceReservaTest {


    ReservaRepository reservaRepository;

    HabitacionRepository habitacionRepository;

    ClienteRepository clienteRepository;

    ServiceReserva serviceReserva;

    @BeforeEach
    public void setUp() {
        habitacionRepository = mock(HabitacionRepository.class);
        clienteRepository = mock(ClienteRepository.class);
        reservaRepository = mock(ReservaRepository.class);
        serviceReserva = new ServiceReserva(habitacionRepository, clienteRepository, reservaRepository);
    }



    @Test
    public void testBuscarHabitacionesDisponibles() {

        LocalDate fecha = LocalDate.now();
        String tipoHabitacion = "Premium";

        List<Reserva> reservaFecha = new ArrayList<>();
        Reserva reserva = new Reserva();

        Habitacion habitacion = new Habitacion();
        habitacion.setTipoHabitacion(tipoHabitacion);

        reserva.setFechaReserva(fecha);
        reserva.setHabitacion(habitacion);
        reservaFecha.add(reserva);


        List<Habitacion> todasLasHabitaciones = new ArrayList<>();
        Habitacion habitacion2 = new Habitacion();
        habitacion2.setTipoHabitacion(tipoHabitacion);
        todasLasHabitaciones.add(habitacion);
        todasLasHabitaciones.add(habitacion2);

        when(reservaRepository.findByFechaReserva(fecha)).thenReturn(reservaFecha);
        when(habitacionRepository.findAll()).thenReturn(todasLasHabitaciones);


        List<Habitacion> habitacionesDisponibles = serviceReserva.buscarHabitacionesDisponibles(fecha, tipoHabitacion);

        assertEquals(1, habitacionesDisponibles.size());
        assertEquals(habitacion2, habitacionesDisponibles.get(0));
        assertEquals("Premium", habitacionesDisponibles.get(0).getTipoHabitacion());

    }

}


