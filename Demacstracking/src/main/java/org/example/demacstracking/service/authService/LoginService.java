package org.example.demacstracking.service.authService;

import org.example.demacstracking.model.dao.UtenteDao;
import org.example.demacstracking.view.SceneHandler;

import java.io.IOException;
import java.sql.SQLException;

public class LoginService {

    private final UtenteDao utenteDao;

    public LoginService(UtenteDao utenteDao) throws SQLException {
        this.utenteDao = utenteDao;
    }

    public boolean login(String email, String password) throws IOException, SQLException {

        String passwordCryptata = utenteDao.getPasswordByEmail(email);

        if(email.isEmpty() || password.isEmpty() || passwordCryptata == null || passwordCryptata.isEmpty()){
            return false;
        }
        return PasswordService.verify(password,passwordCryptata);
    }
}
