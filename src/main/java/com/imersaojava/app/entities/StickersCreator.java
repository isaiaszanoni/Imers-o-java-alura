package com.imersaojava.app.entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;


public class StickersCreator {
    public void generateSticker(InputStream inputStream, String nomeArquivo) throws Exception {
        BufferedImage originalImage = ImageIO.read(inputStream);

        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 200;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        String imageSub = "Filme massa!";
        int fontSize =  width / 9;
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
        int textWidth = graphics.getFontMetrics(font).stringWidth(imageSub);
        int textCenter = (width/2) - (textWidth /2);
        graphics.setColor(Color.yellow);
        graphics.setFont(font);

        graphics.drawString(imageSub, textCenter, newHeight - 50);
        System.out.println("center: "+ textCenter + " fontSize: " + fontSize + " font width: " + textWidth + "\n");

        ImageIO.write(newImage, "png", new File("/home/isa/workspace/imersao/imersao-java-alura/src/main/java/com/imersaojava/app/assets/"+nomeArquivo));
    }
}
