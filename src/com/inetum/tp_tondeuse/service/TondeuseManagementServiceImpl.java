package com.inetum.tp_tondeuse.service;

import java.util.List;
import java.util.Map;

import com.inetum.tp_tondeuse.beans.Pelouse;
import com.inetum.tp_tondeuse.beans.Tondeuse;
import com.inetum.tp_tondeuse.enums.InstructionEnum;
import com.inetum.tp_tondeuse.enums.OrientationEnum;
import com.inetum.tp_tondeuse.reader.TondeuseFileReaderImpl;

/**
 * implementation de la gestion des tondeuses
 * @author frup87694
 *
 */
public class TondeuseManagementServiceImpl implements TondeuseManagementService {
	
	private TondeuseFileReaderImpl reader;
	
	@Override
	public void lectureFichier(String url) {
		try {
			this.reader = new TondeuseFileReaderImpl(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void afficherTraitement() {
		if(this.reader == null) {
			System.out.println("Erreur de chargement du lecteur de fichier");
			return;
		}
		Pelouse pelouse = this.reader.readFirstLine();
		List<Tondeuse> tondeuses = this.reader.getTondeuseInformation();
		Map<Integer, String> instructionsTondeuses = this.reader.getInstructions();
		System.out.println("Dimensions de la pelouse: " +pelouse);
		System.out.println("Nombre de tondeuses: " + tondeuses.size());
		for (Map.Entry<Integer, String> combinaison : instructionsTondeuses.entrySet()) {
			Tondeuse tondeuse = tondeuses.get(combinaison.getKey());
			System.out.println("Position initiale: " + tondeuse);
			String instructionDeLaTondeuse = combinaison.getValue();
			char[] tabInstructions= instructionDeLaTondeuse.toCharArray();
			for (char c : tabInstructions) {				
				InstructionEnum instruction = InstructionEnum.valueOf(String.valueOf(c));
				if( InstructionEnum.A == instruction ) {
					avancer(tondeuse, pelouse);
				}else {
					tourner(tondeuse, c);
				}
				
			}
			System.out.println("Position finale: " + tondeuse);
		}
		
	}

	/**
	 * verifie la position de la tondeuse sur la pelouse
	 * fait avancer la tondeuse en fonction de son orientation
	 * ne bouge pas la tondeuse si elle sort de la pelouse
	 * @param tondeuse
	 * @param pelouse
	 */
	private void avancer(Tondeuse tondeuse, Pelouse pelouse) {
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
	
	/**
	 * tourne la tondeuse en fonction de son orientation de depart et de l'instruction reçue
	 * @param tondeuse
	 * @param c
	 */
	private void tourner(Tondeuse tondeuse, char c) {
		InstructionEnum instruction = InstructionEnum.valueOf(String.valueOf(c));
		if((tondeuse.getOrientation() == OrientationEnum.N && InstructionEnum.G == instruction) || (tondeuse.getOrientation() == OrientationEnum.S && InstructionEnum.D == instruction)) {
			tondeuse.setOrientation(OrientationEnum.W);
		} else if((tondeuse.getOrientation() == OrientationEnum.N && InstructionEnum.D == instruction) || (tondeuse.getOrientation() == OrientationEnum.S && InstructionEnum.G == instruction)) {
			tondeuse.setOrientation(OrientationEnum.E);
		} else if((tondeuse.getOrientation() == OrientationEnum.W && InstructionEnum.G == instruction) || (tondeuse.getOrientation() == OrientationEnum.E && InstructionEnum.D ==instruction)) {
			tondeuse.setOrientation(OrientationEnum.S);
		} else {
			tondeuse.setOrientation(OrientationEnum.N);
		}
		
	}


}
