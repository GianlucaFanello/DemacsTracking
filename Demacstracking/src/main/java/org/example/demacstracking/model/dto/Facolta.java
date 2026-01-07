package org.example.demacstracking.model.dto;

public class Facolta {

    private String nome ;
    private int durata;
    private int cfu;
    private String descrizione;
    private String dipartimento;
    private String lingua;

    // --- COSTRUTTORI ---

    public Facolta() {}

    public Facolta(String nome, int durata, int cfu, String dipartimento, String lingua) {
        this.nome = nome;
        this.durata = durata;
        this.cfu = cfu;
        this.dipartimento = dipartimento;
        this.lingua = lingua;
    }

    // --- GETTER E SETTER ---
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }


    public String getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(String dipartimento) {
        this.dipartimento = dipartimento;
    }

    public String getLingua() {
        return lingua;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }
}
