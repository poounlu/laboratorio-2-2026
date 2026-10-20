package ar.edu.unlu.poo.labo2.estrategias;

import ar.edu.unlu.poo.labo2.artefactos.Artefacto;

public class EscribaArcano implements EstrategiaDeMejora{
    @Override
    public void mejorar(Artefacto artefacto) {
        if(artefacto.esDeTipo("Pergamino")) {
            if (artefacto.getNivelDePoder() < 30) {
                artefacto.incrementarPoder(25);
            } else {
                artefacto.reducirPoder(10);
            }
        }
    }
}
