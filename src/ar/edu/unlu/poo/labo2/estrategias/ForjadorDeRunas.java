package ar.edu.unlu.poo.labo2.estrategias;

import ar.edu.unlu.poo.labo2.artefactos.Artefacto;

public class ForjadorDeRunas implements EstrategiaDeMejora{
    @Override
    public void mejorar(Artefacto artefacto){
        if(artefacto.esDeTipo("Varita")){
            artefacto.incrementarPoder(15);
        }
    }
}
