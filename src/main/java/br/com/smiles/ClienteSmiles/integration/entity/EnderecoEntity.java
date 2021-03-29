package br.com.smiles.ClienteSmiles.integration.entity;

import br.com.smiles.ClienteSmiles.controller.model.Endereco;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Endereco")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(EnderecoPK.class)
public class EnderecoEntity {

    @Id
    @NotNull
    private String idCliente;
    @Id
    @NotNull
    private String logradouro;
    @Id
    @NotNull
    private int numero;
    @NotNull
    private String bairro;
    @NotNull
    private String cidade;
    @NotNull
    private String estado;
    @NotNull
    private String pais;
    @NotNull
    private String cep;
    @NotNull
    private char principal;
    @NotNull
    private String latitude;
    @NotNull
    private String longitude;
}
