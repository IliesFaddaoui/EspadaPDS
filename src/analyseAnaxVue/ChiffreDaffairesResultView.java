package analyseAnaxVue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import analyseAnax.ChiffreDaffaires;
import analyseAnax.Magasins;
import analyseAnaxSocket.SocketMagasins;


public class ChiffreDaffairesResultView extends JFrame{

	
    private Font police = new Font("Arial", Font.BOLD, 14);
    private Font policeEspada = new Font("Arial", Font.BOLD, 28);
    
    
    public ChiffreDaffairesResultView(Collection<ChiffreDaffaires> chiffres, String type){

    	SocketMagasins magS = new SocketMagasins();
    	
        this.setTitle("PhyGit Mall: Turnover Indicators");
        this.setSize(new Dimension(600,600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        Collection<ChiffreDaffaires> cs = chiffres;
        JLabel espada = new JLabel("PhyGit Mall");
        JLabel resultats = new JLabel("Past month turnover for the shops of the category :"+type);
        
        
        JPanel top = new JPanel();
        JPanel west = new JPanel();
        JPanel east = new JPanel();
        JPanel center = new JPanel();
        JPanel bot = new JPanel();


        top.setPreferredSize(new Dimension(100,250));
        center.setPreferredSize(new Dimension(100,60));
        center.setBorder(BorderFactory.createLineBorder(Color.black));
        west.setPreferredSize(new Dimension(100,600));
        east.setPreferredSize(new Dimension(100,600));
        bot.setPreferredSize(new Dimension(100,250));

        GridLayout layoutTop = new GridLayout(2,2);
        GridLayout layoutCenter = new GridLayout(4,2);
        GridLayout layoutEast = new GridLayout(2,4);
        GridLayout layoutWest = new GridLayout(2,4);
        top.setLayout(layoutTop);
        center.setLayout(layoutCenter);
        east.setLayout(layoutEast);
        west.setLayout(layoutWest);

        espada.setFont(policeEspada);
        top.add(espada);
        top.add(resultats);

   for(ChiffreDaffaires c : cs) {
        	
        Magasins m = magS.getMagasin(c.getIdMagasin());
        
        JLabel result = new JLabel("Shop: "+m.getMagasinName()+"  |  Turnover: "+String.valueOf(c.getMontant()));
        center.add(result);
        }


        this.add(top, BorderLayout.NORTH);
        this.add(west, BorderLayout.WEST);
        this.add(east, BorderLayout.EAST);
        this.add(bot, BorderLayout.SOUTH);
        this.add(center, BorderLayout.CENTER);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
