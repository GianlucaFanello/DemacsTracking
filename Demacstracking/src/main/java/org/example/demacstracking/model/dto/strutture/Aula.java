package org.example.demacstracking.model.dto.strutture;

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


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapienza() {
        return capienza;
    }

    public void setCapienza(int capienza) {
        this.capienza = capienza;
    }
}
