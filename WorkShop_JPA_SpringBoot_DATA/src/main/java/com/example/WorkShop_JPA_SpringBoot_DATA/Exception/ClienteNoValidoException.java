package com.example.WorkShop_JPA_SpringBoot_DATA.Exception;

public class ClienteNoValidoException extends Exception{
    public ClienteNoValidoException(String mensaje) {
        super(mensaje);
    }
}
