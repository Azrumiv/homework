package org.example.utils;

import org.example.functions.FilterOperations;
import org.example.functions.ImagesOperation;
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
    // Функция сохранения фотографий из Telegram
    public static List<String> savePhotos(List<File> files, String botToken) throws IOException {
        Random random = new Random();
        ArrayList<String> paths = new ArrayList<>();
        for (File file : files) {
            // Получение URL изображения и создание локального файла с уникальным именем
            final String imageUrl = "https://api.telegram.org/file/bot" + botToken + "/" + file.getFilePath();
            final String localFileName = "images/" + new Date().getTime() + random.nextLong() + ".jpeg";
            saveImage(imageUrl, localFileName); // Сохранение изображения
            paths.add(localFileName); // Добавление пути сохраненного файла в список
        }
        return paths; // Возврат списка путей сохраненных файлов
    }

    // Функция сохранения изображения из URL в локальный файл
    public static void saveImage(String url, String fileName) throws IOException {
        URL urlModel = new URL(url);
        InputStream inputStream = urlModel.openStream();
        OutputStream outputStream = new FileOutputStream(fileName);
        byte[] b = new byte[2048];
        int length;
        while ((length = inputStream.read(b)) != -1) {
            outputStream.write(b, 0, length);
        }
        inputStream.close();
        outputStream.close();
    }

    // Функция обработки изображения
    public static void processingImage(String fileName, ImagesOperation operation) throws Exception {
        // Получение изображения, применение операции и сохранение измененного изображения
        final BufferedImage image = ImageUtils.getImage(fileName);
        final RgbMaster rgbMaster = new RgbMaster(image);
        rgbMaster.changeImage(operation);
        ImageUtils.saveImage(rgbMaster.getImage(), fileName);
    }
}
