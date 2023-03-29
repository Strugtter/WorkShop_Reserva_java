package com.example.WorkShop_JPA_SpringBoot_DATA.Repository;

import com.example.WorkShop_JPA_SpringBoot_DATA.Models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Integer> {

    Cliente findByCedula(Integer numero);
}
