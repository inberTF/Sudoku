/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_sudoku;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivan
 */
public class Ejercicio_sudoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Sudoku su = new Sudoku();
        int fila, columna, elemento;
        boolean con = false;
        Scanner teclado = new Scanner(System.in);
        System.out.println("SUDOKU:\n"
                + "1- JUGAR\n"
                + "2- SALIR");
        int op = teclado.nextInt();

        if (op == 1) {
            su.inicializar();
            while (con == false) {
                System.out.println("¿Que Quieres Hacer\n?"
                        + "1- añadir un numero\n"
                        + "2- ver sudoku");
                op = teclado.nextInt();
                switch (op) {
                    case 1:
                        System.out.println("Dime la fila:");
                        fila = teclado.nextInt();
                        System.out.println("Dime la columna:");
                        columna = teclado.nextInt();
                        System.out.println("Dime el numero que quieres añadir:");
                        elemento = teclado.nextInt();
                         {
                            try {
                                su.modificarElemento(fila, columna, elemento);
                            } catch (SudokuException ex) {
                                Logger.getLogger(Ejercicio_sudoku.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                    case 2:
                        System.out.println(su.toString());
                        break;

                }
                boolean con2= false;
                for (int i = 0; i < su.fila.size(); i++) {
                    for (int j = 0; j < su.fila.get(i).size(); j++) {
                        
                        if (su.fila.get(i).get(j) == 0) {
                            con = false;
                            con2 = true;
                        }
                        if((su.fila.get(i).get(j) !=0) && (con2 = false))
                        {
                            System.out.println("Has completado el sudoku");
                            con = true;
                        }
                        
                    }
                }
            }
        }
    }

}
