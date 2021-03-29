package br.com.smiles.ClienteSmiles.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @JsonProperty(value = "logradouro")
    private String logradouro;

    @JsonProperty(value = "numero")
    private int numero;

    @JsonProperty(value = "bairro")
    private String bairro;

    @JsonProperty(value = "cidade")
    private String cidade;

    @JsonProperty(value = "estado")
    private String estado;

    @JsonProperty(value = "pais")
    private String pais;

    @JsonProperty(value = "cep")
    private String cep;

    @JsonProperty(value = "principal")
    private char principal;

    @JsonProperty(value = "latitude")
    private String latitude;

    @JsonProperty(value = "longitude")
    private String longitude;


}
