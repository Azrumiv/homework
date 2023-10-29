// Подключение необходимых библиотек и классов
import functions.FilterOperations;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.lang.reflect.Method;
import java.util.*;
import java.net.*;
import java.io.*;
import utils.PhotoMessageUtils;
import utils.RgbMaster;
import java.awt.image.BufferedImage;

// Создание основного класса "Bot", наследующего TelegramLongPollingBot
public class Bot extends TelegramLongPollingBot {

    // Метод возвращающий имя бота
    @Override
    public String getBotUsername() {
        return "NuclerKabachok666";
    }

    // Метод возвращающий токен бота
    @Override
    public String getBotToken() {
        return "Найне Найне Не Будет";
    }

    // Метод обработки входящих сообщений
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage(); // Получение сообщения
        String chatId = message.getChatId().toString(); // Получение идентификатора чата

        try {
            // Получение и обработка фотографий из сообщения
            ArrayList<String> photoPaths = new ArrayList<>(PhotoMessageUtils.savePhotos(getFilesByMessage(message), getBotToken()));
            for (String path : photoPaths) {
                PhotoMessageUtils.processingImage(path); // Обработка изображения
                execute(preparePhotoMessage(path, chatId)); // Отправка обработанной фотографии
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Подготовка сообщения с фотографией для отправки
    private SendPhoto preparePhotoMessage(String localPath, String chatId) {
        SendPhoto sendPhoto = new SendPhoto(); // Создание объекта SendPhoto
        sendPhoto.setReplyMarkup(getKeyboard(FilterOperations.class)); // Установка клавиатуры для ответа
        sendPhoto.setChatId(chatId); // Установка идентификатора чата
        InputFile newFile = new InputFile();
        newFile.setMedia(new File(localPath));
        sendPhoto.setPhoto(newFile); // Установка фотографии для отправки
        return sendPhoto;
    }

    // Получение клавиатуры для ответа
    private ReplyKeyboardMarkup getKeyboard(Class someClass) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        ArrayList<KeyboardRow> keyboardRows = new ArrayList<>();
        Method[] methods = someClass.getMethods();
        int columnCount = 3;
        int rowsCount = methods.length / columnCount + ((methods.length % columnCount == 0) ? 0 : 1);
        for (int rowIndex = 0; rowIndex < rowsCount; rowIndex++) {
            KeyboardRow row = new KeyboardRow();
            for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                int index = rowIndex * columnCount + columnIndex;
                if (index >= methods.length) continue;
                Method method = methods[rowIndex * columnCount + columnIndex];
                KeyboardButton keyboardButton = new KeyboardButton(method.getName());
                row.add(keyboardButton);
            }
            keyboardRows.add(row);
        }
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        return replyKeyboardMarkup;
    }

    // Получение файлов из сообщения
    private List<org.telegram.telegrambots.meta.api.objects.File> getFilesByMessage(Message message) {
        List<PhotoSize> photoSizes = message.getPhoto();
        ArrayList<org.telegram.telegrambots.meta.api.objects.File> files = new ArrayList<>();
        for (PhotoSize photoSize : photoSizes) {
            final String fileId = photoSize.getFileId();
            try {
                files.add(sendApiMethod(new GetFile(fileId)));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        return files;
    }
}
