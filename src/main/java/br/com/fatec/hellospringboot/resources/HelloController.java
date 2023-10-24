package br.com.fatec.hellospringboot.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Chamando o SpringBoot para Receber Requisições
@RestController
public class HelloController {

    //Vinculando a um endPoint
    @GetMapping("hello")
    public String hello() {
        return "Hello Sring Boot";
    }

    

}
