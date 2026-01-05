package org.example.demacstracking.service.authService;

import org.example.demacstracking.model.dao.UtenteDao;
import org.example.demacstracking.model.dto.Utente;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;

public class LoginService {

    private final UtenteDao utenteDao;

    public LoginService(UtenteDao utenteDao) throws SQLException {
        this.utenteDao = utenteDao;
    }

    public Utente login(String email, String password) throws IOException, SQLException {

        if (email.isEmpty() || password.isEmpty())
            return null;

        Utente utente = utenteDao.getUtenteByEmail(email);

        if(utente == null){
            return null;
        }

        String passwordCryptata = utente.getPassword();

        if(PasswordService.verify(password,passwordCryptata))
        {
            return new Utente(utente.getNome(),
                    utente.getCognome(),
                    utente.getUsername(),
                    utente.getEmail(),
                    utente.getStatus());
        }

        return null;
    }
}
