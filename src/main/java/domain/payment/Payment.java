package domain.payment;

import java.util.Arrays;
import java.util.function.Function;

public enum Payment {
    CASH(1, sum -> sum * 0.95),
    CARD(2, sum -> sum * 1.00);

    private final int payment;
    private final Function<Integer, Double> sale;

    Payment(final int payment, final Function<Integer, Double> sale) {
        this.payment = payment;
        this.sale = sale;
    }

    public double applySale(int sum) {
        return sale.apply(sum);
    }

    public static Payment findPaymentById(final int payment) {
        return Arrays.stream(values()).filter(pay -> pay.payment == payment)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("알 수 없는 결제 방식입니다."));
    }
}
