/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.karam.telegrambot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.apache.log4j.Logger;



/**
 *
 * @author karam
 */
public class Main {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
          //  telegramBotsApi.registerBot(new SendMeMessage());
            telegramBotsApi.registerBot(new SendMeMessageOmidKarami());

        } catch (Exception e) {
            Logger.getLogger(Main.class).error(e, e);
        }
    }
}
