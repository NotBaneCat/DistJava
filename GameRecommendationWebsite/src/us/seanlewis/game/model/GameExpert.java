package us.seanlewis.game.model;

import java.util.*;

public class GameExpert {

    public List getGames(String genre) {
        List gameList = new ArrayList();

        if (genre.equals("action")){
            gameList.add("Counter Strike Global Offensive");
           /* gameList.add("Battlefield 5 (Coming Nov. 20, 2018)");*/
        }
        else if (genre.equals("adventure")){
            gameList.add("The Witcher 3: Wild Hunt");
            gameList.add("BorderLands 2: Game of the Year");
            gameList.add("God of War(PS4 2018)");
            gameList.add("The Last of Us");
        }
        return gameList;
    }
}
