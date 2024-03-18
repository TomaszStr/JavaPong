import javax.swing.*;

import java.awt.*;

public class PongPanel extends JPanel {

    Ball ball;

    Bot bot;

    Player player;

    Game game;

    int xBorder;
    int yBorder;
    Rectangle border;
    int playerPoints;
    int botPoints;


    PongPanel(Dimension dimension){

        xBorder = (int) (dimension.width*0.95);
        yBorder = (int) (dimension.height*0.90);
        border = new Rectangle(0,1,xBorder,yBorder);
        ball = new Ball(xBorder/2,yBorder/2,1,(Math.random()-0.5)*2,20,8);//(Math.random()-0.5)*2
        game = new Game();
        bot = new Bot(xBorder,yBorder);
        player = new Player(xBorder,yBorder);
        this.setFocusable(true);
        this.addKeyListener(player);

    }

    public void paintComponent(Graphics g) {
        setOpaque(false);
        ball.draw(g);
        bot.block.draw(g);
        player.block.draw(g);
        displayScore(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.draw(border);
        g2d.drawString("PRESS 'P' TO PAUSE",xBorder/2,20);
        if(player.pause){
            g2d.drawString("PAUSE",xBorder/2,yBorder/2);
        }
    }

    void displayScore(Graphics g){
        g.drawString("SCORE:",30,30);
        g.drawString("PLAYER:"+playerPoints,30,40);
        g.drawString("BOT:   "+botPoints,30,50);
        g.drawString("BOUNCED: "+ball.timesBounced,30,60);
    }
    void checkScore(int s){
        if(s == 1)
            playerPoints++;
        else if(s == -1)
            botPoints++;
    }
    public class Game extends Thread{
        @Override
        public void run() {
            for(int i = 0; !this.isInterrupted() ; i++){

                repaint();

                if(player.pause)
                    try {
                        sleep(1000);
                    } catch (Exception e){e.printStackTrace();}
                else {
                    ball.move();
                    ball.checkContact(player.block);
                    ball.checkContact(bot.block);
                    ball.checkY(yBorder);
                    //possible change of score
                    checkScore(ball.checkX(xBorder));

                    bot.makeMove(ball.py);

                    try {
                        sleep(1000 / 40);
                    } catch (InterruptedException e) {
                        this.interrupt();
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
