package br.com.smiles.ClienteSmiles.integration.repository;

import br.com.smiles.ClienteSmiles.integration.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {
    ClienteEntity findByIdCliente(String idCliente);
    boolean existsByIdCliente(String idCliente);
}
