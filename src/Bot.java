import java.awt.*;

public class Bot {
    Block block;
    Color color = Color.blue;
    int yBorder;
    Bot(int x, int y){
        block = new Block(50,y/2,10,1,color);
        yBorder = y;
    }
    void makeMove(int yPos) {
        //(block.py + block.height/2 < yBorder && block.py - block.height/2 >0)
        if (yPos > block.py + block.height / 4 && block.py + block.height/2 < yBorder)
            block.moveDown();
        else if (yPos < block.py - block.height / 4 && block.py - block.height/2 > 0)
            block.moveUp();
    }
}
