package ImagesToChar;

import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.*;

public class ImagesToChar {
    public ImagesToChar() {}

    public void displayResult(String pathToImg) {
        try {
            File f = new File(pathToImg);
            BufferedImage br = ImageIO.read(f);
            Color color;
            for (int i = 0; i < br.getWidth(); i++) {
                for (int j = 0; j < br.getHeight(); j++) {
                    color = new Color(br.getRGB(j, i));
                    if (color.getBlue() == 255 &&
                    color.getRed() == 255 &&
                    color.getGreen() == 255)
                        System.out.print(".");
                    else
                        System.out.print("0");
                }
                System.out.print("\n");
            }
        } catch (Exception e) {
            System.err.println("Error");
        }
    }
}
