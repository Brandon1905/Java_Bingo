/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.HashSet;

/**
 *
 * @author Brandon
 */
/**
 * Clase que se utiliza para crear el objeto compartido entre todos los hilos
 * del programa
 */
class Bombo {
	int numvecJugado = 0;//numero de veces que se consulto
	int hayBola = 0;// indica si se ha repartido
	Jugador jug;
	final int TOTAL_BOMBO = 10; // N�meros posibles del bombo
	HashSet<Integer> bombo; // Para almacenar los valores que van saliendo
	Integer ultNumero; // �ltimo n�mero del bombo

	int aux = Bingo.numjugadores;

	/**
	 * Inicializa vac�o el bombo
	 */
	Bombo() {

		bombo = new HashSet<Integer>();

	}

	/**
	 * m�todo sincronizado que comprueba si se ha sacado bola
	 */
	synchronized void sacarNum() {

		while (hayBola != 0 /* && numvecJugado!= aux */) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		sacarNum2();
		imprimirBombo();
		hayBola++;
		// hayBola=0;
		notify();

	}

	/**
	 * Metodo encargado de sacar una bola, es llamado en sacarNum
	 * @return
	 */
	Integer sacarNum2() {
		Integer bolita = 0;
		int cantidadBolas = bombo.size();
		if (cantidadBolas < TOTAL_BOMBO) {
			do {
				ultNumero = (int) Math.floor(Math.random() * TOTAL_BOMBO) + 1;
				bombo.add(ultNumero);
				bolita = ultNumero;
			} while (cantidadBolas == bombo.size());
			System.out.println("Ha salido el n�mero: " + ultNumero);
		} else
			System.out.println("Ya han salido todas las bolas");
		return bolita;
	}

	/**
	 * metodo sincronizado accedido por los jugadores
	 */
	synchronized void consultar() {
		while (hayBola == 0 /* && numvecJugado>= aux */) {// si no se ha repartido, espera
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		numvecJugado++;
		hayBola--;
		notify();

	}

	/**
	 * Muestra todas las bolas que han salido hasta el momento
	 */
	void imprimirBombo() {
		System.out.print("Bolas sacadas hasta el momento: ");
		for (Integer integer : bombo)
			System.out.print(integer + " ");
		System.out.println();
	}

}


