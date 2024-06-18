import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class Bot  extends TelegramLongPollingBot {
    private String userName;
    private int count = 0;
    private int percent = 0;

    public InlineKeyboardButton a1 = InlineKeyboardButton.builder()
            .text("ДА")
            .callbackData("ДА")
            .build();
    public InlineKeyboardButton a3 = InlineKeyboardButton.builder()
            .text("НЕТ")
            .callbackData("НЕТ")
            .build();



    private InlineKeyboardMarkup keyboardA = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(a1))
            .keyboardRow(List.of(a3))

            .build();


    public InlineKeyboardButton b1 = InlineKeyboardButton.builder()
            .text("Да")
            .callbackData("Да")
            .build();
    public InlineKeyboardButton b3 = InlineKeyboardButton.builder()
            .text("Нет")
            .callbackData("Нет")
            .build();
    public InlineKeyboardButton b2 = InlineKeyboardButton.builder()
            .text("Не знаю")
            .callbackData("Не знаю")
            .build();
    private InlineKeyboardMarkup keyboardB = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(b1))
            .keyboardRow(List.of(b3))
            .keyboardRow(List.of(b2))
            .build();


    public InlineKeyboardButton v = InlineKeyboardButton.builder()
            .text("Один из принципов OOP")
            .callbackData("Один из принципов OOP")
            .build();
    public InlineKeyboardButton v2 = InlineKeyboardButton.builder()
            .text("Зависимость")
            .callbackData("Зависимость")
            .build();
    public InlineKeyboardButton v3 = InlineKeyboardButton.builder()
            .text("Библиотека")
            .callbackData("Библиотека")
            .build();


    private InlineKeyboardMarkup keyboardV = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(v2))
            .keyboardRow(List.of(v3))
            .keyboardRow(List.of(v))
            .build();
    public InlineKeyboardButton p = InlineKeyboardButton.builder()
            .text("ДA")
            .callbackData("ДA")
            .build();
    public InlineKeyboardButton p2 = InlineKeyboardButton.builder()
            .text("НЕТ")
            .callbackData("НЕТ")
            .build();


    private InlineKeyboardMarkup getKeyboardP = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(p))
            .keyboardRow(List.of(p2))

            .build();


    public InlineKeyboardButton s = InlineKeyboardButton.builder()
            .text("boolean")
            .callbackData("boolean")
            .build();
    public InlineKeyboardButton s2 = InlineKeyboardButton.builder()
            .text("int")
            .callbackData("int")
            .build();
    public InlineKeyboardButton s3 = InlineKeyboardButton.builder()
            .text("double")
            .callbackData("double")
            .build();

    private InlineKeyboardMarkup keyboardS = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(s2))
            .keyboardRow(List.of(s3))
            .keyboardRow(List.of(s))
            .build();


    public InlineKeyboardButton f = InlineKeyboardButton.builder()
            .text("@Override")
            .callbackData("@Override")
            .build();
    public InlineKeyboardButton f2 = InlineKeyboardButton.builder()
            .text("@Id")
            .callbackData("@Id")
            .build();
    public InlineKeyboardButton f3 = InlineKeyboardButton.builder()
            .text("@Opred")
            .callbackData("@Opred")
            .build();

    private InlineKeyboardMarkup keyboardF = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(f2))
            .keyboardRow(List.of(f3))
            .keyboardRow(List.of(f))
            .build();

    @Override
    public String getBotUsername() {
        return "@glee_ebb_bot";
    }

    @Override
    public String getBotToken() {
        return "7394173770:AAFMDTRZhE8kjvyICKKvhoFsXrgUfDfbfak";
    }

    @Override
    public void onUpdateReceived(Update update) {
        gg(update);
    }


    public void gg(Update update) {

        if (update.hasCallbackQuery()) {

            String idUser = update.getCallbackQuery().getMessage().getChatId().toString();
            int idMessage = update.getCallbackQuery().getMessage().getMessageId();
            String data = update.getCallbackQuery().getData();
            String queryId = update.getCallbackQuery().getId();

            EditMessageText editMessageText = EditMessageText.builder()
                    .chatId(idUser)
                    .messageId(idMessage)
                    .text("")
                    .build();

            EditMessageReplyMarkup editMessageReplyMarkup = EditMessageReplyMarkup.builder()
                    .chatId(idUser.toString())
                    .messageId(idMessage)
                    .build();


            if (data.equals("НЕТ") && count == 1) {
                editMessageText.setText("Может ли Абстрактный класс наследовать интерфейс?");
                editMessageReplyMarkup.setReplyMarkup(keyboardB);
                count++;
                percent = percent + 17;
            } else if (data.equals("ДА") && count == 1) {
                editMessageText.setText("Может ли Абстрактный класс наследовать интерфейс?");
                editMessageReplyMarkup.setReplyMarkup(keyboardB);
                count++;
            }
            if (data.equals("Да") && count == 2) {
                editMessageText.setText("Инкапсуляция это?");
                editMessageReplyMarkup.setReplyMarkup(keyboardV);
                count++;
                percent = percent + 17;
            } else if (data.equals("Нет") && count == 2 || data.equals("Не знаю") && count == 2) {
                editMessageText.setText("Инкапсуляция это?");
                editMessageReplyMarkup.setReplyMarkup(keyboardV);
                count++;
            }
            if (data.equals("Один из принцепов OOP") && count == 3) {
                editMessageText.setText("Можно ли создать статический метод?");
                editMessageReplyMarkup.setReplyMarkup(getKeyboardP);
                count++;
                percent = percent + 17;
            } else if (data.equals("Зависимость") && count == 3 || data.equals("Библиотека") && count == 3) {
                editMessageText.setText("Можно ли создать статический метод?");
                editMessageReplyMarkup.setReplyMarkup(getKeyboardP);
                count++;
            }
            if (data.equals("ДA") && count == 4) {
                editMessageText.setText("Вкакой тип данных можно записать выражение x > 0 ?");
                editMessageReplyMarkup.setReplyMarkup(keyboardS);
                count++;
                percent = percent + 17;


            } else if (data.equals("НЕТ") && count == 4) {
                editMessageText.setText("Вкакой тип данных можно записать выражение x > 0 ?");
                editMessageReplyMarkup.setReplyMarkup(keyboardS);
                count++;

            }
            if (data.equals("boolean") && count == 5) {
                editMessageText.setText("Какой анатацией обозначаеться переопределение методов?");
                editMessageReplyMarkup.setReplyMarkup(keyboardF);
                count++;
                percent = percent + 17;

            } else if (data.equals("int") && count == 5 || data.equals("double") && count == 5) {
                editMessageText.setText("Какой анатацией обозначаеться переопределение методов?");
                editMessageReplyMarkup.setReplyMarkup(keyboardF);
                count++;
            }
            if (data.equals("@Override") && count == 6) {
                count++;
                percent = percent + 17;
                editMessageText.setText(getPercent());


            } else if (data.equals("@Id") && count == 6 || data.equals("@Opred") && count == 6) {
                count++;
                editMessageText.setText(getPercent());


            }

            AnswerCallbackQuery answerCallbackQuery = AnswerCallbackQuery.builder()
                    .callbackQueryId(queryId)
                    .build();
            try {
                execute(answerCallbackQuery);
                execute(editMessageText);
                execute(editMessageReplyMarkup);
            } catch (Exception ex) {
                ex.getMessage();
            }


        } else if (update.hasMessage() && update.getMessage().getText().equals("/da")) {
            userName = update.getMessage().getFrom().getFirstName();
            count = 0;
            percent = 0;
            sendMenu(update.getMessage().getFrom().getId(), "<b>Существует ли библиотека HappyNumbers?</b>", keyboardA);
            count++;
        }

        System.out.println(count + " " + (percent - 2) + "%");
    }

    private String getPercent() {

        String response = userName + ", Вы прошли тест и правильно выполнили " + (percent - 2) + "% заданий!";
        if (percent >= 70) {
            System.out.println("Пользователь \"" + userName + "\" прошёл тест на " + (percent - 2) + "%.");
            return response + ".\nТеперь Вы можете связаться с заказчиком\nпо его нику в телеграмме -@slipnessuu";
        }
        System.out.println("Пользователь \"" + userName + "\" прошёл тест на " + (percent - 2) + "%.");
        return response;
    }

    public void sendMenu(Long who, String txt, InlineKeyboardMarkup km) {
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString())
                .parseMode("HTML")
                .text(txt)
                .replyMarkup(km)
                .build();

        try {
            execute(sm);
        } catch (TelegramApiException tae) {
            throw new RuntimeException(tae);
        }
    }
}












