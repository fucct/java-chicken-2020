package service;

import domain.command.Command;
import dto.RequestDto;
import dto.ResponseDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ChickenService {
    private final Map<Command, Consumer<List<String>>> runner = new HashMap<>();

    public ChickenService() {
        runner.put(Command.REGISTER, this::register);
        runner.put(Command.PAY, this::pay);
        runner.put(Command.EXIT, this::exit);

    }

    private void register(final List<String> strings) {

    }

    private void pay(final List<String> strings) {

    }

    private void exit(final List<String> strings) {

    }

    public ResponseDto run(final RequestDto request) {
        return null;
    }
}
