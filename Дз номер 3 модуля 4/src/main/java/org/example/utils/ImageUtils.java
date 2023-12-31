package org.example.utils;

import org.example.commands.AppBotCommand;
import org.example.commands.BotCommonCommands;
import org.example.functions.FilterOperations;
import org.example.functions.ImagesOperation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ImageUtils {

    // Получение изображения из файла
    public static BufferedImage getImage(String path) throws IOException {
        final File file = new File(path);
        return ImageIO.read(file);
    }

    // Сохранение изображения в файл
    public static void saveImage(BufferedImage image, String path) throws IOException {
        ImageIO.write(image, "jpg", new File(path));
    }

    // Преобразование цвета пикселя из int в массив float[]
    static float[] rgbIntToArray(int pixel) {
        Color color = new Color(pixel);
        return color.getRGBComponents(null);
    }

    // Преобразование массива float[] в цвет пикселя в int
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
        throw new Exception("Недопустимый цвет");
    }

    // Получение операции для обработки изображений по имени операции
    public static ImagesOperation getOperation(String operationName) {
        FilterOperations filterOperations = new FilterOperations();
        Method[] classMethods = filterOperations.getClass().getDeclaredMethods();
        for (Method method : classMethods) {
            if (method.isAnnotationPresent(AppBotCommand.class)) {
                AppBotCommand command = method.getAnnotation(AppBotCommand.class);
                if (command.name().equals(operationName)) {
                    return (f) -> (float[]) method.invoke(filterOperations, f);
                }
            }
        }
        return null;
    }
}
