package ar.edu.unlu.poo.labo2.estrategias;

import ar.edu.unlu.poo.labo2.artefactos.Artefacto;

public class EscribaArcano implements EstrategiaDeMejora{
    @Override
    public void mejorar(Artefacto artefacto){
        if(artefacto.esDeTipo("Pergamino")){
            if(artefacto.getPoder() >= 30){
                artefacto.reducirPoder(10);
            }else{
                artefacto.incrementarPoder(25);
            }
        }
    }
}
