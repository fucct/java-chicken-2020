package domain;

import domain.table.TableRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class TableTest {

    @ParameterizedTest
    @DisplayName("toString test")
    @ValueSource(ints = {1, 2, 3, 5, 6, 8})
    void string(int table) {
        assertThat(TableRepository.findTableById(table).toString()).isEqualTo(String.valueOf(table));
    }

    @ParameterizedTest
    @DisplayName("isSameId test")
    @ValueSource(ints = {1, 2, 3, 5, 6, 8})
    void isSameid(int table) {
        assertThat(TableRepository.findTableById(table).isSameId(table)).isTrue();
    }
}