package OOP.Project;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Wolf{

    int row, colum;
    int tp;
    int timecount;
    int tcc;
    Mom py;
//class Thread implements ActionListener{
//    Thread tm = new Thread(){
//        public void run(){
//            public void actionPerformed(ActionEvent e) {
//            move();
//            } 
//            while(true){
//                
//                try {
//                   Thread.sleep(10);
//	        }catch(InterruptedException ex){
//                   
//               }
//            }
//        }
//       
//    };
//}
    Timer tm = new Timer(10, (ActionEvent e) -> {
        move();
    });   
    Wolf(int r, int type, Mom p,int c, int tc) {
        this.row = r;
        this.colum=c;
        this.py = p;
        this.tcc = tc;
        
        if (type == 0) {
            this.tp = type;
            Game.map_1[this.row][this.colum] = 2;
        }
        else if (type == 1) {
            this.tp = type;
            Game.map_1[this.row][this.colum] = 2;
        }
        tm.start();
    }
    
    public void draw(Graphics g){
        if(tp == 0){
            try {
                g.drawImage(ImageIO.read(new File("img\\wolf.png")), this.colum*100,this.row*100, 100,100, null,null);
            } catch (IOException ex) {
                Logger.getLogger(Wolf.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void CheckHit1() {
        switch (Game.map_1[this.row][this.colum - 1]) {
            case 1:
                this.py.life -= 1;
                Game.map_1[this.row][this.colum - 1] = 2;
                Game.map_1[this.row][this.colum] = 0;
                this.colum-=1;
                break;
            case 3:
                Game.map_1[this.row][this.colum] = 0;
                Game.map_1[this.row][10] =2;
                this.colum = 10;
                break;
            default:
                Game.map_1[this.row][this.colum - 1] = 2;
                Game.map_1[this.row][this.colum] = 0;
                this.colum-=1;
                break;
        }
    }

    public void CheckHit2() {
        if (Game.map_1[this.row][this.colum + 1] == 1) {
            this.py.life -= 1;
        } else if (Game.map_1[this.row][this.colum + 1] == 3) {
            Game.map_1[this.row][1] = 2;
            Game.map_1[this.row][10] = 0;
            this.row = 1;
        }
    }

    public void move() {
        this.timecount += this.tcc;
        
        if (tp == 0) {
            if (this.timecount >= 10) {
                this.CheckHit1();                    
                this.timecount = 0;
            }
        }
        else if (tp == 1) {
            if (this.timecount >= 10) {
                Game.map_1[this.row][this.colum + 1] = 2;
                Game.map_1[this.row][this.colum] = 0;
                this.colum+= 1;
                this.CheckHit2();
                this.timecount = 0;
            }
        }
    }
}
