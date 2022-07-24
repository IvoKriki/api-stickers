import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerGenerator {

    public void createSticker(InputStream inputStream, String imgOutput) throws Exception {

        // get/read img
        //InputStream inputStream = new FileInputStream(new File("imgs/BladeRunner.jpg"));
        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BNzQzMzJhZTEtOWM4NS00MTdhLTg0YjgtMjM4MDRkZjUwZDBlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UX128_CR0,3,128,176_AL_.jpg").openStream();
        BufferedImage originalImg = ImageIO.read(inputStream);

        // create a new img with transparenci and new size

        int width = originalImg.getWidth();
        int height = originalImg.getHeight();
        int newHeight = height + 50;
        BufferedImage newImg = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // copy new img to new img(cache)

        Graphics2D graphics = (Graphics2D) newImg.getGraphics();
        graphics.drawImage(originalImg, 0, 0, null);

        // config font
        var font = new Font(Font.SERIF, Font.BOLD, 20);
        graphics.setColor(Color.BLUE);
        graphics.setFont(font);

        // write something on the img
        graphics.drawString("THE IMG", 0, newHeight - 25);

        // write the img into a file
        ImageIO.write(newImg, "png", new File(imgOutput));
    }
}
