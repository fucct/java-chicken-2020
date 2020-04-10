package domain.command;

import exception.IllegalCommandException;

import java.util.Arrays;

public enum Command {
    REGISTER(1, "주문 등록"),
    PAY(2, "결제하기"),
    EXIT(3, "프로그램 종료");

    private final int command;
    private final String commandName;

    Command(final int command, final String commandName) {
        this.command = command;
        this.commandName = commandName;
    }

    public static Command of(final int command) {
        return Arrays.stream(values())
                .filter(value -> value.command == command)
                .findFirst()
                .orElseThrow(() -> new IllegalCommandException("존재하지 않는 명령어 입니다."));
    }

    @Override
    public String toString() {
        return command + " - " + commandName;
    }
}
