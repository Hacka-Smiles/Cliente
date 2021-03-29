package br.com.smiles.ClienteSmiles.controller;

import br.com.smiles.ClienteSmiles.controller.model.Email;
import br.com.smiles.ClienteSmiles.controller.model.Endereco;
import br.com.smiles.ClienteSmiles.controller.model.Telefone;
import br.com.smiles.ClienteSmiles.controller.model.input.Login;
import br.com.smiles.ClienteSmiles.controller.model.output.Cliente;
import br.com.smiles.ClienteSmiles.integration.entity.ClienteEntity;
import br.com.smiles.ClienteSmiles.integration.entity.EmailEntity;
import br.com.smiles.ClienteSmiles.integration.entity.EnderecoEntity;
import br.com.smiles.ClienteSmiles.integration.entity.TelefoneEntity;
import br.com.smiles.ClienteSmiles.integration.repository.ClienteRepository;
import br.com.smiles.ClienteSmiles.integration.repository.EmailRepository;
import br.com.smiles.ClienteSmiles.integration.repository.EnderecoRepository;
import br.com.smiles.ClienteSmiles.integration.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private TelefoneRepository telefoneRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @CrossOrigin(origins = "*")
    @GetMapping("/{idCliente}")
    private ResponseEntity<?> consultarCliente(@PathVariable String idCliente) {

        if (clienteRepository.existsById(idCliente)) {

            Telefone[] telefone;
            Email[] email;
            Endereco[] endereco;

            ClienteEntity clienteEntity = clienteRepository.findByIdCliente(idCliente);
            if (emailRepository.existsByIdCliente(idCliente)) {
                EmailEntity[] emailEntity = emailRepository.findAllByIdCliente(idCliente);
                email = new Email[emailEntity.length];
                for (int i = 0; i < emailEntity.length; i++) {
                    email[i] = Email.builder()
                            .email(emailEntity[i].getEmail())
                            .principal(emailEntity[i].getPrincipal())
                            .build();
                }
            } else {
                email = null;
            }
            if (telefoneRepository.existsByIdCliente(idCliente)) {
                TelefoneEntity[] telefoneEntitie = telefoneRepository.findAllByIdCliente(idCliente);
                telefone = new Telefone[telefoneEntitie.length];

                for (int i = 0; i < telefoneEntitie.length; i++) {
                    telefone[i] = Telefone.builder()
                            .ddd(telefoneEntitie[i].getDdd())
                            .ddi(telefoneEntitie[i].getDdi())
                            .telefone(telefoneEntitie[i].getTelefone())
                            .principal(telefoneEntitie[i].getPrincipal())
                            .build();
                }
            } else {
                telefone = null;
            }
            if (enderecoRepository.existsByIdCliente(idCliente)) {
                EnderecoEntity[] enderecoEntitie = enderecoRepository.findAllByIdCliente(idCliente);
                endereco = new Endereco[enderecoEntitie.length];

                for (int i = 0; i < enderecoEntitie.length; i++) {
                    endereco[i] = Endereco.builder()
                            .logradouro(enderecoEntitie[i].getLogradouro())
                            .numero(enderecoEntitie[i].getNumero())
                            .bairro(enderecoEntitie[i].getBairro())
                            .cidade(enderecoEntitie[i].getCidade())
                            .estado(enderecoEntitie[i].getEstado())
                            .pais(enderecoEntitie[i].getPais())
                            .cep(enderecoEntitie[i].getCep())
                            .principal(enderecoEntitie[i].getPrincipal())
                            .build();
                }
            } else {
                endereco = null;
            }

            return ResponseEntity.ok(Cliente.builder().idCliente(clienteEntity
                    .getIdCliente())
                    .idade(clienteEntity.getIdade())
                    .genero(clienteEntity.getGenero())
                    .cpf(clienteEntity.getCpf())
                    .nome(clienteEntity.getNome())
                    .email(email)
                    .endereco(endereco)
                    .telefone(telefone)
                    .build());

        } else {

            return ResponseEntity.status(404).body("Cliente não encontrado!");

        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("")
    private ResponseEntity<?> cadastrarCliente(@RequestBody Cliente cliente){
        if(!clienteRepository.existsByIdCliente(cliente.getIdCliente())){

            clienteRepository.save(ClienteEntity.builder()
                    .idCliente(cliente.getIdCliente())
                    .genero(cliente.getGenero())
                    .idade(cliente.getIdade())
                    .nome(cliente.getNome())
                    .cpf(cliente.getCpf())
                    .build());

            for(int i = 0; i<cliente.getEmail().length; i++){
                emailRepository.save(EmailEntity.builder()
                        .email(cliente.getEmail()[i].getEmail())
                        .principal(cliente.getEmail()[i].getPrincipal())
                        .idCliente(cliente.getIdCliente())
                        .build());
            }
            for(int i = 0; i<cliente.getEndereco().length; i++){
                enderecoRepository.save(EnderecoEntity.builder()
                        .logradouro(cliente.getEndereco()[i].getLogradouro())
                        .numero(cliente.getEndereco()[i].getNumero())
                        .bairro(cliente.getEndereco()[i].getBairro())
                        .cidade(cliente.getEndereco()[i].getCidade())
                        .estado(cliente.getEndereco()[i].getEstado())
                        .pais(cliente.getEndereco()[i].getPais())
                        .cep(cliente.getEndereco()[i].getCep())
                        .latitude(cliente.getEndereco()[i].getLatitude())
                        .principal(cliente.getEndereco()[i].getPrincipal())
                        .idCliente(cliente.getIdCliente())
                        .build());
            }
            for(int i =0; i<cliente.getEmail().length; i++){
                emailRepository.save(EmailEntity.builder()
                        .idCliente(cliente.getIdCliente())
                        .email(cliente.getEmail()[i].getEmail())
                        .principal(cliente.getEmail()[i].getPrincipal())
                        .build());
            }
            for(int i = 0; i<cliente.getTelefone().length;i++){
                telefoneRepository.save(TelefoneEntity.builder()
                        .ddd(cliente.getTelefone()[i].getDdd())
                        .ddi(cliente.getTelefone()[i].getDdi())
                        .telefone(cliente.getTelefone()[i].getTelefone())
                        .idCliente(cliente.getIdCliente())
                        .build());
            }
            return ResponseEntity.ok("Usuário Cadastrado com sucesso!");
        }else{
            return ResponseEntity.status(404).body("Cliente já cadastrado!");
        }
    }

    @CrossOrigin(origins = "*")
    @PatchMapping("/{idCliente}")
    private ResponseEntity<?> atualizarCliente(@RequestBody Cliente cliente){
        if (clienteRepository.existsById(cliente.getIdCliente())) {

            clienteRepository.save(ClienteEntity.builder()
                    .cpf(cliente.getCpf())
                    .nome(cliente.getNome())
                    .idade(cliente.getIdade())
                    .genero(cliente.getGenero())
                    .idCliente(cliente.getIdCliente())
                    .build());

            for(int i = 0; i<cliente.getEmail().length; i++){
                if (emailRepository.existsByIdClienteAndEmail(cliente.getIdCliente(), cliente.getEmail()[i].getEmail())) {
                    emailRepository.save(EmailEntity.builder()
                            .principal(cliente.getEmail()[i].getPrincipal())
                            .email(cliente.getEmail()[i].getEmail())
                            .idCliente(cliente.getIdCliente())
                            .build());
                }
            }

            for(int i = 0; i<cliente.getTelefone().length; i++){
                if (telefoneRepository.existsByIdClienteAndTelefone(cliente.getIdCliente(), cliente.getTelefone()[i].getTelefone())) {
                    telefoneRepository.save(TelefoneEntity.builder()
                            .ddi(cliente.getTelefone()[i].getDdi())
                            .ddd(cliente.getTelefone()[i].getDdd())
                            .telefone(cliente.getTelefone()[i].getTelefone())
                            .idCliente(cliente.getIdCliente())
                            .principal(cliente.getTelefone()[i].getPrincipal())
                            .build());
                }
            }

            for(int i = 0; i<cliente.getEndereco().length; i++){
                if (enderecoRepository.existsByIdClienteAndLogradouroAndNumero(cliente.getIdCliente(),cliente.getEndereco()[i].getLogradouro(),cliente.getEndereco()[i].getNumero())) {
                    enderecoRepository.save(EnderecoEntity.builder()
                            .logradouro(cliente.getEndereco()[i].getLogradouro())
                            .numero(cliente.getEndereco()[i].getNumero())
                            .bairro(cliente.getEndereco()[i].getBairro())
                            .cidade(cliente.getEndereco()[i].getCidade())
                            .estado(cliente.getEndereco()[i].getEstado())
                            .pais(cliente.getEndereco()[i].getPais())
                            .cep(cliente.getEndereco()[i].getCep())
                            .latitude(cliente.getEndereco()[i].getLatitude())
                            .longitude(cliente.getEndereco()[i].getLongitude())
                            .idCliente(cliente.getIdCliente())
                            .build());
                }
            }

            return ResponseEntity.ok("Cliente atualizado com sucesso!");

        } else {

            return ResponseEntity.status(404).body("Cliente não encontrado!");

        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{idCliente}")
    private ResponseEntity<?> excluirUsuario(@PathVariable(value = "idCliente")String idCliente){
        if(clienteRepository.existsById(idCliente)){
            clienteRepository.deleteById(idCliente);
            return ResponseEntity.ok("Conta excluida com sucesso");
        }else{
            return ResponseEntity.status(404).body("Conta não encontrada!");
        }
    }

}
