package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static List<Integer> readNumbers() {
        String input = Console.readLine();
        validateInput(input);
        return parseNumbers(input);
    }

    private static void validateInput(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }

    private static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(""))
                .map(InputView::parseToInt)
                .collect(Collectors.toList());
    }

    private static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
