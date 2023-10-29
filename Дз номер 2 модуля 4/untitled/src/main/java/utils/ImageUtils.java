package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// Класс ImageUtils для работы с изображениями

public class ImageUtils {

    // Получает изображение из указанного пути
    public static BufferedImage getImage(String path) throws IOException {
        final File file = new File(path);
        return ImageIO.read(file);
    }

    // Сохраняет изображение по указанному пути
    public static void saveImage(BufferedImage image, String path) throws IOException {
        ImageIO.write(image, "png", new File(path));
    }

    // Преобразует целочисленное представление цвета в массив RGB
    static float[] rgbIntToArray(int pixel) {
        Color color = new Color(pixel);
        return color.getRGBComponents(null);
    }

    // Преобразует массив значений RGB обратно в целочисленное представление цвета
    static int arrayToRgbInt(float[] pixel) throws Exception {
        Color color = null;
        if (pixel.length == 3) {
            color = new Color(pixel[0], pixel[1], pixel[2]);
        } else if (pixel.length == 4) {
            color = new Color(pixel[0], pixel[1], pixel[2], pixel[3]);
        }
        if (color != null) {
            return color.getRGB();
        }
        throw  new Exception("недопустимый цвет");
    }
}
