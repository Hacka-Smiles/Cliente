package br.com.smiles.ClienteSmiles.integration.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoPK implements Serializable{

    private String idCliente;
    private String logradouro;
    private int numero;

}
