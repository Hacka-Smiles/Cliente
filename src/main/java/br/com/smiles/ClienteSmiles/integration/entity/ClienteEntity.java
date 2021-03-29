package br.com.smiles.ClienteSmiles.integration.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity {

    @Id
    @NotNull
    private String idCliente;

    @NotNull
    private String nome;

    @NotNull
    private int idade;

    @NotNull
    private String genero;

    @NotNull
    private String cpf;

}
