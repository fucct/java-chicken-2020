package domain.order;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    List<Order> orders = new ArrayList<>();

    public void addOrder(final Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public int calculateRawSum() {
        return orders.stream()
                .mapToInt(Order::calculateRawPrice)
                .sum();
    }

    public int calculateConditionalSum() {
        int chickenUnit = calculateChickenCount() / 10;
        return calculateRawSum() - chickenUnit * 10000;
    }

    public int calculateChickenCount() {
        return orders.stream().filter(Order::isChickenType)
                .mapToInt(Order::getCount)
                .sum();
    }

    public boolean hasOrder() {
        return orders.size() != 0;
    }
}
