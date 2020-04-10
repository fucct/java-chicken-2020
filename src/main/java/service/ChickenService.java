package service;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.order.Order;
import domain.payment.Payment;
import domain.pos.ChickenPos;
import domain.table.Table;
import domain.command.Command;
import domain.table.TableRepository;
import dto.RequestDto;
import dto.ResponseDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class ChickenService {
    private final Map<Command, Function<RequestDto, ResponseDto>> runner = new HashMap<>();
    private final ChickenPos chickenPos = new ChickenPos();

    public ChickenService() {
        runner.put(Command.REGISTER, this::register);
        runner.put(Command.PAY, this::pay);
        runner.put(Command.EXIT, this::exit);
    }

    public ResponseDto run(final RequestDto request) {
        Command command = Command.of(request.getCommandNumber());
        return runner.get(command).apply(request);
    }

    private ResponseDto register(final RequestDto request) {
        Table table = TableRepository.findTableById(request.getTableNumber());
        Menu menu = MenuRepository.findMenuById(request.getMenuNumber());
        Order order = new Order(menu, request.getMenuCount());
        chickenPos.addOrder(table, order);
        return chickenPos.getResponseDto();
    }


    private ResponseDto pay(final RequestDto request) {
        Table table = TableRepository.findTableById(request.getTableNumber());
        Payment payment = Payment.findPaymentById(request.getPayment());
        return chickenPos.calculateSum(table, payment);
    }

    private ResponseDto exit(final RequestDto request) {
        return new ResponseDto();
    }

    public List<Table> getTables() {
        return chickenPos.getTables();
    }

    public void checkCommand(final int commandNumber) {
        Command.of(commandNumber);
    }
}
