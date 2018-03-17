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
     * El metodo crea el sudoku, solo crea un sudoku siempre el mismo;
     */
    public void inicializar() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == 0) {
                    if (j == 1) {
                        columna.add(4);
                    } else {
                        if (j == 2) {
                            columna.add(2);
                        } else {
                            if (j == 5) {
                                columna.add(7);
                            } else {
                                columna.add(0);
                            }
                        }
                    }
                } else {
                    if (i == 1) {
                        if (j == 1) {
                            columna.add(3);
                        } else {
                            if (j == 2) {
                                columna.add(5);
                            } else {
                                if (j == 6) {
                                    columna.add(7);
                                } else {
                                    if (j == 8) {
                                        columna.add(4);
                                    } else {
                                        columna.add(0);
                                    }
                                }
                            }
                        }
                    } else {
                        if (i == 2) {
                            if (j == 1) {
                                columna.add(9);
                            } else {
                                columna.add(0);
                            }
                        } else {
                            if (i == 3) {
                                if (j == 5) {
                                    columna.add(8);
                                } else {
                                    if (j == 5) {
                                        columna.add(5);
                                    } else {
                                        if (j == 5) {
                                            columna.add(4);
                                        } else {
                                            if (j == 5) {
                                                columna.add(9);
                                            } else {
                                                columna.add(0);
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (i == 4) {
                                    if (j == 0) {
                                        columna.add(8);
                                    } else {
                                        if (j == 4) {
                                            columna.add(9);
                                        } else {
                                            if (j == 5) {
                                                columna.add(4);
                                            } else {
                                                if (j == 6) {
                                                    columna.add(6);
                                                } else {
                                                    if (j == 8) {
                                                        columna.add(2);
                                                    } else {
                                                        columna.add(0);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (i == 5) {
                                        if (j == 3) {
                                            columna.add(3);
                                        } else {
                                            if (j == 5) {
                                                columna.add(6);
                                            } else {
                                                if (j == 8) {
                                                    columna.add(7);
                                                } else {
                                                    columna.add(0);
                                                }
                                            }
                                        }
                                    } else {
                                        if (i == 6) {
                                            if (j == 1) {
                                                columna.add(1);
                                            } else {
                                                if (j == 5) {
                                                    columna.add(9);
                                                } else {
                                                    if (j == 6) {
                                                        columna.add(4);
                                                    } else {
                                                        columna.add(0);
                                                    }
                                                }
                                            }
                                        } else {
                                            if (i == 7) {
                                                if (j == 3) {
                                                    columna.add(1);
                                                } else {
                                                    if (j == 7) {
                                                        columna.add(9);
                                                    } else {
                                                        if (j == 8) {
                                                            columna.add(3);
                                                        } else {
                                                            columna.add(0);
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (i == 8) {
                                                    if (j == 0) {
                                                        columna.add(9);
                                                    } else {
                                                        if (j == 3) {
                                                            columna.add(6);
                                                        } else {
                                                            if (j == 4) {
                                                                columna.add(4);
                                                            } else {
                                                                if (j == 5) {
                                                                    columna.add(3);
                                                                } else {
                                                                    if (j == 8) {
                                                                        columna.add(5);
                                                                    } else {
                                                                        columna.add(0);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

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

    /**
     * El metodo comprueba si en la columna indicada esta ya el elemento que le
     * llega
     *
     * @param columna es el numero de la columna
     * @param elemento es el valor que tiene que comprobar si existe
     * @return devuelve un booleano dependiendo de si se puede colocar ahi el
     * valor o no
     */
    private boolean comprobarColumna(int columna, int elemento) {
        boolean resultado = true;
        for (int i = 0; i < fila.size(); i++) {
            if (fila.get(i).get(columna) == elemento) {
                resultado = false;
            }
        }
        return resultado;
    }

    /**
     * El metodo comprueba si el cuadrante en el que queremos introducir el
     * valor es posible o no
     *
     * @param fila
     * @param columna
     * @param elemento
     * @return
     */
    private boolean comprobarCuadrante(int fila, int columna, int elemento) {
        boolean resultado = true;
        if (fila <= 2) {
            if (columna <= 2) {
                for (int i = 0; i <= 2; i++) {
                    for (int j = 0; j <= 2; j++) {
                        if (this.fila.get(i).get(j) == elemento) {
                            resultado = false;
                        }
                    }
                }
            }
            if (columna == 3 || columna <= 5) {
                for (int i = 3; i <= 5; i++) {
                    for (int j = 3; j <= 5; j++) {
                        if (this.fila.get(i).get(j) == elemento) {
                            resultado = false;
                        }
                    }
                }
            }
            if (columna == 6 || columna <= 8) {
                for (int i = 6; i <= 8; i++) {
                    for (int j = 6; j <= 8; j++) {
                        if (this.fila.get(i).get(j) == elemento) {
                            resultado = false;
                        }
                    }
                }
            }

        }
        if (fila == 3 || fila <= 5) {
            if (columna <= 2) {
                for (int i = 0; i <= 2; i++) {
                    for (int j = 0; j <= 2; j++) {
                        if (this.fila.get(i).get(j) == elemento) {
                            resultado = false;
                        }
                    }
                }
            }
            if (columna == 3 || columna <= 5) {
                for (int i = 3; i <= 5; i++) {
                    for (int j = 3; j <= 5; j++) {
                        if (this.fila.get(i).get(j) == elemento) {
                            resultado = false;
                        }
                    }
                }
            }
            if (columna == 6 || columna <= 8) {
                for (int i = 6; i <= 8; i++) {
                    for (int j = 6; j <= 8; j++) {
                        if (this.fila.get(i).get(j) == elemento) {
                            resultado = false;
                        }
                    }
                }
            }
        }
        if (fila == 6 || fila <= 8) {
            if (columna <= 2) {
                for (int i = 0; i <= 2; i++) {
                    for (int j = 0; j <= 2; j++) {
                        if (this.fila.get(i).get(j) == elemento) {
                            resultado = false;
                        }
                    }
                }
            }
            if (columna == 3 || columna <= 5) {
                for (int i = 3; i <= 5; i++) {
                    for (int j = 3; j <= 5; j++) {
                        if (this.fila.get(i).get(j) == elemento) {
                            resultado = false;
                        }
                    }
                }
            }
            if (columna == 6 || columna <= 8) {
                for (int i = 6; i <= 8; i++) {
                    for (int j = 6; j <= 8; j++) {
                        if (this.fila.get(i).get(j) == elemento) {
                            resultado = false;
                        }
                    }
                }
            }
        }
        return resultado;
    }

    /**
     * El metodo llama uno por uno a todos los metodos para comprobar si es
     * posible introducir el valor en el sudoku
     *
     * @param fila
     * @param columna
     * @param elemento
     * @return
     */
    private boolean puedoInsertar(int fila, int columna, int elemento) {
        boolean resultado = true;
        if (resultado == true) {
            resultado = comprobarFila(fila, elemento);
        }
        if (resultado == true) {
            resultado = comprobarColumna(columna, elemento);
        }
        if (resultado == true) {
            resultado = comprobarCuadrante(fila, columna, elemento);
        }
        return resultado;
    }
}
