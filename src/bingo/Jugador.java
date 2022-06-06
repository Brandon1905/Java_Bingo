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
class Jugador extends Thread {
	final int TOTAL_CARTON = 5; // Cantidad de n�meros por cart�n
	final int TOTAL_BOMBO = 10; // N�meros posibles del bombo
	int idJugador; // Identificador del jugador
	HashSet<Integer> carton; // Para almacenar los n�meros pendientes de acertar
	Bombo b;

	/**
	 * @param identificador
	 *            del jugador
	 */
	Jugador(int idJugador, Bombo b) {
		this.b = b;
		this.idJugador = idJugador;
		carton = new HashSet<Integer>();
		while (carton.size() < TOTAL_CARTON)
			carton.add((int) Math.floor(Math.random() * TOTAL_BOMBO) + 1);
		System.out.println("CARTON JUGADOR: " + idJugador + carton);
	}

	/**
	 * Muestra el cart�n por pantalla con los n�meros pendientes
	 */
	void imprimeCarton() {
		System.out.print("Pendientes jugador " + idJugador + ": ");
		for (Integer integer : carton)
			System.out.print(integer + " ");
		System.out.println();
	}

	/**
	 * Tacha el n�mero del cart�n en caso de que exista
	 * 
	 * @param numero
	 *            a tachar
	 */
	void tacharNum(Integer numero) {
		carton.remove(numero);
	}

	/**
	 * M�todo encargado de las acciones del jugador.
	 */
	public void run() {
		while (carton.size() > 0) {// mientras que el cart�n no tenga tachados
									// todos los n�meros

			// imprimeCarton();
			b.consultar();// se consulta
			System.out.println("El jugador  " + idJugador + "  va ha jugar ");
			tacharNum(b.ultNumero);// se tacha el ultimo numero que ha salido
			for (Integer integer : b.bombo) {// se comprueba que hayamos tachado
												// todos los n�meros que han
												// salido, en su defecto se
												// tachan.
				carton.remove(integer);
			}

			System.out.println("El jugador  " + idJugador + "  ha jugado ");
			imprimeCarton();// SE IMPRIMEN LOS numeros PENDIENTES DE DICHO JUGADOR

		}
		System.out.println("el jugador " + idJugador + " ha hecho BINGO! <---------------BINGO--------------->");
		// si hace bingo termina la ejecucion del programa
		try {
			finalize();
			System.exit(0);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

