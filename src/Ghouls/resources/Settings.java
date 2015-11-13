package Ghouls.resources;

import Ghouls.Ghouls;

/**
 * Created by echo on 11/5/15.
 */
public class Settings {
    static int[] charmIds = null;

    public static int getFoodId() {
        int index = Ghouls.gui.comboBoxFood.getSelectedIndex();
        return (int) foodIDs[index][1];
    }

    public static int getFoodCount() {
        return (int) Ghouls.gui.spinnerFoodCount.getValue();
    }

    public static int getEatPercent() {
        return (int) Ghouls.gui.spinnerEatPercent.getValue();
    }

    public static int[] getCharmsToLoot() {
        if (charmIds == null) {
            int[] charms = new int[4];
            if (Ghouls.gui.radioGold.isSelected())
                charms[0] = (12158);
            if (Ghouls.gui.radioGreen.isSelected())
                charms[1] =(12159);
            if (Ghouls.gui.radioCrimson.isSelected())
                charms[2] =(12160);
            if (Ghouls.gui.radioBlue.isSelected())
                charms[3] =(12163);
            charmIds = charms;
        }

        return charmIds;

    }


    private static Object[][] foodIDs = {{"Shrimps", 315}, {"Anchovies", 319}, {"Sardine", 325}, {"Salmon", 329},
            {"Trout", 333}, {"Cod", 339}, {"Raw herring", 345}, {"Herring", 347}, {"Pike", 351}, {"Mackerel", 355},
            {"Tuna", 361}, {"Bass", 365}, {"Swordfish", 373}, {"Lobster", 379}, {"Shark", 385}, {"Manta ray", 391},
            {"Sea turtle", 397}, {"Pitta bread", 1865}, {"Cooked chicken", 2140}, {"Cooked meat", 2142},
            {"Bread dough", 2307}, {"Bread", 2309}, {"Cooked oomlie wrap", 2343}, {"Cooked chompy", 2878},
            {"Cooked karambwan", 3144}, {"Cooked rabbit", 3228}, {"Cooked slimy eel", 3381}, {"Cooked chicken", 4291},
            {"Cooked meat", 4293}, {"Potato with butter", 6703}, {"Potato with cheese", 6705}, {"Tuna potato", 7060},
            {"Tuna and corn", 7068}, {"Chopped tuna", 7086}, {"Cooked chompy", 7228}, {"Cooked crab meat", 7521},
            {"Cooked jubbly", 7568}, {"Monkfish", 7946}, {"Mint cake", 9475}, {"Leaping trout", 11328},
            {"Leaping salmon", 11330}, {"Crayfish", 13433}, {"Cavefish", 15266}, {"Rocktail", 15272},
    };
}
