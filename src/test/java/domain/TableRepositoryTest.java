package domain;

import domain.table.Table;
import domain.table.TableRepository;
import exception.IllegalTableException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TableRepositoryTest {

    @Test
    @DisplayName("tables return collection type list")
    void tables() {
        assertThat(TableRepository.tables()).isInstanceOf(Collection.class);
    }

    @Test
    @DisplayName("생성된 전체 테이블 삭제 불가")
    void unmodifiableTest() {
        List<Table> tables = TableRepository.tables();
        assertThatThrownBy(() -> tables.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @ParameterizedTest
    @DisplayName("table Id에 대한 table 반환")
    @ValueSource(ints = {1, 2, 3, 5, 6, 8})
    void of(int tableId) {
        assertThat(TableRepository.tables()).contains(TableRepository.findTableById(tableId));
    }

    @ParameterizedTest
    @DisplayName("Throw when input is not Exist table")
    @ValueSource(ints = {7, 9, 20, 23})
    void notExistId(int tableId) {
        assertThatThrownBy(() -> TableRepository.findTableById(tableId))
                .isInstanceOf(IllegalTableException.class)
                .hasMessageContaining("존재하지 않는 테이블 번호 입니다.");
    }
}