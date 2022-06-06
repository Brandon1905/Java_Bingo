/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.Scanner;

/**
 *
 * @author Brandon
 */
/**
 * Clase principal desde la que se inicializa el juego del Bingo
 */
public class Bingo {
	static int numjugadores;
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// se pregunta por teclado cuantos jugadores van a jugar
		System.out.println("SE ABRE EL BINGO");
		System.out.println("�CUANTOS JUGADORES VAN A JUGAR?");
		numjugadores = in.nextInt();

		Bombo bomb = new Bombo();// se crea el bombo, llenandose el mismo
		Thread jugador;

		// se crean los huilos jugadores
		for (int i = 1; i <= numjugadores; i++) {
			jugador = new Jugador(i, bomb);
			System.out.println("el jugador" + i + "esta preparado");
			jugador.start();// SE LANZAN
		}

		// se crea el hilo presentador, el cuaL cominza sacando un n�mero
		Thread present = new Presentador(bomb);
		present.start();// SE LANZAN

	}
}
    
