package OOP.Project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener {
    private f2 fk = new f2();
    private int find_colum;
    private int find_row;
    Image wall,bg, konpa, lt, well, mom, wolf_pic, son,life;
    Wolf wolf1;
    Wolf wolf2,wolf3,wolf4,wolf5,wolf6,wolf7,wolf8,wolf9,wolf10;
    Timer loop;
    Mom py;
    JButton back_to_menu = new JButton(new ImageIcon(f2.back_to_menu));
    
    public int speed = 1;
    public static int[][] map_1 = {
        
        {3, 3, 3, 3, 3, 4, 3, 3, 3, 3, 3, 3},
        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
        {3, 6, 5, 0, 5, 5, 5, 6, 0, 6, 5, 3},
        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
        {3, 0, 0, 5, 6, 0, 5, 5, 5, 6, 5, 3},
        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
        {3, 6, 5, 0, 5, 5, 0, 6, 0, 5, 6, 3},
        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
        {3, 0, 0, 5, 5, 6, 5, 5, 5, 6, 0, 3},
        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
        {3, 5, 5, 6, 5, 0, 0, 5, 5, 0, 5, 3},
        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
        {3, 0, 5, 5, 0, 0, 0, 5, 6, 5, 0, 3},
        {3, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 3},
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    public Game() {
        this.get_player();
        try {
            wall = ImageIO.read(new File("img\\area.png"));
            bg = ImageIO.read(new File("img\\bg_main_game.png"));
            lt = ImageIO.read(new File("img\\bush.png"));
            well = ImageIO.read(new File("img\\tree.png"));
            mom = ImageIO.read(new File("img\\mom.png"));
            wolf_pic = ImageIO.read(new File("img\\wolf.png"));
            son = ImageIO.read(new File("img\\son.png"));
            life = ImageIO.read(new File("img\\life.png"));
        } catch (IOException ex) {
            
        }

        py = new Mom(find_row, find_colum);
        wolf1 = new Wolf(9, 0, py, 2, 10);
        wolf2 = new Wolf(10, 0, py, 5, 10);
        wolf3 = new Wolf(5, 0, py, 9, 1);
        wolf4 = new Wolf(3, 0, py, 9, 1);
        wolf5 = new Wolf(11, 0, py, 8, 1);
        wolf6 = new Wolf(3, 0, py, 3, 1);
        wolf7 = new Wolf(7, 0, py, 1, 1);
        wolf8 = new Wolf(7, 0, py, 6, 1);
        wolf9 = new Wolf(1, 0, py, 1, 1);
        wolf10 = new Wolf(1, 0, py, 6, 1);
        loop = new Timer(10, this);
        loop.start();
        addKeyListener(new Key_input(py));
        setFocusable(true);
    }

    public void resetgame(int set_speed) {
        wolf1.tcc = set_speed;
        wolf2.tcc = set_speed;
        wolf3.tcc = set_speed;
        wolf4.tcc = set_speed;
        wolf5.tcc = set_speed;
        wolf6.tcc = set_speed;
        wolf7.tcc = set_speed;
        wolf8.tcc = set_speed;
        wolf9.tcc = set_speed;
        wolf10.tcc = set_speed;
        py.life = 3;
        this.get_player();
        map_1[this.find_row][this.find_colum] = 0;
        py.row = 13;
        py.colum = 5;
        map_1[13][5] = 1;
    }

    public void get_player() {
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 12; j++) {
                if (map_1[i][j] == 1) {
                    this.find_row = i;
                    this.find_colum = j;

                }
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        if (py.life > 0 && this.find_row != 0) {
            g.drawImage(bg, 0, 0, 1200, 800, null, null);
            this.get_player();

            try {
                int x =0;
                for(int i = this.find_row;i>=0;i--){
                    for(int j=0;j<12;j++){
                        if(this.map_1[i][j] == 3){
                            g.drawImage(wall,100*j,600-(x*100),100,100,null,null);
                        }else if(this.map_1[i][j] == 5){
                            g.drawImage(lt,100*j,600-(x*100),100,100,null,null);
                        }else if(this.map_1[i][j] == 6){
                            g.drawImage(well,100*j,600-(x*100),100,100,null,null);
                        }else if(this.map_1[i][j] == 1){
                            g.drawImage(mom,100*j,600-(x*100),100,100,null,null);
                        }else if(this.map_1[i][j] == 2){
                            g.drawImage(wolf_pic,100*j,600-(x*100),100,100,null,null);
                        }else if(this.map_1[i][j] == 4){
                            g.drawImage(son,100*j,600-(x*100),100,100,null,null);
                        }
                            
                    }
                    x+=1;
                }
                
                g.setColor(Color.BLACK);
                g.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
                g.drawImage(life,120,40,200,100,null,null);
                g.drawString("" + py.life, 260, 95);
            } catch (Exception e) {
            }
            
        }
        else if(py.life <= 0){                    //fail
            g.setColor(Color.red);
            g.fillRect(425,400,300,100);
            this.back_to_menu.setBounds(425,400,300,100);
            add(back_to_menu);
            try {
                g.drawImage(ImageIO.read(new File("img\\bg_gameover.png")),0,0,1500,860,null,null);
                g.drawImage(ImageIO.read(new File("img\\backtomenu.png")),425,400,300,100,back_to_menu);
            } catch (IOException ex) {
                
            }
        }else if (py.colum == 5 && py.row == 0){   //success
            g.setColor(Color.blue);
            g.fillRect(425,400,300,100);
            this.back_to_menu.setBounds(425,400,300,100);
            add(back_to_menu);
            try {
                g.drawImage(ImageIO.read(new File("img\\bg_success.png")),0,0,1500,860,null,null);
                g.drawImage(ImageIO.read(new File("img\\backtomenu.png")),425,400,300,100,back_to_menu);
            } catch (IOException ex) {
                
            }
        }
        
    }
class f2 {

    public static Image back_to_menu;

    public f2() {
        try {
            back_to_menu = ImageIO.read(new File("img\\backtomenu.png"));
            
            
        } catch (IOException ex) {
            
        }
    }
}
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}

class Key_input extends KeyAdapter {

    Mom p;

    Key_input(Mom p) {
        this.p = p;
    }

    @Override
    public void keyPressed(KeyEvent e) { 
        if (e.getKeyCode() == KeyEvent.VK_A) {
            p.move(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            p.move(1);
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            p.move(3);
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            p.move(2);
        }
    }

    
    
}




