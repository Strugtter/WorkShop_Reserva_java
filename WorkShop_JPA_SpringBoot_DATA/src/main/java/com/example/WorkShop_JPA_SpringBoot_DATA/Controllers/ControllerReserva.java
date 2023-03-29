package com.example.WorkShop_JPA_SpringBoot_DATA.Controllers;

import com.example.WorkShop_JPA_SpringBoot_DATA.Models.Cliente;
import com.example.WorkShop_JPA_SpringBoot_DATA.Models.Habitacion;
import com.example.WorkShop_JPA_SpringBoot_DATA.Models.Reserva;
import com.example.WorkShop_JPA_SpringBoot_DATA.Models.ReservaInfo;
import com.example.WorkShop_JPA_SpringBoot_DATA.Services.ServiceReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ControllerReserva {

    @Autowired
    private ServiceReserva serviceReserva;

    @PostMapping("/reserva")
    public ReservaInfo crearReserva (@RequestParam Integer numHabitacion, @RequestParam Integer DinCliente, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha){
         return this.serviceReserva.crearReserva(numHabitacion, fecha, DinCliente);
    }
    @GetMapping("/reserva/{cedula}")
    public List<Reserva> reservasPorCliente(@PathVariable ("cedula") Integer cedula) {
        return this.serviceReserva.buscarReservaPorCliente(cedula);
    }

    @GetMapping("/reserva")
    public List<Habitacion> buscarHabitacionesDisponibles(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha, @RequestParam String tipoHabitacion ){
        return this.serviceReserva.buscarHabitacionesDisponibles(fecha, tipoHabitacion);
    }
}

