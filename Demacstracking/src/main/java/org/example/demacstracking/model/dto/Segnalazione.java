package org.example.demacstracking.model.dto;

public class Segnalazione {

    private int id;
    private String descrizione ;
    private String utente;
    private String tipo;

    public Segnalazione() {}

    public Segnalazione(int id, String descrizione, String utente, String tipo) {
        this.id = id;
        this.descrizione = descrizione;
        this.utente = utente;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
