package com.inetum.tp_tondeuse;

import com.inetum.tp_tondeuse.service.TondeuseManagementServiceImpl;
//import com.inetum.tp_tondeuse.service.TondeuseService;

public class TpTondeuse {

	public static void main(String[] args) {

		TondeuseManagementServiceImpl service = new TondeuseManagementServiceImpl();
		service.lectureFichier("/instructions.txt");
		service.afficherTraitement();


	}

}
