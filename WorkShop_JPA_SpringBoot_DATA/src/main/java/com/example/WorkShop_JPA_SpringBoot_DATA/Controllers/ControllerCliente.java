package com.example.WorkShop_JPA_SpringBoot_DATA.Controllers;

import com.example.WorkShop_JPA_SpringBoot_DATA.Exception.ClienteNoValidoException;
import com.example.WorkShop_JPA_SpringBoot_DATA.Exception.RepositorioException;
import com.example.WorkShop_JPA_SpringBoot_DATA.Models.Cliente;
import com.example.WorkShop_JPA_SpringBoot_DATA.Models.Habitacion;
import com.example.WorkShop_JPA_SpringBoot_DATA.Services.ServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ControllerCliente {

    @Autowired
    private ServiceCliente serviceCliente;

    @PostMapping("/cliente")
    public ResponseEntity<String> crearCliente (@RequestBody List<Cliente> cliente){
        try {
            this.serviceCliente.crear(cliente);
            return new ResponseEntity<>("Cliente creado con éxito", HttpStatus.CREATED);
        } catch (ClienteNoValidoException | RepositorioException e) {
            return new ResponseEntity<>("No se pudo crear el cliente: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }




}
