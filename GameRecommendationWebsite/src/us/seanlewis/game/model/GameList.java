package us.seanlewis.game.model;

import java.util.*;

public class GameList {
    List<GameItem> gameList = new ArrayList();
    private int productNumber;

    public GameList() {
        productNumber = 1;
        gameList.add(new GameItem(productNumber++, "Counter Strike Global Offensive", 15.00, true, "action", "First-person action shooter", "images/csgo-banner.jpg"));
        gameList.add(new GameItem(productNumber++, "The Witcher 3: Wild Hunt", 50.00, true, "adventure", "RPG Adventure","images/The-Witcher-3-banner.jpg"));
        gameList.add(new GameItem(productNumber++, "Borderlands 2: Game of the Year", 20.00, true, "adventure", "First-person Adventure","images/bl2-GoTY-banner.jpg"));
        gameList.add(new GameItem(productNumber++, "God of War(PS4 2018)", 60.00, true, "adventure", "Third Person Adventure","images/GoW-banner.jpg"));
        gameList.add(new GameItem(productNumber++, "The Last of Us", 40.00, true, "adventure", "Third Person Adventure","images/Last-Of-Us-banner.jpg"));
    }


    public List<GameItem> getItemCatalog() {
        return gameList;
    }

    public List<GameItem> getFeaturedItemCatalog() {
        List<GameItem> item = new ArrayList<>();

        for(GameItem i: gameList) {
            if (i.isFeatured()) {
                item.add(i);
            }
        }
        return item;
    }
    public GameItem getSingleItem(int itemNum) {
        GameItem item = null;

        for(GameItem i: gameList) {
            if (i.getProductNumber() == itemNum) {
                return i;
            }
        }
        return item;
    }

    public List<GameItem> getItemGenre(String genre) {
        List<GameItem> item = new ArrayList<>();
        for(GameItem i: gameList) {
            if(i.getGenre().equals(genre)){
                item.add(i);
            }
        }
        return item;
    }
    /*
    public List getGames(String genre) {

        if (genre.equals("action")){
            gameList.add("Counter Strike Global Offensive");
            gameList.add("Battlefield 5 (Coming Nov. 20, 2018)");
        }
        else if (genre.equals("adventure")){
            gameList.add("The Witcher 3: Wild Hunt");
            gameList.add("BorderLands 2: Game of the Year");
            gameList.add("God of War(PS4 2018)");
            gameList.add("The Last of Us");
        }
        return gameList;
    }
    */
}
