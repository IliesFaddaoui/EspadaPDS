package redevanceDan;

import connexion.Database;
import connexion.PoolDeConnexion;
import dao.ChiffreDaffairesDAO;
import dao.MagasinsDAO;
import pojo.ChiffreDaffaires;
import pojo.Magasins;
import dao.EmplacementsDAO;
import pojo.Emplacements;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collection;

public class FactureView extends JFrame{

  PoolDeConnexion connection= new PoolDeConnexion(10);


      private JLabel searchBill = new JLabel("Look for a bill: ");
      private JButton bSearchBill = new JButton("Search ");
      public JTextField jtfSearchBill = new JTextField();
      private JLabel fee = new JLabel("Fee details");
      
      Font police = new Font("Arial", Font.BOLD, 14);

      
          public FactureView(){
          this.setTitle("PhyGit Mall 3.0 : Fee Bill  ");
          this.setSize(1000,1000);
          this.setLocationRelativeTo(null);
          JPanel top = new JPanel();
          JPanel west = new JPanel();
          JPanel east = new JPanel();
          JPanel center = new JPanel();
          JPanel bot = new JPanel();

       
          jtfSearchBill.setFont(police);
          jtfSearchBill.setPreferredSize(new Dimension(150, 30));;

          GridLayout layoutCenter = new GridLayout(3,4);

          center.setLayout(layoutCenter);

          west.add(searchBill);
          west.add(jtfSearchBill);
          west.add(bSearchBill);
          bot.add(fee);
          
          bSearchBill.addActionListener(new bSearchLocation());


          west.setSize(150,80);
          center.setSize(150,40);
          this.add(top, BorderLayout.NORTH);
          this.add(west, BorderLayout.WEST);
          this.add(east, BorderLayout.EAST);
          this.add(center, BorderLayout.CENTER);
          this.add(bot, BorderLayout.SOUTH);
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.pack();
          this.setLocationRelativeTo(null);
          this.setVisible(true);
      }

          private class bSearchLocation implements ActionListener {
            public void actionPerformed(ActionEvent e) {
              // returns location info needed
              int idFacture = Integer.parseInt(jtfSearchBill.getText());
              FactureDAO facture = new FactureDAO(connection.getConnection());
              Collection<Facture> factures = (Collection<Facture>)facture.find(idFacture);


            }
        }

          
        

  public static void main(String[] args){
    FactureView rv = new FactureView();
  
              }
          }


