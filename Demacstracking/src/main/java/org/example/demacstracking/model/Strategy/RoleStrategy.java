package org.example.demacstracking.model.Strategy;

public interface RoleStrategy {

    public enum Ruoli {
        ADMIN,
        UTENTE,
        ENTE,
        OSPITE
    }

    boolean puoCreare();

    boolean puoModificare();

    boolean puoEliminare();

    boolean puoSegnalare();

    boolean puoVisualizzareSegnalazioni();
}
