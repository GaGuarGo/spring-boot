package br.com.fatec.hellospringboot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Id;;

// Usa-se um table quando o nome da tabela no BD tem um nome diferente da classe
@Entity
@Table(name = "TBL_CLIENT")
public class Client {

    // GERAR PK DE FORMA AUTOMÁTICA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //RESTRIÇÃO DO BANCO DE DADOS
    @Column(nullable = false)
    @NotBlank(message = "O nome do Cliente não Pode ser em Branco!")
    private String name;


    @Min(value = 0, message = "O saldo não pode ser Negativo!")
    private double balance;

    // Gerado pelo Source Action -> Getters and Setters -> Selected All -> OK
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client orElseThrow(Object object) {
        return null;
    }

}
