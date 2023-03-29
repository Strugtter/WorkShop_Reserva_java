package com.example.WorkShop_JPA_SpringBoot_DATA.Services;


import com.example.WorkShop_JPA_SpringBoot_DATA.Exception.ClienteNoValidoException;
import com.example.WorkShop_JPA_SpringBoot_DATA.Exception.RepositorioException;
import com.example.WorkShop_JPA_SpringBoot_DATA.Models.Cliente;
import com.example.WorkShop_JPA_SpringBoot_DATA.Models.Habitacion;
import com.example.WorkShop_JPA_SpringBoot_DATA.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCliente {


    private ClienteRepository clienteRepository;

    @Autowired
    public ServiceCliente(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void crear(List<Cliente> cliente) throws ClienteNoValidoException, RepositorioException {

        for (Cliente clientes : cliente) {
            if (clientes.getApellido().isEmpty() || clientes.getNombre().isEmpty()) {
                throw new ClienteNoValidoException("El nombre ó el apellido no pueden estar vacios");
            }
        }
        try {
            this.clienteRepository.saveAll(cliente);
        } catch (Exception e) {
            throw new RepositorioException("Error al guardar el cliente" + e.getMessage());
        }
    }


}
