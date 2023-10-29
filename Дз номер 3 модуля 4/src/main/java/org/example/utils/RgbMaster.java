package org.example.utils;

import org.example.functions.ImagesOperation;

import java.awt.image.BufferedImage;

public class RgbMaster {

    private BufferedImage image; // Хранит изображение
    private int width; // Ширина изображения
    private int height; // Высота изображения
    private boolean hasAlphaChannel; // Флаг, указывающий на наличие альфа-канала
    private int[] pixels; // Массив пикселей изображения

    public RgbMaster(BufferedImage image) {
        this.image = image;
        width = image.getWidth(); // Получение ширины изображения
        height = image.getHeight(); // Получение высоты изображения
        hasAlphaChannel = image.getAlphaRaster() != null; // Проверка наличия альфа-канала
        pixels = image.getRGB(0, 0, width, height, null, 0, width); // Получение массива пикселей
    }

    public BufferedImage getImage() {
        return image; // Возвращает изображение
    }

    public void changeImage(ImagesOperation operation) throws Exception {
        for (int i = 0; i < pixels.length; i++) {
            float[] pixel = ImageUtils.rgbIntToArray(pixels[i]); // Преобразование цвета пикселя в массив
            float[] newPixel = operation.execute(pixel); // Применение операции к пикселю
            pixels[i] = ImageUtils.arrayToRgbInt(newPixel); // Преобразование массива обратно в цвет пикселя
        }
        image.setRGB(0, 0, width, height, pixels, 0, width); // Установка новых значений цветов пикселей в изображение
    }
}
