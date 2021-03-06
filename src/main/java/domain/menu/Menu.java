package domain.menu;

import domain.category.Category;

public class Menu {
    private final int number;
    private final String name;
    private final Category category;
    private final int price;

    public Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public boolean isSameId(int number) {
        return this.number == number;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }


    public int getPrice() {
        return price;
    }

    public boolean isChickenType() {
        return category.equals(Category.CHICKEN);
    }
}
