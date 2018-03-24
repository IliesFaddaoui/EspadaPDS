package socketServer;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TS {
	
	JSONParser parser;
	private String filename;
	
	public TS(String filename) {
		this.filename = filename;
	}
	//
    public ClientDAO toto() {
    	parser = new JSONParser();
    	ClientDAO cl;
    	try {

    		Object obj = parser.parse(new FileReader(filename));

    		JSONObject jsonObject = (JSONObject) obj;
    		String nomClient = (String) jsonObject.get("nom");
    		String prenomClient = (String) jsonObject.get("prenom");
    		
    		cl = new ClientDAO(nomClient, prenomClient);
       
    		System.out.println("Nom: " + nomClient);
    		System.out.println("Prenom: " + prenomClient);
    		return cl;
        }

    	catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
}
