package service;

import domain.Table;
import domain.command.Command;
import dto.RequestDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ChickenService {
    private final Map<Command, Consumer<RequestDto>> runner = new HashMap<>();
    private final ChickenPOS chickenPOS = new ChickenPOS();

    public ChickenService() {
        runner.put(Command.REGISTER, this::register);
        runner.put(Command.PAY, this::pay);
        runner.put(Command.EXIT, this::exit);

    }

    public void run(final RequestDto request) {
        Command command = Command.of(request.getCommandNumber());
        runner.get(command).accept(request);
    }

    private void register(final RequestDto request) {
        chickenPOS.register(request.getTableNumber(), request.getMenuNumber(), request.getMenuCount());
    }


    private void pay(final RequestDto request) {

    }

    private void exit(final RequestDto request) {

    }

    public List<Table> getTables() {
        return null;
    }
}
