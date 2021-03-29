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
@Table(name="Email")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(EmailPK.class)
public class EmailEntity {

    @Id
    @NotNull
    private String idCliente;

    @Id
    @NotNull
    private String email;

    @NotNull
    private char principal;
}
