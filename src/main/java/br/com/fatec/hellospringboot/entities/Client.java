package br.com.fatec.hellospringboot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;;

// Usa-se um table quando o nome da tabela no BD tem um nome diferente da classe
@Entity
@Table(name = "TBL_CLIENT")
public class Client {

    // GERAR PK DE FORMA AUTOMÁTICA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
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

}
