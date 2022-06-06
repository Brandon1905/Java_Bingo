/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

/**
 *
 * @author Brandon
 */
/**
 * Clase que sirve para el hilo del presentador
 */
class Presentador extends Thread {
	Bombo c;
	// Bingo bing;
	//int aux;

	Presentador(Bombo c) {
		this.c = c;

	}

	/**
	 * El presentador saca un n�mero cada 2 segundos
	 */
	public void run() {
		try {

			for (int i = 0; i < c.TOTAL_BOMBO; i++) {// va sacando numeros hasta llegar al total
				Thread.sleep(2000);
				c.sacarNum();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		/*
		 * if (c.numvecJugado >= Bingo.numjugadores) { c.sacarNum();
		 * c.numvecJugado = 0; }else if (c.numvecJugado == 0){ c.sacarNum(); }
		 */

		// c.sacarNum();
		/*
		 * while (c.numvecJugado >= 5) { for (int i = 0; i < c.TOTAL_BOMBO; i++)
		 * { c.sacarNum(); c.numvecJugado = 0; } }
		 */
	}

}

