package com.inetum.tp_tondeuse.service;

/**
 * interface de gestion des tondeuses
 * @author frup87694
 *
 */
public interface TondeuseManagementService {
	
	/**
	 * appelle le reader pour la lecture du fichier
	 * @param url
	 */
	void lectureFichier(String url);
	
	/**
	 * affiche le traitement des tondeuses après lecture du fichier
	 */
	void afficherTraitement();

}
