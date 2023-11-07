package br.com.fatec.hellospringboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.hellospringboot.entities.Client;
// import br.com.fatec.hellospringboot.repositories.ClientRepository;
import br.com.fatec.hellospringboot.services.ClientService;

//RECEBER AS CHAMADAS HTTP/ENDPOINTS PEGANDO INFORMAÇÃO DO SERVIÇO
@RestController
public class ClientController {

    // // Injeta Dependencia/Objeto
    // @Autowired
    // private ClientRepository repository;

    // Injeta o Serviço Client
    @Autowired
    private ClientService service;

    @GetMapping("clients")
    // Mudando o status code
    public ResponseEntity<List<Client>> getClients() {

        return ResponseEntity.ok(service.getClients());
    }

    @GetMapping("clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable int id) {

        return ResponseEntity.ok(service.getClientById(id));
    }

    //DELTE UM CLIENTE PELO ID E DEVOLVE O STATUS CODE DE "NO CONTENT"
    @DeleteMapping("clients/{id}")
    public ResponseEntity<Void> deleteClientById(@PathVariable int id) {
        this.service.deleteClientById(id);
        return ResponseEntity.noContent().build();
    }

}
