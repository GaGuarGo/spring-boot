package br.com.fatec.hellospringboot.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fatec.hellospringboot.entities.Client;
// import br.com.fatec.hellospringboot.repositories.ClientRepository;
import br.com.fatec.hellospringboot.services.ClientService;

//RECEBER AS CHAMADAS HTTP/ENDPOINTS PEGANDO INFORMAÇÃO DO SERVIÇO
@RestController
// Todos os "Maaping" começam agora com clients
@RequestMapping("clients")
//Libera o Acesso entre o Front e Back para qualquer site -> 'Gambiarra'
@CrossOrigin
public class ClientController {

    // // Injeta Dependencia/Objeto
    // @Autowired
    // private ClientRepository repository;

    // Injeta o Serviço Client
    @Autowired
    private ClientService service;

    @GetMapping()
    // Mudando o status code
    public ResponseEntity<List<Client>> getClients() {

        return ResponseEntity.ok(service.getClients());
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> getClientById(@PathVariable int id) {

        return ResponseEntity.ok(service.getClientById(id));
    }

    // Client no parametro é um json que vem do front-end, por isso usa o
    // RequestBody
    @PostMapping("")
    public ResponseEntity<Client> addClient(@Validated @RequestBody Client client) {

        Client cli = this.service.addClient(client);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cli.getId())
                .toUri();

        return ResponseEntity.created(location).body(cli);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> editClient(@RequestBody Client client, @PathVariable int id) {

        this.service.editClient(client, id);
        return ResponseEntity.ok().build();

    }

    // DELETE UM CLIENTE PELO ID E DEVOLVE O STATUS CODE DE "NO CONTENT"
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteClientById(@PathVariable int id) {
        this.service.deleteClientById(id);
        return ResponseEntity.noContent().build();
    }

}
