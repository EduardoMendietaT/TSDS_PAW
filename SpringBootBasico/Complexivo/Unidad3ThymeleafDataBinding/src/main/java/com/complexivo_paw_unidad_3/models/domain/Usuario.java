package com.complexivo_paw_unidad_3.models.domain;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.complexivo_paw_unidad_3.validation.Requerido;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Usuario {

    @Pattern(regexp = "[0-9]{3}[.][\\d]{3}[.][\\d]{3}[-][A-z]{1}")
    public String identificador;

    @NotBlank
    private String nombre;

    @Requerido
    private String apellido;

    @Requerido
    @Size(min = 3, max = 8)
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty(message = "El correo no esta escrito correctamente!")
    @Email
    private String email;

    @NotNull(message = "La cuenta debe ser un número entero!")
    @Min(5)
    @Max(5000)
    private Integer cuenta; 

    @NotNull
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date fecha;
}
