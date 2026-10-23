package ar.edu.unlu.poo.labo2.estrategias;

import ar.edu.unlu.poo.labo2.artefactos.Artefacto;

public class JoyeroElfico implements EstrategiaDeMejora{
    @Override
    public void mejorar(Artefacto artefacto){
        if(artefacto.esDeTipo("Amuleto")){
            if(artefacto.getPoder() >= 50){
                artefacto.incrementarPoderPorcentual(0.25);
            }else{
                artefacto.incrementarPoderPorcentual(1);
            }
        }
    }
}
