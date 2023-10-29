package org.example.functions;

import org.example.commands.AppBotCommand;

public class FilterOperations {
    // Преобразование цвета изображения в оттенки серого
    @AppBotCommand(name = "grayScale", description = "greyScale filter", showInKeyboard = true)
    public static float[] grayScale(float[] rgb) {
        final float mean = (rgb[0] + rgb[1] + rgb[2]) / 3; // Вычисление среднего значения RGB для оттенка серого
        rgb[0] = mean;
        rgb[1] = mean;
        rgb[2] = mean;
        return rgb; // Возврат преобразованных значений RGB
    }

    // Оставление только красного цвета в изображении
    @AppBotCommand(name = "onlyRed", description = "onlyRed filter", showInKeyboard = true)
    public static float[] onlyRed(float[] rgb) {
        rgb[1] = 0; // Установка зеленой составляющей в 0
        rgb[2] = 0; // Установка синей составляющей в 0
        return rgb; // Возврат преобразованных значений RGB
    }

    // Оставление только зеленого цвета в изображении
    @AppBotCommand(name = "onlyGreen", description = "onlyGreen filter", showInKeyboard = true)
    public static float[] onlyGreen(float[] rgb) {
        rgb[0] = 0; // Установка красной составляющей в 0
        rgb[2] = 0; // Установка синей составляющей в 0
        return rgb; // Возврат преобразованных значений RGB
    }

    // Оставление только синего цвета в изображении
    @AppBotCommand(name = "onlyBlue", description = "onlyBlue filter", showInKeyboard = true)
    public static float[] onlyBlue(float[] rgb) {
        rgb[0] = 0; // Установка красной составляющей в 0
        rgb[1] = 0; // Установка зеленой составляющей в 0
        return rgb; // Возврат преобразованных значений RGB
    }

    // Оставление только фиолетового (зеленого) цвета в изображении
    @AppBotCommand(name = "onlyPurple", description = "onlyPurple filter", showInKeyboard = true)
    public static float[] onlyPurple(float[] rgb) {
        rgb[0] = 0f; // Установка красной составляющей в 0
        rgb[1] = 0.5f; // Установка зеленой составляющей в 0.5 (фиолетовый цвет)
        return rgb; // Возврат преобразованных значений RGB
    }
}
