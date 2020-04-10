package domain;

import exception.IllegalMenuIdException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenuRepositoryTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 21, 22})
    void of(int menuId) {
        assertThat(MenuRepository.menus()).contains(MenuRepository.of(menuId));
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 8, 9, 20, 23})
    void notExistId(int menuId) {
        assertThatThrownBy(() -> MenuRepository.of(menuId))
                .isInstanceOf(IllegalMenuIdException.class)
                .hasMessageContaining("해당 메뉴는 존재하지 않습니다.");
    }
}
