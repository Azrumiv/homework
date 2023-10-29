package utils;

import functions.FilterOperations;
import org.telegram.telegrambots.meta.api.objects.File;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class PhotoMessageUtils {

    // Функция для сохранения фотографий
    public static List<String> savePhotos(List<File> files, String botToken) throws IOException {
        Random random = new Random(); // Создаем объект класса Random для генерации случайных чисел
        ArrayList<String> paths = new ArrayList<>(); // Создаем список для хранения путей к сохраненным фотографиям
        for (File file : files) {
            final String imageUrl = "https://api.telegram.org/file/bot" + botToken + "/" + file.getFilePath();
            // Формируем URL-ссылку на фотографию
            final String localFileName = "images/" + new Date().getTime() + random.nextLong() + ".jpeg";
            // Генерируем уникальное имя файла для сохранения
            saveImage(imageUrl, localFileName); // Вызываем функцию сохранения изображения
            paths.add(localFileName); // Добавляем путь к сохраненному изображению в список
        }
        return paths; // Возвращаем список путей к сохраненным фотографиям
    }

    // Функция для сохранения изображения по URL
    public static void saveImage(String url, String fileName) throws IOException {
        URL urlModel = new URL(url); // Создаем объект URL для заданной URL-ссылки
        InputStream inputStream = urlModel.openStream(); // Открываем поток для чтения данных из URL
        OutputStream outputStream = new FileOutputStream(fileName); // Открываем поток для записи данных в файл
        byte[] b = new byte[2048]; // Создаем буфер для чтения данных
        int length;
        while ((length = inputStream.read(b)) != -1) { // Читаем данные из URL и записываем их в файл
            outputStream.write(b, 0, length);
        }
        inputStream.close(); // Закрываем поток для чтения
        outputStream.close(); // Закрываем поток для записи
    }

    // Функция для обработки изображения
    public static void processingImage(String fileName) throws Exception {
        final BufferedImage image = ImageUtils.getImage(fileName); // Загружаем изображение из файла
        final RgbMaster rgbMaster = new RgbMaster(image); // Создаем объект для обработки цветов
        rgbMaster.changeImage(FilterOperations::grayScale); // Применяем фильтр для преобразования в оттенки серого
        ImageUtils.saveImage(rgbMaster.getImage(), fileName); // Сохраняем обработанное изображение
    }
}
