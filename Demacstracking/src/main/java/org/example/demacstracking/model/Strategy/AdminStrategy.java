package org.example.demacstracking.model.Strategy;

public class AdminStrategy implements RoleStrategy {

    @Override
    public boolean puoCreare() {
        return true;
    }

    @Override
    public boolean puoModificare() {
        return true;
    }

    @Override
    public boolean puoEliminare() {
        return true;
    }

    @Override
    public boolean puoSegnalare() {
        return true;
    }

    @Override
    public boolean puoVisualizzareSegnalazioni() {
        return false;
    }
}
