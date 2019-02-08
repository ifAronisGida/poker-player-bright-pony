package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.leanpoker.player.game.Bot;
import org.leanpoker.player.game.GameState;

import java.util.List;
import java.util.Map;

public class Player {

    static final String VERSION = "Pony 1.0.0";

    public static int betRequest(JsonElement request) {
        Gson gson = new Gson();
        GameState gameState = gson.fromJson(request, GameState.class);
        int current_buy_in = gameState.getCurrent_buy_in();
        Bot our_player  = gameState.getPlayerByName("Bright Ponies");
        List<Bot> players  = gameState.getPlayers();
        our_bet = current_buy_in - our_player.getBet();
        return our_bet;
    }

    public static void showdown(JsonElement game) {
    }
}
