package org.example.demacstracking.model.db.FactoryMethod;

public class Aula extends Struttura {
    public String nome;
    public int capienza;
    public Aula() {}
    public Aula(String nome, String ubicazione, int capienza, String cubo) {
        this.nome = nome;
        this.ubicazione = ubicazione;
        this.capienza = capienza;
        this.cubo = cubo;
    }

}
