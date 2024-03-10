import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        JFrame frame = new JFrame("Pong_game");
        frame.setSize(1000,500);
        PongPanel pongPanel = new PongPanel(frame.getSize());
        //frame.setOpacity(1);
        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(pongPanel);
        //frame.add(pongPanel);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent){
                System.out.println("end");
                pongPanel.game.interrupt();
                executor.shutdown();
            }
        });

        executor.execute(pongPanel.game);
    }
}