package com.felop.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@ToString
public class ClienteDto implements Serializable {

    private Integer idCliente;

    @Size(min = 2, max = 25)
    @NotEmpty(message = "Nombre requerido!")
    private String nombre;

    @Size(min = 2, max = 25)
    @NotEmpty(message = "Apellido requerido!")
    private String apellido;

    @Email
    @NotEmpty(message = "Correo requerido!")
    private String correo;

    private Date fechaRegistro;
}