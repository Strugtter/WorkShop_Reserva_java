package com.example.WorkShop_JPA_SpringBoot_DATA.Repository;

import com.example.WorkShop_JPA_SpringBoot_DATA.Models.Cliente;
import com.example.WorkShop_JPA_SpringBoot_DATA.Models.Habitacion;
import com.example.WorkShop_JPA_SpringBoot_DATA.Models.Reserva;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva,Long> {


    Reserva findByCodigoReserva(Integer codigoReserva);
    List<Reserva> findByCliente(Cliente cliente);

    List<Reserva> findByFechaReserva(LocalDate fecha);
}
