package domain.command;

import exception.IllegalCommandException;

import java.util.Arrays;

public enum Command {
    REGISTER(1),
    PAY(2),
    EXIT(3);

    private final int command;

    Command(final int command) {
        this.command = command;
    }

    public static Command of(final int command) {
        return Arrays.stream(values())
                .filter(value -> value.command == command)
                .findFirst()
                .orElseThrow(() -> new IllegalCommandException("존재하지 않는 명령어 입니다."));
    }
}
