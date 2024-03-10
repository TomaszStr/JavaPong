import java.awt.*;

public class Block {

    //position
    int px;
    int py;

    int height=100;
    int width=25;
    //movement speed
    int speed;
    //scale
    double scale;


    Color color;

    Block(int x,int y, int speed,double scale,Color color){
        this.px = x;
        this.py = y;
        this.speed = speed;
        this.scale = scale;
        this.color = color;
    }

    void moveUp(){
        py = py - speed;
    }
    void moveDown(){
        py = py + speed;
    }
    void draw(Graphics g){
        g.setColor(color);
        g.fillRect((int) (px-(width*scale)/2), (int) (py-(height*scale/2)),
                (int)(width*scale),(int)(height*scale));

    }
}
