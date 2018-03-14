package ejercicio_sudoku;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ivan
 */
public class Sudoku {

    ArrayList<Integer> columna;
    ArrayList<ArrayList<Integer>> fila;

    public Sudoku() {
        columna = new ArrayList();
        fila = new ArrayList();
    }

    /**
     * El metodo crea el sudoku, aun solo crear una matriz de 9x9 con 0;
     */
    public void inicializar() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                columna.add(0);
            }
            fila.add(columna);
            columna = new ArrayList();
        }
    }

    /**
     * El metodo muestra por pantalla el estado actual del sudoku
     *
     * @return String con el sudoku formateado
     */
    @Override
    public String toString() {
        String resultadoFinal = "  /1 /2 /3 /4 /5 /6 /7 /8 /9 /\n";
        for (int i = 1; i < fila.size() + 1; i++) {
            resultadoFinal += i + " " + fila.get(i - 1) + "\n";
        }

        return resultadoFinal;
    }

    /**
     * EL metodo modifica un elemento en la posicion indicada del sudoku
     *
     * @param fila el numero de la fila a modificar
     * @param columna el numero de la columna a modificar
     * @param elemento el valor que vamos a añadir al array
     * @throws SudokuException excepcion que se lanza si el valor o la posicion
     * no es valido
     */
    public void modificarElemento(int fila, int columna, int elemento) throws SudokuException {
        if (puedoInsertar(fila, columna, elemento) == true) {
            this.fila.get(fila).set(columna, elemento);
        } else {
            throw new SudokuException("Valor no valido");
        }

    }

    /**
     * El metodo cambia a cero la posicion dada de la matriz
     *
     * @param fila
     * @param columna
     */
    public void vaciarElemento(int fila, int columna) {
        this.fila.get(fila).set(columna, 0);
    }

    /**
     * EL metodo comprueba que el numero elegido no este en la fila seleccionada
     *
     * @param fila
     * @param elemento
     * @return devuelve un booleano
     */
    private boolean comprobarFila(int fila, int elemento) {
        boolean resultado = true;
        for (int i = 0; i < this.fila.size(); i++) {
            if (this.fila.get(fila).get(i) == elemento) {
                resultado = false;
            }
        }
        return resultado;
    }

    private boolean comprobarColumna(int columna, int elemento) {
        boolean resultado = true;
        for (int i = 0; i < fila.size(); i++) {
            if (fila.get(i).get(columna) == elemento) {

                resultado = false;
            }
        }
        return resultado;
    }

    private boolean comprobarCuadrante(int fila, int columna, int elemento) {
        boolean resultado = true;
        return resultado;
    }

    private boolean puedoInsertar(int fila, int columna, int elemento) {
        boolean resultado = true;
        resultado = comprobarFila(fila, elemento);
        if (resultado == true) {
            resultado = comprobarColumna(columna, elemento);
        }
        return resultado;
    }
}
