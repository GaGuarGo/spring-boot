package br.com.fatec.hellospringboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.hellospringboot.entities.Client;
import br.com.fatec.hellospringboot.repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;

//Montando um Serviço no Spring BOOT
@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> getClients() {
        return repository.findAll();
    }

    public Client getClientById(int id) {
        // lida com a possibilidade de não ter um cliente relacionado ao id
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Cliente não Existente"));
    }

    public void deleteClientById(int id) {

        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Cliente não Existente");
        }

    }

}
