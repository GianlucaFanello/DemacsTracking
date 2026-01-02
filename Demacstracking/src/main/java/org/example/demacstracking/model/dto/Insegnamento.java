package org.example.demacstracking.model.dto;

public class Insegnamento {

    private int id;
    private String nome;
    private int cfu;
    private String descrizione;
    private String docente;


    public Insegnamento() {}

    public Insegnamento(int id, String nome, int cfu, String descrizione, String docente) {
        this.id = id;
        this.nome = nome;
        this.cfu = cfu;
        this.descrizione = descrizione;
        this.docente = docente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }
}
