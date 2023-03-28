package com.inetum.tp_tondeuse.beans;

import com.inetum.tp_tondeuse.enums.OrientationEnum;

/**
 * une classe tondeuse avec une coordonnée x, une coordonnée y et une orientation
 * @author frup87694
 *
 */
public class Tondeuse {

	private int id;
	private int x;
	private int y;
	private OrientationEnum orientation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public OrientationEnum getOrientation() {
		return orientation;
	}
	public void setOrientation(OrientationEnum orientation) {
		this.orientation = orientation;
	}
	@Override
	public String toString() {
		return "Tondeuse n°" + id + ": " + x + " " + y + " " + orientation;
	}
	public Tondeuse() {
		super();
	}
	
	
	public Tondeuse(int x, int y, OrientationEnum orientation) {
		super();
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}
	public Tondeuse(int id, int x, int y, OrientationEnum orientation) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}
	
	
	
}
