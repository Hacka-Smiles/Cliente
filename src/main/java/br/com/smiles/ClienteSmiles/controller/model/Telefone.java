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
public class Telefone {

    @JsonProperty(value = "ddi")
    private String ddi;

    @JsonProperty(value = "ddd")
    private String ddd;

    @JsonProperty(value = "telefone")
    private String telefone;

    @JsonProperty(value = "principal")
    private char principal;
}
