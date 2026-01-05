package org.example.demacstracking.service.utenteService;

import org.example.demacstracking.model.dto.Utente;

import static org.example.demacstracking.model.Strategy.RoleStrategy.*;

public class UtenteCorrente {

    private static UtenteCorrente instance = new UtenteCorrente();

    private Utente utente;
    private Ruoli status;

    private UtenteCorrente() { }

    public static UtenteCorrente getInstance() {
        return instance;
    }

    public void logout() {
        this.utente = null;
        this.status = null;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
        setStatus(utente.getStatus());
    }

    public void setStatus(String status) {

        switch (status) {
            case "utente" -> this.status = Ruoli.UTENTE;
            case "admin" -> this.status = Ruoli.ADMIN;
            case "ospite" -> this.status = Ruoli.OSPITE;
            default -> throw new IllegalArgumentException("Status sconosciuto: " + status);
        }
    }

    public Utente getUtente() {
        return utente;
    }

    public Ruoli getStatus() {
        return status;
    }


}
