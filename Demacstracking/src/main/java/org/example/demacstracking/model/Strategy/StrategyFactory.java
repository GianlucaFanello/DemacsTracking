package org.example.demacstracking.model.Strategy;

public class StrategyFactory {

    public static RoleStrategy creaStrategy(RoleStrategy.Ruoli status) {
        return switch (status) {
            case ADMIN -> new AdminStrategy();
            case UTENTE -> new UtenteStrategy();
            case OSPITE -> new OspiteStrategy();
        };
    }
}
