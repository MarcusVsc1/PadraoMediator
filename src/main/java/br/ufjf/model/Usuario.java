package br.ufjf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Usuario {

    private String nomeUsuario;
    private String endereco;

}
