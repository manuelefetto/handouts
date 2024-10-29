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
import java.util.Arrays;
import java.util.Scanner;

/** Esercizio 4.2 di PDJ. */
public class SearchClient {

  /** . */
  private SearchClient() {}

  // Il main fi questa classe legge dal flusso di ingresso una sequenza di
  // interi (separati da spazi) e, assumendo che sia ordinata in ordine
  // crescente, emette nel flusso d'uscita la posizione dell'intero specificato
  // sulla linea di comando (se presente nell'input), o -1 viceversa.

  /** Ricerca un elemento all'interno di un array ordinato
   *
   * @param a un array ordinato da cui estrarre l'elemento da cercare
   * @param x l'elemento da cercare
   * @return la posizione nell'array {@code a} dell'elemento cercato {@code x}
   * @throws NullPointerException se {@code a} è {@code null}
   */
  public static int search (int[ ] a, int x) throws NullPointerException{
    if (a == null) throw new NullPointerException("a è null");


    int l = 0, r = a.length-1;

    while(l<=r){
      int m = (l+r) / 2;

      if (m == x) return m;

      if (a[m]<x){
        r = m-1;
      }else{
        l = m+1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    ArrayList<Integer> numeri = new ArrayList<>();

    while (s.hasNextInt()){
      numeri.add(s.nextInt());
    }
    // converto la lista di interi in un array di interi statico e converto il primo argomento da linea di comando in int
    System.out.println(search(numeri.stream().mapToInt((i)->i).toArray(),Integer.parseInt(args[0])));
  }
}
