package com.example.WorkShop_JPA_SpringBoot_DATA.Repository;

import com.example.WorkShop_JPA_SpringBoot_DATA.Models.Habitacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitacionRepository extends CrudRepository <Habitacion, Integer> {
    Habitacion findByNumero(Integer numero);
    List<Habitacion> findAll();
}
