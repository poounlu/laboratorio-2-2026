package ar.edu.unlu.poo.labo2.estrategias;

import ar.edu.unlu.poo.labo2.artefactos.Artefacto;

public class AlquimistaExperto implements EstrategiaDeMejora{
    @Override
    public void mejorar(Artefacto artefacto) {
        if(artefacto.esDeTipo("Poción")){
            artefacto.incrementarPoder(20);
            artefacto.limitarPoderMaximo(100);
        }
    }
}
