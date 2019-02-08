package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.leanpoker.player.game.Bot;
import org.leanpoker.player.game.Card;
import org.leanpoker.player.game.GameState;

import java.util.List;
import java.util.Map;

public class Player {

    static final String VERSION = "Pony 1.0.0";

    public static int betRequest(JsonElement request) {
        Gson gson = new Gson();
        GameState gameState = gson.fromJson(request, GameState.class);
        int current_buy_in = gameState.getCurrent_buy_in();
        Bot our_player = gameState.getPlayerByName("Bright Pony");
        List<Bot> players = gameState.getPlayers();



        int our_bet = current_buy_in - our_player.getBet();

        int ourValue = gameState.getValueOfCombination();

        if (ourValue > 200) our_bet += 10;
        if (ourValue > 300) our_bet += 20;
        if (ourValue > 400) our_bet += 30;
        if (ourValue > 500) our_bet += 40;

        int rankOfFirstCard = our_player.getHole_cards().get(0).getValue();
        if (current_buy_in > 900 && gameState.getCommunity_cards().size() < 4) {
            our_bet = 0;
        }

        if (gameState.getValueOfCombination() < 50 && current_buy_in > 100) {
            our_bet = 0;
        }
        return our_bet;
    }



    public static void showdown(JsonElement game) {
    }
}
