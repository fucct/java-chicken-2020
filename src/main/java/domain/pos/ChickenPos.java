package domain.pos;

import domain.order.Order;
import domain.order.Orders;
import domain.table.Table;
import domain.table.TableRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChickenPos {
    private final Map<Table, Orders> pos;

    public ChickenPos() {
        this.pos = Collections.unmodifiableMap(
                TableRepository.tables()
                        .stream()
                        .collect(Collectors.toMap(
                                table -> table,
                                table -> new Orders())
                        )
        );
    }


    public void addOrder(final Table table, final Order order) {
        Orders orders = findOrdersByTable(table);
        orders.addOrder(order);
    }

    public Orders findOrdersByTable(Table table) {
        return pos.get(table);
    }

    public List<Table> getTables() {
        return new ArrayList<>(pos.keySet());
    }

    public boolean isOrderedTable(Table table){
        return pos.get(table).hasOrder();
    }
}
