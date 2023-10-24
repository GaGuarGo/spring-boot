package br.com.fatec.hellospringboot.entities;

public class Client {
    
    private int id;
    private String name;
    private double balance;


    //Gerado pelo Source Action -> Getters and Setters -> Selected All -> OK

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
