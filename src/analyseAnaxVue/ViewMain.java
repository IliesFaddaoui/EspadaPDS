package analyseAnaxVue;

import server.Server;

/**
 * @author anaximandro
 * @version 1.2 Class which instances the main frame
 */

public class ViewMain {

	public static void main(String[] args) {
		Server s = new Server();
		s.open();
		ChiffreDaffairesView p1 = new ChiffreDaffairesView();
	}
}
