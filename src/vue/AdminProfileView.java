package vue;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ilies Faddaoui
 * @version 1.0
 * This view allows administrator to add a new profile type on the database,
 * with its linked words
 */
public class AdminProfileView extends JFrame {
    private JLabel resume = new JLabel("You can add a new type profile, a new keyword or link a keyword to a type profile here: ");
    private JLabel addNewProfile = new JLabel("Add a new profile: ");
    private JLabel addAKeyWord = new JLabel("Add a keyWord: ");
    private JLabel linkKeyWordToProfile = new JLabel("Link keyword to profile");
    private JLabel emptyPanel = new JLabel(" ");
    private JLabel emptyPanel2 = new JLabel(" ");
    private JButton buttonNewProfile = new JButton("OK");
    private JButton buttonNewKeyword = new JButton("OK");
    private JButton buttonLinkKWProfile = new JButton("OK");
    private JButton buttonBackToHome = new JButton("Home");
    public JTextField jtfAddProfile = new JTextField();
    public JTextField jtfAddKeyWord = new JTextField();
    public JTextField jtfLinkKWProfile = new JTextField();
    public String[] tab = {"Profil 1", "Profil 2", "Profil 3", "Profil 4"};
    public JComboBox comboProfile = new JComboBox(tab);
    Font police = new Font("Arial", Font.BOLD, 14);

    public AdminProfileView(){
        this.setTitle("PhyGit Mall 3.0 : Add profile type ");
        this.setSize(600,600);
        JPanel top = new JPanel();
        JPanel west = new JPanel();
        JPanel center = new JPanel();
        JPanel bot = new JPanel();

        jtfAddProfile.setFont(police);
        jtfAddProfile.setPreferredSize(new Dimension(150, 30));
        jtfAddKeyWord.setFont(police);
        jtfAddKeyWord.setPreferredSize(new Dimension(150, 30));
        jtfAddProfile.setFont(police);
        jtfLinkKWProfile.setPreferredSize(new Dimension(150, 30));
        comboProfile.setFont(police);
        comboProfile.setPreferredSize(new Dimension(150, 30));

        GridLayout layoutCenter = new GridLayout(3,4);

        center.setLayout(layoutCenter);


        top.add(resume);

        center.add(addNewProfile);
        center.add(jtfAddProfile);
        center.add(buttonNewProfile);
        center.add(emptyPanel);

        center.add(addAKeyWord);
        center.add(jtfAddKeyWord);
        center.add(buttonNewKeyword);
        center.add(emptyPanel2);

        center.add(linkKeyWordToProfile);
        center.add(jtfLinkKWProfile);
        center.add(comboProfile);
        center.add(buttonLinkKWProfile);

        bot.add(buttonBackToHome);

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
        AdminProfileView p1 = new AdminProfileView();
    }

}
