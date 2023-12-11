package baseball.controller;

import baseball.domain.Numbers;
import baseball.domain.Result;
import baseball.service.NumbersGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {

    public void run() {
        OutputView.printStartMessage();
        do {
            Numbers computer = new Numbers(NumbersGenerator.generate());
            play(computer);
        } while (checkRestart());
    }

    private void play(Numbers computer) {
        while (true) {
            Numbers user = new Numbers(InputView.readNumbers());
            Result result = new Result(user, computer);
            OutputView.printResult(result.getResult());

            if (result.checkGameOver()) {
                OutputView.printGameOverMessage();
                break;
            }
        }
    }

    private boolean checkRestart() {
        int input = InputView.readNumber();
        if (input != 1 && input != 2) {
            throw new IllegalArgumentException("1이나 2를 입력해주세요.");
        }
        if (input == 1) {
            return true;
        }
        return false;
    }
}
