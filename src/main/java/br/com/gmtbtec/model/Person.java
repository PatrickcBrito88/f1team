package br.com.gmtbtec.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {

    private String nome;
    private String email;
    private String telefone;

}
