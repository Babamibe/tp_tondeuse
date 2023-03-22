package com.inetum.tp_tondeuse;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import com.inetum.tp_tondeuse.beans.Pelouse;
import com.inetum.tp_tondeuse.beans.Tondeuse;
import com.inetum.tp_tondeuse.enums.OrientationEnum;
import com.inetum.tp_tondeuse.service.TondeuseService;

public class TpTondeuse {
	

	public static void main(String[] args) {
		TondeuseService service = new TondeuseService();
		//Tondeuse tondeuse = new Tondeuse(1, 1, 2, OrientationEnum.N);
		
		
		try {
			URL url = TpTondeuse.class.getResource("/instructions.txt");
			//FileInputStream file = new FileInputStream("src/com/inetum/tp_tondeuse/resources/instructions.txt");
			Scanner scan = new Scanner(new File(url.getFile()));
			int xmax = scan.nextInt();
			int ymax = scan.nextInt();
			Pelouse pelouse = new Pelouse(xmax, ymax);
			Tondeuse tondeuse = new Tondeuse(1, scan.nextInt(), scan.nextInt(), OrientationEnum.valueOf(OrientationEnum.class, scan.next()));
			System.out.println(tondeuse);
			//service.lireInstructions( pelouse,tondeuse);
			System.out.println(pelouse);
			scan.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		Tondeuse tondeuse2 = new Tondeuse(2, 3, 3, OrientationEnum.E);
//		Pelouse pelouse = new Pelouse(5, 5);
//		System.out.println(tondeuse);
//		System.out.println(tondeuse2);
//		System.out.println(pelouse);
//		String instructions = "GAGAGAGAA";
//		char[] tab = instructions.toCharArray();
//		for (char c : tab) {
//			if(c == InstructionEnum.A.toString().charAt(0)) {
//				avancer(tondeuse, pelouse);
//			}else {
//				tourner(tondeuse, c);
//			}
//		}
//
//		System.out.println(tondeuse);
//		instructions = "AADAADADDA";
//		tab = instructions.toCharArray();
//		System.out.println(tab);
//		for (char c : tab) {
//			if(c == InstructionEnum.A.toString().charAt(0)) {
//				avancer(tondeuse2, pelouse);
//			}else {
//				tourner(tondeuse2, c);
//			}
//			System.out.println(tondeuse2);
//		}
//		System.out.println(tondeuse2);
	}


}
