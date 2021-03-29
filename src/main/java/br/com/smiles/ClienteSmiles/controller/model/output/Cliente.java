package br.com.smiles.ClienteSmiles.controller.model.output;

import br.com.smiles.ClienteSmiles.controller.model.Telefone;
import br.com.smiles.ClienteSmiles.controller.model.Email;
import br.com.smiles.ClienteSmiles.controller.model.Endereco;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @JsonProperty(value = "idCliente")
    private String idCliente;

    @JsonProperty(value = "nome")
    private String nome;

    @JsonProperty(value = "idade")
    private int idade;

    @JsonProperty(value = "genero")
    private String genero;

    @JsonProperty(value = "cpf")
    private String cpf;

    @JsonProperty(value = "endereco")
    private Endereco[] endereco;

    @JsonProperty(value = "telefone")
    private Telefone[] telefone;

    @JsonProperty(value = "email")
    private Email[] email;
}
