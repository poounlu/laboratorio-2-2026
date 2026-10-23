# Sistema de Gestión de Artefactos Mágicos de Instanciaveria

* **Actividad:** Laboratorio 2 - POO 2026 (11[02]76)
* * **Tema:** Inversión de Control (IoC), Inyección de Dependencias (DI) y Polimorfismo
* **Modalidad:** Taller presencial en parejas (Pair Programming con rotación de roles)
* **Fecha:** 20-10-2026
* **Duración:** de 18 a 21.
* **Entregable:** Pull Request al repositorio oficial antes de las 21:00 hs

---

# Integrantes del Grupo

- Ciro D - 49
- Ignacio J - 47
- Luna L - 95

---

# Contexto / Escenario

¡El Torneo de los Tres Reinos es inminente! La Academia de Hechicería Arcana ha reunido a un concilio 
de los más grandes artesanos para potenciar su arsenal. Un maestro **Herrero Enano** aplicará su magia 
rúnica a las _varitas_, y un delicado **Artesano Élfico** es especialista en encantar _amuletos_. Además, 
un sabio **Escriba Arcano** ha sido convocado para re-inscribir los _pergaminos_ de poder, aunque su magia 
es volátil y arriesgada. Finalmente, un **Alquimista Experto** está destilando pociones para fortalecer a 
los campeones, asegurándose de que no excedan los límites mortales.

El sistema actual del `CatalogoArtefactos` es demasiado rígido para manejar estas especialidades.
Tu misión es refactorizar el sistema para que pueda colaborar con las distintas **Estrategias de Mejora**
sin necesidad de modificar su código interno cada vez que un nuevo artesano se una a la causa. Para ello, 
te valeras de la antigua sabiduria conocida como **Principio de Inversión de Dependencias (DIP)**.

---

# Objetivo del Laboratorio

1. Aplicar **Inversión de Control (IoC)** desacoplando la clase cliente de sus colaboradores concretos.
2. Implementar **Inyección de Dependencias por Constructor** garantizando inmutabilidad y estado consistente.
3. Utilizar **interfaces y polimorfismo** para lograr extensibilidad sin modificar código existente.
4. Experimentar la **testabilidad con dobles de prueba (Mocks)** en JUnit 5.
5. Practicar **Pair Programming profesional** con el protocolo Driver/Navigator y rotación de roles.

---

# Consigna de Trabajo: Estructura "Core + Challenge"

## Fase 1: El Núcleo Obligatorio (Core - 60 min)

1. **Definir el Contrato (`EstrategiaDeMejora`):**
    * Crear la interfaz `ar.edu.unlu.poo.labo2.estrategias.EstrategiaDeMejora` con el método:
      ```java
      void mejorar(Artefacto artefacto);
      ```

2. **Refactorizar el Cliente (`CatalogoArtefactos`):**
    * Incorporar un constructor que reciba e inyecte una `EstrategiaDeMejora`:
      ```java
      public CatalogoArtefactos(EstrategiaDeMejora estrategia);
      ```
    * Mantener el constructor por defecto `public CatalogoArtefactos()` para preservar la compatibilidad con el Laboratorio 1.
    * Implementar el método de negocio:
      ```java
      public void aplicarMejoras();
      ```
      Debe recorrer todos los artefactos del catálogo y delegar la mejora en la estrategia inyectada.

3. **Implementar los Especialistas Base:**
    * `ForjadorDeRunas`: si el artefacto es de tipo `"Varita"`, incrementa su poder en **+15**.
    * `AlquimistaExperto`: si el artefacto es de tipo `"Poción"`, incrementa su poder en **+20**, con un **tope máximo estricto de 100**.

---

## Fase 2: El Desafío Arquitectónico (Challenge - 25 min)

* **El Concilio de Artesanos (`EstrategiaCompuesta`):**
    * Para las pruebas finales del torneo, un artefacto debe ser mejorado por múltiples artesanos secuencialmente en una sola pasada.
    * Implementar la clase `EstrategiaCompuesta` (patrón estructural *Composite*) que implemente `EstrategiaDeMejora` y reciba en su constructor una lista o varargs de estrategias:
      ```java
      public EstrategiaCompuesta(EstrategiaDeMejora... estrategias);
      ```
      (tip: googlear `varargs java` y ver usos)
    * Al llamar a `mejorar(artefacto)`, debe aplicar cada estrategia contenida sobre el artefacto.
    * *Observación clave:* `CatalogoArtefactos` no debe cambiar en absoluto.

---

## Fase 3: Extensión Opcional (Bonus)
Si tu grupo completó las Fases 1 y 2 antes del tiempo límite, implementar:
* `JoyeroElfico`: si es `"Amuleto"`, duplica el poder si es $<50$, o incrementa un 25% si es $\ge 50$.
* `EscribaArcano`: si es `"Pergamino"`, suma $+25$ si poder $<30$, o resta $-10$ si es $\ge 30$ (inestabilidad mágica).

---

## Metodología de Trabajo en el Aula

1. **Pair Programming (Driver / Navigator):**
   * Una sola computadora por dupla.
   * **Minuto 0 a 45:** Estudiante A programa (Driver), Estudiante B supervisa y revisa tests (Navigator).
   * **Minuto 45:** **Rotación optativa (docente avisará el momento).** Estudiante B toma el teclado para implementar las estrategias y el desafío composite.
2. **Ciclo TDD:**
   * Ejecutar los tests en rojo (*Red*).
   * Escribir el código mínimo para pasar a verde (*Green*).
   * Refactorizar.
   * **Regla estricta:** No modificar los tests provistos.
3. **Entrega Formal (Últimos 15 min):**
   * Commit + Push a tu fork de GitHub.
   * Abrir un Pull Request al repositorio de la asignatura antes de las 21:00 hs.
