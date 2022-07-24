import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

public class StickerGenerator {

    public void createSticker() throws Exception {

        // get/read img
        BufferedImage originalImg = ImageIO.read(new File("imgs/BladeRunner.jpg"));

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
        graphics.drawString("BladeRunner", 0, newHeight - 25);

        // write the img into a file
        ImageIO.write(newImg, "png", new File("imgOutput/outBladeRunner.png"));
    }

    public static void main(String[] args) throws Exception {
        var generates = new StickerGenerator();
        generates.createSticker();
    }
}
