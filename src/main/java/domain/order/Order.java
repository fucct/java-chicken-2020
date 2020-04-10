package domain.order;

import domain.menu.Menu;

public class Order {

    private final Menu menu;
    private final int count;

    public Order(final Menu menu, final int count) {
        validateCount(count);
        this.menu = menu;
        this.count = count;
    }

    private void validateCount(final int count) {
        if(count<1 || count >99){
            throw new IllegalArgumentException("주문은 1개 이상 99개 이하만 가능합니다.");
        }
    }

    public int calculateRawPrice() {
        return menu.getPrice() * count;
    }
}
