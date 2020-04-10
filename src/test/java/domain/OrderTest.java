package domain;

import domain.menu.MenuRepository;
import domain.order.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderTest {
    @Test
    @DisplayName("생성 테스트")
    void create() {
        assertThat(new Order(MenuRepository.findMenuById(1), 1)).isInstanceOf(Order.class);
    }

    @ParameterizedTest
    @DisplayName("할인 전 주문의 금액을 계산")
    @CsvSource(value = {"1,1,16000", "1,5,80000"})
    void calculateRawPrice(int menu, int count, int expectedPrice){
        assertThat(new Order(MenuRepository.findMenuById(menu), count).calculateRawPrice()).isEqualTo(expectedPrice);
    }

    @ParameterizedTest
    @DisplayName("0개 이하, 99개 초과의 주문은 불가능")
    @CsvSource(value={"1,100", "1,0", "1,-5"})
    void outRange(int menu, int count){
        assertThatThrownBy(()->new Order(MenuRepository.findMenuById(menu), count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("주문은 1개 이상 99개 이하만 가능합니다.");
    }
}
