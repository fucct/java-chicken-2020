package domain;

import domain.menu.MenuRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MenuTest {
    @ParameterizedTest
    @CsvSource(value={"1,[치킨] 1 - 후라이드 : 16000원"})
    void stringTest(int menu, String expected) {
        assertThat(MenuRepository.findMenuById(menu).toString()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value={"1,16000", "22,1000"})
    void getPriceTest(int menu, int expected) {
        assertThat(MenuRepository.findMenuById(menu).getPrice()).isEqualTo(expected);
    }
}