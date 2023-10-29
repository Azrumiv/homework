package org.example.commands;

public class BotCommonCommands {
    // Функция "hello" для команды "/hello" - возвращает строку "Шалом"
    @AppBotCommand(name = "/hello", description = "when request hello", showInHelp = true)
    String hello(){
        return "Шалом";
    }

    // Функция "bye" для команды "/bye" - возвращает строку "Сайонара"
    @AppBotCommand(name = "/bye", description = "when request bye", showInHelp = true)
    String bye(){
        return "Сайонара";
    }

    // Функция "help" для команды "/help" - возвращает строку "Помоги себе сам."
    @AppBotCommand(name = "/help", description = "when request help", showInKeyboard = true)
    String help(){
        return "Помоги себе сам.";
    }
}
