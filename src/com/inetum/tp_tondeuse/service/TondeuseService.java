package com.inetum.tp_tondeuse.service;

import com.inetum.tp_tondeuse.beans.Pelouse;
import com.inetum.tp_tondeuse.beans.Tondeuse;
import com.inetum.tp_tondeuse.enums.InstructionEnum;
import com.inetum.tp_tondeuse.enums.OrientationEnum;

public class TondeuseService {

	private static void avancer(Tondeuse tondeuse, Pelouse pelouse) {
		switch (tondeuse.getOrientation()) {
		case N:
			if(tondeuse.getY() < pelouse.getYmax())
			tondeuse.setY(tondeuse.getY()+1);
			break;
		case S:
			if(tondeuse.getY() > 0 )
			tondeuse.setY(tondeuse.getY()-1);
			break;
		case W:
			if(tondeuse.getX() >0)
			tondeuse.setX(tondeuse.getX()-1);
			break;
		case E:
			if(tondeuse.getX() < pelouse.getXmax())
			tondeuse.setX(tondeuse.getX()+1);
			break;

		default:
			break;
		}
	}
	
	private static void tourner(Tondeuse tondeuse, char c) {
		if((tondeuse.getOrientation() == OrientationEnum.N && c =='G') || (tondeuse.getOrientation() == OrientationEnum.S && c == 'D')) {
			tondeuse.setOrientation(OrientationEnum.W);
		} else if((tondeuse.getOrientation() == OrientationEnum.N && c =='D') || (tondeuse.getOrientation() == OrientationEnum.S && c =='G')) {
			tondeuse.setOrientation(OrientationEnum.E);
		} else if((tondeuse.getOrientation() == OrientationEnum.W && c =='G') || (tondeuse.getOrientation() == OrientationEnum.E && c =='D')) {
			tondeuse.setOrientation(OrientationEnum.S);
		} else {
			tondeuse.setOrientation(OrientationEnum.N);
		}
		
	}
	
	public void lireInstructions(Pelouse pelouse, Tondeuse tondeuse) {
		System.out.println(tondeuse);
		//int index = 0;
		//Pelouse pelouse = new Pelouse(5,5);
		//Tondeuse tondeuse = new Tondeuse();
		String instructions ="GAGAGAGAA";
		char[] tabInstructions= instructions.toCharArray();
		for (char c : tabInstructions) {
			System.out.println(c);
			if(c == InstructionEnum.A.toString().charAt(0)) {
				avancer(tondeuse, pelouse);
			}else {
				tourner(tondeuse, c);
			}
			
			System.out.println(tondeuse);
		}
		System.out.println(tondeuse);
		
	}
}
