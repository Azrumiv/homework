package org.example.commands;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AppBotCommand {
    String name(); // Имя команды бота
    String description(); // Описание команды
    boolean showInHelp() default false; // Показывать ли команду в справке (по умолчанию - нет)
    boolean showInKeyboard() default false; // Показывать ли команду на клавиатуре (по умолчанию - нет)
}
