package ru.nsu.g.akononov.Arkanoid.view.util;

import ru.nsu.g.akononov.Arkanoid.view.View;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class ImageLoader {

   public Image ball3;
   public Image ball2;
   public Image ball1;

   public Image brick;
   public Image plank;

   public Image backgroundGame;
   public Image backgroundPause;
   public Image foregroundMenu;

   public ImageLoader()
   {
      try {
         brick = ImageIO.read(View.class.getResourceAsStream("/resources/brick.png"));
         ball3 = ImageIO.read(View.class.getResourceAsStream("/resources/ball_3.png"));
         ball2 = ImageIO.read(View.class.getResourceAsStream("/resources/ball_2.png"));
         ball1 = ImageIO.read(View.class.getResourceAsStream("/resources/ball_1.png"));
         plank = ImageIO.read(View.class.getResourceAsStream("/resources/plank.png"));
         backgroundGame = ImageIO.read(View.class.getResourceAsStream("/resources/background.png"));
         backgroundPause = ImageIO.read(View.class.getResourceAsStream("/resources/pause.png"));
         foregroundMenu = ImageIO.read(View.class.getResourceAsStream("/resources/menu.png"));

      } catch (IOException ex) {
         System.out.println(ex.getMessage());
      }
   }
}
