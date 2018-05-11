package redevanceDan;


import javax.swing.*;
import java.awt.*;

public class FactureView extends JFrame{

  

      private JLabel addNewFacture = new JLabel("Add a new facture: ");
      private JButton buttonNewFacture = new JButton("OK");
      public JTextField jtfAddNewFacture = new JTextField();
      Font police = new Font("Arial", Font.BOLD, 14);

          public FactureView(){
          this.setTitle("PhyGit Mall 3.0 : Calculate fees  ");
          this.setSize(600,600);
          JPanel top = new JPanel();
          JPanel west = new JPanel();
          JPanel center = new JPanel();
          JPanel bot = new JPanel();

       
          jtfAddNewFacture.setFont(police);
          jtfAddNewFacture.setPreferredSize(new Dimension(150, 30));;

          GridLayout layoutCenter = new GridLayout(3,4);

          center.setLayout(layoutCenter);

          center.add(addNewFacture);



          west.setSize(150,80);
          center.setSize(150,40);
          this.add(top, BorderLayout.NORTH);
          this.add(west, BorderLayout.WEST);
          this.add(center, BorderLayout.CENTER);
          this.add(bot, BorderLayout.SOUTH);
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.pack();
          this.setLocationRelativeTo(null);
          this.setVisible(true);
      }

    

  

  public static void main(String[] args){
    FactureView rv = new FactureView();
  }

}
