import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener {
    Color color = Color.GREEN;

    Block block;
    int yBorder;
    Player(int x, int y){
        block = new Block(x-50,y/2,10,1,color);
        yBorder = y;
    }

    void tryUp(){
        if(block.py - block.height/2 - block.speed > 0)
            block.moveUp();
    }

    void tryDown(){
        if(block.py + block.height/2 + block.speed < yBorder)
            block.moveDown();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP:
                tryUp();
                break;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN:
                tryDown();
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP:
                tryUp();
                break;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN:
                tryDown();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP:
                tryUp();
                break;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN:
                tryDown();
                break;
        }
    }
}
