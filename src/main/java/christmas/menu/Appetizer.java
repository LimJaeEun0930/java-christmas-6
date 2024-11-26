package christmas.menu;

public enum Appetizer {
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
}
//양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)