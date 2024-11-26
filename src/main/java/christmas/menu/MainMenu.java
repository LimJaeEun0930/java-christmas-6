package christmas.menu;

public enum MainMenu implements IFood{
    TBONE_STEAK("티본스테이스", 55000), PORK_LIB("바비류립", 54000), SEAFOOD_PASTA("해산물파스타", 35000), CHRISTMAS_PASTA("크리스마스파스타",
            25000),;

    private String name;
    private int price;

    MainMenu(String name, int price) {
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
