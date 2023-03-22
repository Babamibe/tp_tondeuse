package com.inetum.tp_tondeuse.beans;

/**
 * une classe pelouse avec une limite largeur y et une limite longeur y
 * @author frup87694
 *
 */
public class Pelouse {

	int xmax;
	int ymax;
	
	public Pelouse() {
		super();
	}
	
	
	public Pelouse(int xmax, int ymax) {
		super();
		this.xmax = xmax;
		this.ymax = ymax;
	}
	
	


	@Override
	public String toString() {
		return "Pelouse [xmax=" + xmax + ", ymax=" + ymax + "]";
	}


	public int getXmax() {
		return xmax;
	}

	public int getYmax() {
		return ymax;
	}

	
	
}
