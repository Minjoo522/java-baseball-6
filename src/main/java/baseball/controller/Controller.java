package baseball.controller;

import baseball.domain.Numbers;
import baseball.domain.Result;
import baseball.service.NumbersGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {

    public void run() {
        OutputView.printStartMessage();
        Numbers computer = new Numbers(NumbersGenerator.generate());
        play(computer);
    }

    private void play(Numbers computer) {
        while (true) {
            Numbers user = new Numbers(InputView.readNumbers());
            Result result = new Result(user, computer);
            OutputView.printResult(result.getResult());

            if (result.checkGameOver()) {
                break;
            }
        }
    }
}
