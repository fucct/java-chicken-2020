package view;

import domain.menu.Menu;
import domain.table.Table;
import domain.command.Command;
import domain.table.TableRepository;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "|  %s  |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String ORDERED_BOTTOM_LINE = "└ ₩ ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(tables);
    }

    private static void printBottomLine(List<Table> tables) {
        for (Table table : tables) {

        }
        System.out.println();
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printCommand() {
        System.out.println("## 메인화면");
        for(final Command command : Command.values()){
            System.out.println(command);
        }
        System.out.println();
    }

    public static void printPayment(int tableNumber) {
        System.out.println(tableNumber + "번 테이블의 결제를 진행합니다.");
    }

    public static void printErrorMessage(final String message) {
        System.out.println("Error : "+message);
    }
}
