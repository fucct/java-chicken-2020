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

    public boolean hasOrder() {
        return orders.size() != 0;
    }
}
