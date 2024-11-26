package christmas;

public enum Badge {
    STAR(5000), TREE(10000), SANTA(20000);

    private int minimumPrice;

    Badge(int minimumPrice) {
        this.minimumPrice = minimumPrice;
    }
}
