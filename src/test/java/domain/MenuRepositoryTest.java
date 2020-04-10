package domain;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import exception.IllegalMenuIdException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenuRepositoryTest {

    @Test
    @DisplayName("생성된 전체 메뉴 삭제 불가")
    void unmodifiableTest() {
        List<Menu> menus = MenuRepository.menus();
        assertThatThrownBy(() -> menus.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @ParameterizedTest
    @DisplayName("menu Id에 대한 메뉴 반환")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 21, 22})
    void of(int menuId) {
        assertThat(MenuRepository.menus()).contains(MenuRepository.findMenuById(menuId));
    }

    @ParameterizedTest
    @DisplayName("Throw when input is not Exist Menu")
    @ValueSource(ints = {7, 8, 9, 20, 23})
    void notExistId(int menuId) {
        assertThatThrownBy(() -> MenuRepository.findMenuById(menuId))
                .isInstanceOf(IllegalMenuIdException.class)
                .hasMessageContaining("해당 메뉴는 존재하지 않습니다.");
    }
}
