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
public class Email {

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "principal")
    private char principal;
}
