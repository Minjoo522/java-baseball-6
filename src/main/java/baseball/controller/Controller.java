package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class Controller {

    public void run() {
        OutputView.printStartMessage();
        List<Integer> numbers = InputView.readNumbers();

        for (int num : numbers) {
            System.out.println(num);
        }
    }
}
