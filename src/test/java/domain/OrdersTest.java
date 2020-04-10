package domain;

import domain.menu.MenuRepository;
import domain.order.Order;
import domain.order.Orders;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class OrdersTest {
    private static final Order order1 = new Order(MenuRepository.findMenuById(1), 1);
    private static final Order order2 = new Order(MenuRepository.findMenuById(22), 5);
    private static final Orders orders = new Orders();

    static{
        orders.addOrder(order1);
        orders.addOrder(order2);
    }

    @Test
    void create() {
        assertThat(new Orders()).isInstanceOf(Orders.class);
    }

    @Test
    void addOrder() {
        assertThat(orders.getOrders()).contains(order1);
        assertThat(orders.getOrders()).contains(order2);
    }

    @Test
    void calculateRawSum() {
        assertThat(orders.calculateRawSum()).isEqualTo(21000);
    }
}
