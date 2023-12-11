package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private InputView() {
        // 인스턴스 생성 방지용
    }

    public static List<Integer> readNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = Console.readLine();
        validateInput(input);
        return splitNumbers(input);
    }

    private static void validateInput(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }

    private static List<Integer> splitNumbers(String input) {
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

    public static int readNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        validateInput(input);
        return parseToInt(input);
    }
}
