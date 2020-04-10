package domain;

import domain.command.Command;
import exception.IllegalCommandException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CommandTest {
    @ParameterizedTest
    @ValueSource(strings = {"REGISTER", "PAY", "EXIT"})
    void create(String command) {
        assertThat(Command.valueOf(command)).isInstanceOf(Command.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void of(int command) {
        assertThat(Command.of(command)).isInstanceOf(Command.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void ofNotExist(int command) {
        assertThatThrownBy(() -> Command.of(command))
                .isInstanceOf(IllegalCommandException.class)
                .hasMessageContaining("존재하지 않는 명령어 입니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1 - 주문 등록"})
    void toStringTest(int command, String expected) {
        assertThat(Command.of(command).toString()).isEqualTo(expected);
    }
}
