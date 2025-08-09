package com.felop.service;

import com.felop.model.dto.ClienteDto;
import com.felop.model.entity.Cliente;

import java.util.List;

public interface ICliente {

    Cliente save(ClienteDto clienteDto);
    Cliente findById(Integer id);
    List<Cliente> findAll();
    void delete (Cliente cliente);
    boolean existById(Integer id);
}
