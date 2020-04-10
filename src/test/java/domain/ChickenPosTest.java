package domain;

import domain.menu.MenuRepository;
import domain.order.Order;
import domain.order.Orders;
import domain.pos.ChickenPos;
import domain.table.Table;
import domain.table.TableRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChickenPosTest {
    private static final Order order1;
    private static final Order order2;
    private static final int order1Price = 80000;
    private static final int order2Price = 5000;

    static {
        order1 = new Order(MenuRepository.findMenuById(1), 5);
        order2 = new Order(MenuRepository.findMenuById(5), 5);
    }

    @Test
    void create() {
        assertThat(new ChickenPos()).isInstanceOf(ChickenPos.class);
    }

    @Test
    void addOrderOnTable() {
        ChickenPos chickenPos = new ChickenPos();
        Table table = TableRepository.findTableById(1);
        chickenPos.addOrder(TableRepository.findTableById(1), order1);
        assertThat(chickenPos.findOrdersByTable(table).calculateRawSum()).isEqualTo(order1Price);
    }
}
