package com.inetum.tp_tondeuse.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.inetum.tp_tondeuse.TpTondeuse;
import com.inetum.tp_tondeuse.beans.Pelouse;
import com.inetum.tp_tondeuse.beans.Tondeuse;
import com.inetum.tp_tondeuse.enums.OrientationEnum;

/**
 * gestion de la lecture du fichier .txt
 * @author frup87694
 *
 */
public class TondeuseFileReaderImpl implements TondeuseFileReader {

	/**
	 * Scanner pour la lecture du fichier
	 */
	private Scanner scan;
	
	/**
	 * la pelouse du fichier
	 */
	private Pelouse pelouse;
	
	/**
	 * liste stockant les tondeuses du fichier
	 */
	private List<Tondeuse> tondeuses; 
	
	/**
	 * map stockant les instructions par id de tondeuse
	 */
	private Map<Integer, String> instructions;
	
	/**
	 * gestion de l'i des tondeuses
	 */
	private int id = 0;
	
	/**
	 * constructeur du reader
	 * @param url l'url du fichier
	 * @throws FileNotFoundException
	 */
	public TondeuseFileReaderImpl(String url) throws FileNotFoundException {
		this.scan = new Scanner(new File(getUrl(url).getFile()));
		this.tondeuses = new ArrayList<>();
		this.instructions = new HashMap<>();
		this.id = 0;
	}
	
	/**
	 * vérification que la ligne d'instructions correspond à 'A', 'G' ou 'D'
	 */
	private static final String LIGNE_INSTRUCTIONS_REGEX = "^[AGD]+$";
	
	/**
	 * vérification que le format ligne tondeuse correspond à 
	 * digit espace digit espace 
	 * et 'N' ou 'W' ou 'E' ou 'S'
	 */
	private static final String LIGNE_TONDEUSE_REGEX = "^(\\d+)\\s(\\d+)\\s+[NWSE]$";
	
	/**
	 * vérification que le format de la ligne pelouse correspond à digit espace digit
	 */
	private static final String LIGNE_PELOUSE_REGEX = "^(\\d+)\\s+(\\d+)$";

	private boolean isRead() {
		return this.instructions != null && this.pelouse != null && this.tondeuses != null;
	}
	
	/**
	 * recupère l'URL du fichier à lire
	 */
	@Override
	public URL getUrl(String url) {
		
		return TpTondeuse.class.getResource(url);
	}

	/**
	 * 
	 */
	@Override
	public Pelouse readFirstLine() {
		if(!isRead()) {
			this.readFile();
		}		
		return this.pelouse;
		
	}

	/**
	 * 
	 */
	@Override
	public List<Tondeuse> getTondeuseInformation() {
		if(!isRead()) {
			this.readFile();
		}					
		return this.tondeuses;
	}

	/**
	 * 
	 */
	@Override
	public Map<Integer, String> getInstructions() {
		if(!isRead()) {
			this.readFile();
		}		
		return this.instructions;
	}

	/**
	 * parcourt chaque ligne du fichier
	 * vérifie le pattern de la ligne
	 * crée pelouse si le pattern matche
	 * crée tondeuse et ajoute à la liste si le pattern matche
	 * crée instruction et ajoute à la map avec l'id de la tondeuse correspondante
	 * @param url l'url du fichier à lire
	 * @throws Exception
	 */
	public void readFile() {
		Tondeuse tondeuse;
		String line;
		
		while (scan.hasNextLine()) {
			line = scan.nextLine();
			if(line.matches(LIGNE_PELOUSE_REGEX)) {
				String[] coordonnees= line.split(" ");
				int xmax = Integer.valueOf(coordonnees[0]);
				int ymax = Integer.valueOf(coordonnees[1]);
				pelouse = new Pelouse(xmax, ymax);
			}
			else if(line.matches(LIGNE_TONDEUSE_REGEX)) {
				String[] positionInit = line.split(" ");
				int x = Integer.valueOf(positionInit[0]);
				int y = Integer.valueOf(positionInit[1]);
				OrientationEnum orientation = OrientationEnum.valueOf(positionInit[2]);
				tondeuse = new Tondeuse(id,x, y, orientation);
				tondeuses.add(tondeuse);
				id++;
			}
			else if(line.matches(LIGNE_INSTRUCTIONS_REGEX)) {
				this.instructions.put(id-1, line);
			}
			
		}
	}
}
