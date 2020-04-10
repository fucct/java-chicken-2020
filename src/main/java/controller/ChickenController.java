package controller;

import dto.RequestDto;
import dto.ResponseDto;
import exception.IllegalCommandException;
import service.ChickenService;
import view.InputView;
import view.OutputView;

public class ChickenController {
    ChickenService chickenService = new ChickenService();

    public void run() {
        while(true){
            OutputView.printCommand();
            int commandNumber = InputView.inputCommandNumber();
            RequestDto request = makeRequestDtoByCommand(commandNumber);
            ResponseDto response = chickenService.run(request);
            OutputView.printResponse(response);
        }

    }

    private RequestDto makeRequestDtoByCommand(int commandNumber) {
        if(commandNumber == 1) {
            return new RequestDto(commandNumber, InputView.inputTableNumber(), InputView.inputMenuNumber(),
                    InputView.inputMenuCount());
        }
        if(commandNumber==2) {
            return new RequestDto(commandNumber, InputView.inputTableNumber(), InputView.inputPayment());
        }
        if(commandNumber==3){
            return new RequestDto(commandNumber);
        }
        throw new IllegalCommandException("알 수 없는 명령어 입니다.");
    }
}
