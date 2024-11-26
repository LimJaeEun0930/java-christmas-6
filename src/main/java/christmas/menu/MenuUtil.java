package christmas.menu;

import static christmas.Constants.INPUT_MESSAGE_UNVALID_ORDER;

import java.util.Arrays;
import java.util.HashSet;

public class MenuUtil {
    private static HashSet<IFood> foods = new HashSet<>(Arrays.asList(Appetizer.CAESAR_SALAD, Appetizer.TAPAS, Appetizer.MUSHROOM_SOUP
    , Dessert.CHOCOLATE_CAKE, Dessert.ICE_CREAM, Drink.RED_WINE, Drink.CHAMPAGNE, Drink.ZERO_COKE, MainMenu.PORK_LIB, MainMenu.SEAFOOD_PASTA,
            MainMenu.CHRISTMAS_PASTA, MainMenu.TBONE_STEAK));

    public static IFood getFoodByName(String menuName) throws IllegalArgumentException{
        for (IFood food : foods) {
            if (food.getMenuName().equals(menuName)) {
                return food;
            }
        }
        throw new IllegalArgumentException(INPUT_MESSAGE_UNVALID_ORDER);
    }
}
