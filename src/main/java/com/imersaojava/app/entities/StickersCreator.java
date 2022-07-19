package com.imersaojava.app.entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class StickersCreator {


    public void generateSticker() throws Exception {
        // leitura da imagem
        BufferedImage originalImage = ImageIO.read(new File("/home/isa/workspace/imersao/imersao-java-alura/src/main/java/com/imersaojava/app/assets/filme.jpg"));

        // cria uma nova imagem em memoria mudando transparencia e tamanho
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 200;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // copia imagem original para nova imagem (em memoria)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        // configuracao de fonte
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.yellow);
        graphics.setFont(font);

        // gravar uma frase na nova imagem
        String imageSub = "Filme massa!";
        graphics.drawString(imageSub, 90, newHeight - 100);

        // escrever a nova imagem em um arquivo
        ImageIO.write(newImage, "png", new File("/home/isa/workspace/imersao/imersao-java-alura/src/main/java/com/imersaojava/app/assets/figurinha.png"));


    }

    public static void main(String[] args) throws Exception {
        StickersCreator creator = new StickersCreator();
        creator.generateSticker();
    }

    // copia imagem original para nova imagem (em memoria)

    // escrever uma frase na imagem nova






}
