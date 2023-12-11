package baseball.controller;

import baseball.domain.Numbers;
import baseball.domain.Result;
import baseball.service.NumbersGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {

    public void run() {
        OutputView.printStartMessage();
        Numbers user = new Numbers(InputView.readNumbers());
        Numbers computer = new Numbers(NumbersGenerator.generate());
        Result result = new Result(user, computer);
        OutputView.printResult(result.getResult());
    }
}
