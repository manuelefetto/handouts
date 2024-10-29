/*

Copyright 2024 Massimo Santini

This file is part of "Programmazione 2 @ UniMI" teaching material.

This is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This material is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this file.  If not, see <https://www.gnu.org/licenses/>.

*/

package it.unimi.di.prog2.e06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/** Esercizio 4.3 di PDJ. */
public class SumClient {

  /** . */
  private SumClient() {}

  // Il main di questa classe legge dal flusso di ingresso una sequenza di al
  // più 100 interi e ne emette la somma nel flusso d'uscita.

  /** Calcola e restituisce la somma degli elementi di un vettore
   *
   *
   * @param a l'array di cui fare la somma
   * @return la somma degli elementi dell'array {@code a} o 0 se {@code a} è vuoto
   * @throws NullPointerException se {@code a} è {@code null}
   */
  public static int sum(int[] a) throws  NullPointerException{
    if(a == null){
      throw new NullPointerException("a è null");
    }

    int somma = 0;

    for (int n : a)
      somma += n;

    return somma;

  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    ArrayList<Integer> numeri = new ArrayList<>();

    while (s.hasNextInt()){
      numeri.add(s.nextInt());
    }

    System.out.println(sum(numeri.stream().mapToInt((i)->i).toArray()));

  }
}
