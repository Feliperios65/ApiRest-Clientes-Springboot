package com.felop.controller;

import com.felop.exception.BadRequestException;
import com.felop.exception.ResourceNotFoundException;
import com.felop.model.dto.ClienteDto;
import com.felop.model.entity.Cliente;
import com.felop.model.payload.MensajeResponse;
import com.felop.service.ICliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cliente")
public class ClienteController {

    @Autowired
    private ICliente clienteService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Cliente> clientes = clienteService.findAll();
        if (clientes == null || clientes.isEmpty()) {
            throw new ResourceNotFoundException("clientes");
        }

        return new ResponseEntity<>(MensajeResponse.builder()
                .mensaje("")
                .object(clientes)
                .build(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        Cliente cliente = clienteService.findById(id);

        if (cliente == null) {
            throw new ResourceNotFoundException("cliente", "id", id);
        }

        return new ResponseEntity<>(MensajeResponse.builder()
                .mensaje("")
                .object(ClienteDto.builder()
                        .idCliente(cliente.getIdCliente())
                        .nombre(cliente.getNombre())
                        .apellido(cliente.getApellido())
                        .correo(cliente.getCorreo())
                        .fechaRegistro(cliente.getFechaRegistro())
                        .build())
                .build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ClienteDto clienteDto) {
        Cliente clienteSave = null;
        try {
            clienteSave = clienteService.save(clienteDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Guardado correctamente")
                    .object(ClienteDto.builder()
                            .idCliente(clienteSave.getIdCliente())
                            .nombre(clienteSave.getNombre())
                            .apellido(clienteSave.getApellido())
                            .correo(clienteSave.getCorreo())
                            .fechaRegistro(clienteSave.getFechaRegistro())
                            .build())
                    .build()
                    , HttpStatus.CREATED);
        } catch (DataAccessException exDt) {
            throw new BadRequestException(exDt.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid ClienteDto clienteDto, @PathVariable Integer id) {
        Cliente clienteUpdate = null;
        try {
            if (clienteService.existById(id)) {
                clienteDto.setIdCliente(id);
                clienteUpdate = clienteService.save(clienteDto);

                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("Actualizado correctamente")
                        .object(ClienteDto.builder()
                                .idCliente(clienteUpdate.getIdCliente())
                                .nombre(clienteUpdate.getNombre())
                                .apellido(clienteUpdate.getApellido())
                                .correo(clienteUpdate.getCorreo())
                                .fechaRegistro(clienteUpdate.getFechaRegistro())
                                .build())
                        .build()
                        , HttpStatus.CREATED);
            } else {
                throw new ResourceNotFoundException("cliente", "id", id);
            }
        } catch (DataAccessException exDt) {
            throw new BadRequestException(exDt.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Cliente clienteDelete = clienteService.findById(id);
            clienteService.delete(clienteDelete);
            return new ResponseEntity<>(clienteDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDt) {
            throw new BadRequestException(exDt.getMessage());
        }
    }

}
