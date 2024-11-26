package christmas.menu;

public enum Drink {
    ZERO_COKE("제로콜라", 3000), RED_WINE("레드와인", 60000), CHAMPAGNE("샴페인", 25000);
    private String name;
    private int price;

    Drink(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
