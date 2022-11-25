package OOP.Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import static OOP.Project.fl.hard;

public class Home extends JPanel {
    private Game ga;
    private fl f = new fl();
    private ImageIcon b1 = new ImageIcon(fl.ez);
    private ImageIcon b2  = new ImageIcon(fl.med);
    private ImageIcon b3 =  new ImageIcon(fl.hard);
    public JButton Bez = new JButton(b1);;
    public JButton Bmed = new JButton(b2);
    public JButton Bhard = new JButton(b3);
    

    public Home(Game g) {
        setLayout(null);
        
        Bez.setBounds(100, 500, 300, 133);
        Bmed.setBounds(450, 500, 300, 133);
        Bhard.setBounds(800, 500, 300, 133);
        this.ga=g;
        add(Bez);
        add(Bmed);
        add(Bhard);

    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(fl.bg, 0, 0, 1440, 960, null, null);
        g2d.drawImage(fl.sl, 450, 325, 300, 133, null, null);
        g2d.drawImage(fl.ez, 100, 500, 300, 133, Bez);
        g2d.drawImage(fl.med, 450, 500, 300, 133, Bez);
        g2d.drawImage(fl.hard, 800, 500, 300, 133, Bez);
        g2d.drawImage(fl.tt, 100, -120, 1000, 633, null,null);
    }
}

class fl {

    public static Image ez, med, hard, bg, sl, tt;

    public fl() {
        try {
            sl = ImageIO.read(new File("img\\select.png"));
            ez = ImageIO.read(new File("img\\easy.png"));
            med = ImageIO.read(new File("img\\medium.png"));
            hard = ImageIO.read(new File("img\\hard.png"));
            bg = ImageIO.read(new File("img\\bg_main.png"));
            tt = ImageIO.read(new File("img\\title1.png"));       
        } catch (IOException ex) {            
        }
    }
}
