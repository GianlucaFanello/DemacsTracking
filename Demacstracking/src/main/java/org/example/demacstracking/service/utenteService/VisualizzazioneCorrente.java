package org.example.demacstracking.service.utenteService;

import org.example.demacstracking.model.dto.Cubo;
import org.example.demacstracking.model.dto.Facolta;
import org.example.demacstracking.model.dto.Insegnamento;
import org.example.demacstracking.model.dto.strutture.Struttura;

public class VisualizzazioneCorrente {

    private static final VisualizzazioneCorrente visualizzazioneCorrente = new VisualizzazioneCorrente();

    private Facolta facoltaCorrente;

    private Cubo cuboCorrente;

    private Insegnamento insegnamentoCorrente;

    private int anno ;

    private Struttura struttura;

    private VisualizzazioneCorrente() {}

    public static VisualizzazioneCorrente getInstance() {
        return visualizzazioneCorrente;
    }


    public Struttura getStruttura() {
        return struttura;
    }
    public void setStruttura(Struttura struttura) {
        this.struttura = struttura;
    }
    public void resetStruttura(){
        this.struttura = null;
    }

    public int getAnno() {
        return anno;
    }
    public void setAnno(int anno) {
        this.anno = anno;
    }
    public void resetAnno() {
        this.anno = 0;
    }


    public void setFacoltaCorrente(Facolta facoltaCorrente) {
        this.facoltaCorrente = facoltaCorrente;
    }
    public Facolta getFacoltaCorrente() {
        return facoltaCorrente;
    }
    public void resetFacolta(){
        this.facoltaCorrente = null;
    }


    public void setCuboCorrente(Cubo cuboCorrente) {
        this.cuboCorrente = cuboCorrente;
    }
    public Cubo getCuboCorrente() {
        return cuboCorrente;
    }
    public void resetCubo(){
        this.cuboCorrente = null;
    }


    public void setInsegnamentoCorrente(Insegnamento insegnamentoCorrente) {
        this.insegnamentoCorrente = insegnamentoCorrente;
    }
    public Insegnamento getInsegnamentoCorrente() {
        return insegnamentoCorrente;
    }
    public void resetInsegnamento(){
        this.insegnamentoCorrente = null;
    }


    public void reset() {
        this.facoltaCorrente = null;
        this.cuboCorrente = null;
        this.insegnamentoCorrente = null;
    }
}