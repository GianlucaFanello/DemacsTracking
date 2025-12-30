package main.java.org.example.demacstracking.model.dto;


public class Utente {

    private String nome;
    private String cognome;
    private String username;
    private String email;
    private String status;

    public Utente() {}

    public Utente(String nome, String cognome, String username, String email, String status) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.status = status;
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
