import java.awt.*;

public class Ball {

    //position
    int px;
    int py;

    //movement speed
    double speed;

    //direction
    double dx;
    double dy;
    //radius
    int rad;

    //Middle of the panel
    int xMiddle;
    int yMiddle;

    int timesBounced;
    Ball(int npx,int npy,double ndx,double ndy,int nrad,int nspeed){
        dx = ndx;
        dy = ndy;
        xMiddle = npx;
        yMiddle = npy;
        px = npx;
        py = npy;
        rad = nrad;
        speed = nspeed;
        timesBounced = 0;
    }
    void move(){
        px += (int)(dx*speed*(1+(double)timesBounced/20));
        py += (int)(dy*speed*(1+(double)timesBounced/20));
    }
    void bounceX(){
        dx *= -1;
        timesBounced++;
    }
    void bounceY(){
        dy *= -1;
        timesBounced++;
    }

    void restart(){
        px = xMiddle;
        py = yMiddle;
        dx *= -1;
        dy = (Math.random()-0.5)*2;
        timesBounced = 0;
    }
    void checkY(int height){
        if((py)<=rad && dy<0) {
            bounceY();
            move();
        }
        else if((py)>height && dy>0) {
            bounceY();
            move();
        }
    }
    int checkX(int width){
        //LEFT SIDE - PLAYER SCORES
        if((px)<=rad && dx<0) {
            restart();
            return 1;
        }
        //RIGHT SIDE - BOT SCORES
        else if((px)>width && dx>0) {
            restart();
            return -1;
        }
        return 0;
    }

    //I'm not checking bounceY, it wouldn't change the result.
    boolean checkContact(Block block){
        //check X and Y axis
       if(px > block.px-(block.scale*block.width/2)
       &&px < block.px+rad+(block.scale*block.width/2)
       &&py < block.py+rad+(block.scale*block.height/2)
       && py > block.py-rad-(block.scale*block.height/2)){
           if(px<block.px&&dx>0)//LEFT SIDE
               bounceX();
           else if(px>block.px&&dx<0)//RIGHT SIDE
               bounceX();
           return true;
       }
       return false;
    }
    void draw(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.RED);
        //x,y is the top-left corner of the oval
        g2d.fillOval(px-rad,py-rad,rad,rad);
    }
}
