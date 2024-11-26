package christmas.menu;

public enum MainMenu {
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
}
//티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)
//
//<디저트>
//초코케이크(15,000), 아이스크림(5,000)
//
//<음료>
//제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)