package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //Screen Settings
    final int originalTileSize = 16;
    final int scale = 3;
    //16*16 is too small for our monitors so scaling is required

    final int tileSize = originalTileSize * scale; //Single 48 pixel tile

    //Screen Size

    final int maxScreenCol = 16;
    final int maxScreenRow = 12;

    final int screenWidth = tileSize * maxScreenCol; //768 pixels
    final int screenHeight = tileSize * maxScreenRow;//576 pixels
    //Creating a Clock to keep Game Updating
    Thread gameThread;


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }


    public void startGameThread(){
        gameThread = new Thread(this);// Passing GamePanel Class here
        gameThread.start();
    }
    @Override
    public void run() {
        while(gameThread != null){

            System.out.println("Game is on!!");
        }

    }
}
