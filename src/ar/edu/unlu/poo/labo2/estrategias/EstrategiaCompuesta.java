package ar.edu.unlu.poo.labo2.estrategias;

import ar.edu.unlu.poo.labo2.artefactos.Artefacto;

public class EstrategiaCompuesta implements EstrategiaDeMejora{
    private final EstrategiaDeMejora estrategias[];
    public EstrategiaCompuesta(EstrategiaDeMejora... estrategias){
        this.estrategias = estrategias;
    }

    @Override
    public void mejorar(Artefacto artefacto) {
        for(EstrategiaDeMejora estrategia : estrategias){
            estrategia.mejorar(artefacto);
        }
    }
}
