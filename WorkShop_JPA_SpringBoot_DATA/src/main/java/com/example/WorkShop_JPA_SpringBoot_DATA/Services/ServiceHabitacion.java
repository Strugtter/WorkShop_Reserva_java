package com.example.WorkShop_JPA_SpringBoot_DATA.Services;

import com.example.WorkShop_JPA_SpringBoot_DATA.Exception.ClienteNoValidoException;
import com.example.WorkShop_JPA_SpringBoot_DATA.Exception.RepositorioException;
import com.example.WorkShop_JPA_SpringBoot_DATA.Models.Cliente;
import com.example.WorkShop_JPA_SpringBoot_DATA.Models.Habitacion;
import com.example.WorkShop_JPA_SpringBoot_DATA.Repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceHabitacion {

    @Autowired
    private HabitacionRepository habitacionRepository;
    public void crear(List<Habitacion> habitacion) {
        for (Habitacion habitaciones : habitacion) {
            if (habitaciones.getTipoHabitacion().equals("Premium")) {
                habitaciones.setPrecioBase(habitaciones.getPrecioBase() * 1.05);
            }
        }
        this.habitacionRepository.saveAll(habitacion);
    }
    public Habitacion encontrarPorNumero (Integer id){
        return this.habitacionRepository.findByNumero(id);
    }

}
