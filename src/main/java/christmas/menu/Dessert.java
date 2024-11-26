package christmas.menu;

public enum Dessert implements IFood{
    CHOCOLATE_CAKE("초코케이크", 15000), ICE_CREAM("아이스크림", 5000);

    private String name;
    private int price;

    Dessert(String name, int price) {
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
