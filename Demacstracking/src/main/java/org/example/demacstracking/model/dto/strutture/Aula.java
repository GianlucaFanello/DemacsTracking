package org.example.demacstracking.model.dto.strutture;

public class Aula extends Struttura {
    private String nome;
    private int capienza;
    private String descrizione;

    public Aula() {}

    public Aula(String cubo, String ubicazione, String nome, int capienza, String descrizione) {
        this.cubo = cubo;
        this.ubicazione = ubicazione;
        this.nome = nome;
        this.capienza = capienza;
        this.descrizione = descrizione;
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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
