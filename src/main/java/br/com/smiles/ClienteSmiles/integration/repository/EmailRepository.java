package br.com.smiles.ClienteSmiles.integration.repository;

import br.com.smiles.ClienteSmiles.integration.entity.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, String> {
    EmailEntity[] findAllByIdCliente(String id_cliente);
    boolean existsByIdCliente(String idCliente);
    boolean existsByIdClienteAndEmail(String idCliente, String email);

}
