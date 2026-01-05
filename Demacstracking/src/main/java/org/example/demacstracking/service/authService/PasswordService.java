package org.example.demacstracking.service.authService;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordService {

    // --- CRYPTA LA PASSWORD ---
    public static String passwordCryptata(String userPassword) {
        return BCrypt.hashpw(userPassword, BCrypt.gensalt(12));
    }

    // --- VERIFICA LA PASSWORD INSERITA CON QUELLA CRYPTATA ---
    public static boolean verify(String passwordInserita, String hashSalvato) {
        return BCrypt.checkpw(passwordInserita, hashSalvato);
    }
}
