package utils;

import functions.ImagesOperation;

import java.awt.image.BufferedImage;

public class RgbMaster {

    private BufferedImage image; // Переменная для хранения изображения
    private int width; // Ширина изображения
    private int height; // Высота изображения
    private boolean hasAlphaChannel; // Флаг наличия альфа-канала
    private int[] pixels; // Массив пикселей изображения

    public RgbMaster(BufferedImage image) { // Конструктор класса
        this.image = image; // Установка изображения
        width = image.getWidth(); // Получение ширины изображения
        height = image.getHeight(); // Получение высоты изображения
        hasAlphaChannel = image.getAlphaRaster() != null; // Проверка на наличие альфа-канала
        pixels = image.getRGB(0, 0, width, height, null, 0, width); // Получение значений пикселей
    }

    public BufferedImage getImage() { // Метод получения изображения
        return image; // Возвращает изображение
    }

    public void changeImage(ImagesOperation operation) throws Exception { // Метод изменения изображения
        for (int i = 0; i < pixels.length; i++) { // Цикл по всем пикселям изображения
            float[] pixel = ImageUtils.rgbIntToArray(pixels[i]); // Получение значений пикселя
            float[] newPixel = operation.execute(pixel); // Выполнение операции над пикселем
            pixels[i] = ImageUtils.arrayToRgbInt(newPixel); // Установка новых значений пикселя
        }
        image.setRGB(0, 0, width, height, pixels, 0, width); // Установка новых значений пикселей в изображение
    }
}
