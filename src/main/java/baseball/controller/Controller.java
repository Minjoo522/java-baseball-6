package baseball.controller;

import baseball.domain.Numbers;
import baseball.service.NumbersGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {

    public void run() {
        OutputView.printStartMessage();
        Numbers numbers = new Numbers(InputView.readNumbers());
        Numbers computer = new Numbers(NumbersGenerator.generate());
    }
}
