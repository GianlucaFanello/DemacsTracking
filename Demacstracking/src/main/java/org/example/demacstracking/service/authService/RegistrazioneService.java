package org.example.demacstracking.service.authService;

import org.example.demacstracking.model.dao.UtenteDao;
import org.example.demacstracking.model.dto.Utente;
import org.example.demacstracking.view.SceneHandler;

import java.sql.SQLException;

public class RegistrazioneService {

    private final UtenteDao utenteDao;

    public RegistrazioneService(UtenteDao utenteDao) {
        this.utenteDao = utenteDao;
    }

    public String registrazione(String nome, String cognome, String username, String email, String password) throws SQLException {

        if(nome.isEmpty() || cognome.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()){
            return "Non tutti i campi sono stati compilati" ;
        }

        if(utenteDao.usernamePresente(username)) {
            return "Username già usato";
        }

        if(utenteDao.emailPresente(email)){
            return "Email già presente";
        }

        /* --- Status può essere utente o admin
        --- Admin è uno solo istanziato all'inizio
         --- Altri Admin possono essere aggiunti in seguito dagli account Admin (NON IMPLEMENTATA) ---
        */


        String passwordCryptata = PasswordService.passwordCryptata(password);
        Utente utente = new Utente(nome, cognome, username, email, "utente");


        if (utenteDao.inserisciUtente(utente, passwordCryptata) )
            return "OK";
        else
            return "Dati inseriti non corretti";
    }
}
