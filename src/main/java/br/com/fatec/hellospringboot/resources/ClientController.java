package br.com.fatec.hellospringboot.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.hellospringboot.entities.Client;

@RestController
public class ClientController {

    @GetMapping("client")
    public Client getClient() {

        Client c = new Client();
        c.setId(0);
        c.setName("Gabriel");
        c.setBalance(1200);

        return c;
    }

    @GetMapping("clients")
    public List<Client> getClients() {

        ArrayList<Client> clients = new ArrayList<Client>();
        final String[] nomes = { "Alice", "Bob", "Charlie", "David", "Eve", "Fay", "Grace", "Hank", "Smith", "Johnson",
                "Brown", "Davis", "Lee", "Wong", "Garcia", "Patel" };

        for (int i = 0; i < nomes.length; i++) {

            Random r = new Random();

            Client c = new Client();
            c.setId(i);
            c.setName(nomes[i]);
            c.setBalance(r.nextDouble(1200));

            clients.add(i, c);
        }

        return clients;
    }

}
