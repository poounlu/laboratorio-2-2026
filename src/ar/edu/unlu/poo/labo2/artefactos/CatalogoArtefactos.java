package ar.edu.unlu.poo.labo2.artefactos;

import ar.edu.unlu.poo.labo2.estrategias.EstrategiaDeMejora;

import java.util.*;

public class CatalogoArtefactos {
    private final EstrategiaDeMejora estrategia;
    private final Set<Artefacto> artefactos;

    public CatalogoArtefactos(EstrategiaDeMejora estrategia){
        this.estrategia = estrategia;
        this.artefactos = new HashSet<>();
    };

    // Constructor por defecto (Compatibilidad Labo 1)
    public CatalogoArtefactos() {
        this.artefactos = new HashSet<>();
        this.estrategia = null;
    }




    // =========================================================================
    // Métodos del Laboratorio 1 (Colecciones)
    // =========================================================================

    public void agregarArtefacto(Artefacto artefacto) {
        if (artefacto != null) {
            this.artefactos.add(artefacto);
        }
    }

    public Set<Artefacto> obtenerArtefactosUnicos() {
        return Collections.unmodifiableSet(this.artefactos);
    }

    public List<Artefacto> buscarArtefactosPorTipo(String tipo) {
        List<Artefacto> resultado = new ArrayList<>();
        for (Artefacto a : this.artefactos) {
            if (a.esDeTipo(tipo)) {
                resultado.add(a);
            }
        }
        // Ordenar de mayor a menor poder
        resultado.sort((a1, a2) -> Integer.compare(a2.getNivelDePoder(), a1.getNivelDePoder()));
        return resultado;
    }

    public Map<String, Integer> contarArtefactosPorTipo() {
        Map<String, Integer> conteo = new HashMap<>();
        for (Artefacto a : this.artefactos) {
            conteo.put(a.getTipo(), conteo.getOrDefault(a.getTipo(), 0) + 1);
        }
        return conteo;
    }

    public Artefacto obtenerArtefactoMasPoderoso() {
        if (this.artefactos.isEmpty()) {
            return null;
        }
        Artefacto max = null;
        for (Artefacto a : this.artefactos) {
            if (max == null || a.getNivelDePoder() > max.getNivelDePoder()) {
                max = a;
            }
        }
        return max;
    }

    public void aplicarMejoras(){
        for(Artefacto artefacto : artefactos ){
           estrategia.mejorar(artefacto);
        }
    }
}