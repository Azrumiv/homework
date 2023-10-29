package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        // Инициализация объекта TelegramBotsApi для работы с ботами Telegram
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);

        // Регистрация нового бота в Telegram и создание сессии для бота
        BotSession botSession = api.registerBot(new Bot());
    }
}
