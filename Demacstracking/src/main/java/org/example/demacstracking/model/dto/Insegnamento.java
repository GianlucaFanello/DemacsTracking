package org.example.demacstracking.model.dto;

import java.sql.SQLException;

public class Insegnamento {

    protected String id;
    protected String nome;
    protected int cfu;
    protected String descrizione;
    private String docente;

    public Insegnamento(String id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Insegnamento(String id, String nome, int cfu, String descrizione, String docente){
        this.id = id;
        this.nome = nome;
        this.cfu = cfu;
        this.descrizione = descrizione;
        this.docente = docente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getCfu() throws SQLException {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    public String getDescrizione() throws SQLException {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDocente() throws SQLException {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
