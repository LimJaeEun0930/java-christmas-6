package christmas.menu;

public enum Appetizer implements IFood {
    MUSHROOM_SOUP("양송이수프", 6000), TAPAS("타파스", 5500), CAESAR_SALAD("시저샐러드", 8000);

    private String name;
    private int price;

    Appetizer(String name, int price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String getMenuName() {
        return getName();
    }

    @Override
    public int getMenuPrice() {
        return getPrice();
    }
}
