package controller;

import domain.MenuRepository;
import domain.TableRepository;
import dto.RequestDto;
import exception.IllegalCommandException;
import service.ChickenService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class ChickenController {
    ChickenService chickenService = new ChickenService();

    public void run() {
        OutputView.printCommand();
        int commandNumber = InputView.inputCommandNumber();
        while (commandNumber!=3) {
            OutputView.printTables(chickenService.getTables());
            RequestDto request = makeRequestBy(commandNumber);
            chickenService.run(request);
        }

    }

    private RequestDto makeRequestBy(final int commandNumber) {
        int tableNumber = InputView.inputTableNumber();
        if(commandNumber==1){
            OutputView.printMenus(MenuRepository.menus());
            int menuNumber = InputView.inputMenuNumber();
            int menuCount = InputView.inputMenuCount();
            return new RequestDto(commandNumber, tableNumber, menuNumber, menuCount, 0);
        }

        if(commandNumber==2){
            OutputView.printPayment(tableNumber);
            int payment = InputView.inputPayment();
            return new RequestDto(commandNumber, tableNumber, 0, 0, payment);
        }
        throw new IllegalCommandException("존재하지 않는 명령어 입니다.");
    }


}
