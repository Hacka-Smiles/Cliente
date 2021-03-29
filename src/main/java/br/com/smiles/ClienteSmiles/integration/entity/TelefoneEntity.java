package br.com.smiles.ClienteSmiles.integration.entity;

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
@Table(name = "Telefone")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(TelefonePK.class)
public class TelefoneEntity {

    @Id
    @NotNull
    private String idCliente;
    @Id
    @NotNull
    private String telefone;
    @NotNull
    private String ddi;
    @NotNull
    private String ddd;
    @NotNull
    private char principal;
}
