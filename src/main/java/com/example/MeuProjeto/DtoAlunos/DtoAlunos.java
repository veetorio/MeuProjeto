package com.example.MeuProjeto.DtoAlunos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoAlunos(@NotBlank String nome,@NotNull BigDecimal nota){

}
 