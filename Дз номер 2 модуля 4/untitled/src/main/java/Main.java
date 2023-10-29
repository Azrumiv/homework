import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.meta.generics.TelegramBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        // Создаем экземпляр TelegramBotsApi для управления ботами
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);

        // Регистрируем нашего бота для запуска
        BotSession bot = api.registerBot(new Bot());
    }
}
