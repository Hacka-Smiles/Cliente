package br.com.smiles.ClienteSmiles.integration.repository;

import br.com.smiles.ClienteSmiles.integration.entity.TelefoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<TelefoneEntity,String> {
    TelefoneEntity[] findAllByIdCliente(String idCliente);
    boolean existsByIdCliente(String idCliente);
    boolean existsByIdClienteAndTelefone(String idCliente, String telefone);

}
