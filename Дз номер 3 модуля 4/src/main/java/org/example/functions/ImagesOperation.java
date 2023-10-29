package org.example.functions;

import java.lang.reflect.InvocationTargetException;

// Интерфейс для операций над изображениями
public interface ImagesOperation {
    // Метод выполнения операции над RGB значениями пикселя изображения
    float[] execute(float[] rgb) throws InvocationTargetException, IllegalAccessException;
}
