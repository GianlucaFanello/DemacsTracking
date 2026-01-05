package org.example.demacstracking.model.dto;


public class Utente {

    private String nome;
    private String cognome;
    private String username;
    private String email;
    private String status;
    private String password;

    public Utente() {}

    public Utente(String nome, String cognome, String username, String email, String status) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.email = email;
        this.status = status;
    }

    public Utente(String nome, String cognome, String username, String email, String status, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.email = email;
        this.status = status;
        this.password = password;
    }

    // --- GETTER ---

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public String getPassword() {
        return password;
    }

    //  --- SETTER ---
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
