package dto;

public class RequestDto {
    private final int commandNumber;
    private final int tableNumber;
    private final int menuNumber;
    private final int menuCount;
    private final int payment;

    public RequestDto(final int commandNumber, final int tableNumber, final int menuNumber, final int menuCount, final int payment) {
        this.commandNumber = commandNumber;
        this.tableNumber = tableNumber;
        this.menuNumber = menuNumber;
        this.menuCount = menuCount;
        this.payment = payment;
    }

    public int getCommandNumber() {
        return commandNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    public int getMenuCount() {
        return menuCount;
    }

    public int getPayment() {
        return payment;
    }
}
