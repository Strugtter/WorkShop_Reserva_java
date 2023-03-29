package com.example.WorkShop_JPA_SpringBoot_DATA.Controllers;


import com.example.WorkShop_JPA_SpringBoot_DATA.Exception.ClienteNoValidoException;
import com.example.WorkShop_JPA_SpringBoot_DATA.Exception.RepositorioException;
import com.example.WorkShop_JPA_SpringBoot_DATA.Models.Habitacion;
import com.example.WorkShop_JPA_SpringBoot_DATA.Services.ServiceHabitacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ControllerHabitacion {

    @Autowired
    private ServiceHabitacion serviceHabitacion;

    @PostMapping("/habitacion")
    public ResponseEntity crearHabitacion (@RequestBody List<Habitacion> habitacion) {
            this.serviceHabitacion.crear(habitacion);
            return new ResponseEntity<>("Habitacion Creada con éxito", HttpStatus.CREATED);
    }

    @GetMapping("/habitacion")
    public Habitacion buscarHabitacion (@RequestParam Integer numero){
        return this.serviceHabitacion.encontrarPorNumero(numero);
    }
}
