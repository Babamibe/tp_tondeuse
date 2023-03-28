
package com.inetum.tp_tondeuse.reader;

import java.net.URL;
import java.util.List;
import java.util.Map;

import com.inetum.tp_tondeuse.beans.Pelouse;
import com.inetum.tp_tondeuse.beans.Tondeuse;

/**
 * interface de lecture du fichier de gestion des tondeuses
 * @author frup87694
 *
 */
public interface TondeuseFileReader {

	URL getUrl(String url);
	
	Pelouse readFirstLine();
	
	List<Tondeuse> getTondeuseInformation();
	
	Map<Integer, String> getInstructions();
}
