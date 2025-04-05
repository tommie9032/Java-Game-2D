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

    KeyHandler keyH = new KeyHandler();

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }


    public void startGameThread(){
        gameThread = new Thread(this);// Passing GamePanel Class here
        gameThread.start();
    }
    @Override
    public void run() {
        while(gameThread != null){

            update();
            repaint();
        }

    }
    public void update(){
        if(keyH.upPressed == true){
            playerY-=playerSpeed;
        }
        else if(keyH.downPressed == true){
            playerY+=playerSpeed;
        }
        else if(keyH.leftPressed == true){
            playerX-=playerSpeed;
        }
        else if(keyH.rightPressed == true){
            playerX+=playerSpeed;
        }

    }

    //paintComponent is an exisiting Method in Java , With graphics as standard class
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(playerX,playerY,tileSize,tileSize);
        g2.dispose();

    }


}
