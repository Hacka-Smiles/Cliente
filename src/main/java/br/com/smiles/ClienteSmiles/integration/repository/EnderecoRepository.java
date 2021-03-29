package br.com.smiles.ClienteSmiles.integration.repository;

import br.com.smiles.ClienteSmiles.integration.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity,String> {
    EnderecoEntity[] findAllByIdCliente(String idCliente);
    boolean existsByIdCliente(String idCliente);
    boolean existsByIdClienteAndLogradouroAndNumero(String idCliente, String logradouro, int numero);
}
