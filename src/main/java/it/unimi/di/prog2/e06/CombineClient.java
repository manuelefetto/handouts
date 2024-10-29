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
import java.util.List;
import java.util.Scanner;

/** Esercizio 4.4 di PDJ. */
public class CombineClient {

  /** . */
  private CombineClient() {}

  /**
   * Decodifica una stringa contenente interi separati da spazi.
   *
   * @param string la stringa in ingresso, non può essere {@code null} e deve contenere interi
   *     separati da spazi.
   * @return gli interi contenuti nella stringa.
   */
  private static int[] parseInts(String string) {
    List<Integer> list = new ArrayList<>();
    try (Scanner sl = new Scanner(string)) {
      while (sl.hasNextInt()) list.add(sl.nextInt());
    }
    int[] result = new int[list.size()];
    for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
    return result;
  }

  /**
   *  Moltiplica ogni elemento dell'array {@code a} per la somma di tutti gli elementi dell'array {@code b} e inserisce
   *  i risultati nel corrispondente elemento dell'array {@code a}.
   *
   *
   * @param a l'array a cui moltiplicare la somma degli elementi di {@code b}
   * @param b l'array di cui calcolare la somma degli elementi da moltiplicare a tutti gli elementi dell'array {@code a}
   *
   * @throws NullPointerException se {@code a} o {@code b} sono {@code null} o sono vuote
   */
  static void combine (int[ ] a, int[ ] b) throws NullPointerException{

    if(a == null || b == null || a.length==0 || b.length==0){
      throw new NullPointerException("a or b sono null o vuote");
    }

    int somma = Arrays.stream(b).sum();

    for (int i = 0; i < a.length; i++){
      a[i] *= somma;
    }

  }

  public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int[] a = parseInts(sc.nextLine());
     int[] b = parseInts(sc.nextLine());
     combine(a,b);
      for (int j : a) {
          System.out.println(j);
      }
  }

  // Il main di questa classe legge due righe dal flusso di ingresso ciascuna
  // delle quali contiene gli interi (separati da spazi) di uno dei due array da
  // combinare e ne emette il risultato della combinazione (separando gli interi
  // uno per linea). Può avvalersi della funzione precedente per decodificare
  // ciascuna delle due linee in ingresso.

}
