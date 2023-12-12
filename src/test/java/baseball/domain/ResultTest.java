package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ResultTest {
    @DisplayName("[Success] 3스트라이크인 경우 true를 리턴하고 아닌 경우 false를 리턴한다.")
    @ParameterizedTest
    @MethodSource("resultInput")
    void checkThreeStrikeOutOrNot(List<Integer> userNums, List<Integer> computerNumbs, boolean expected) {
        Numbers user = new Numbers(userNums);
        Numbers computer = new Numbers(computerNumbs);
        Result result = new Result(user, computer);

        assertThat(result.checkGameOver())
                .isEqualTo(expected);
    }

    private static Stream<Arguments> resultInput() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3), List.of(1, 2, 3), true),
                Arguments.arguments(List.of(1, 2, 3), List.of(1, 2, 4), false)
        );
    }

    @DisplayName("[Success] 게임의 결과를 String으로 올바르게 리턴한다.")
    @ParameterizedTest
    @MethodSource("resultStringInput")
    void getResult(List<Integer> userNums, List<Integer> computerNums, String expected) {
        Numbers user = new Numbers(userNums);
        Numbers computer = new Numbers(computerNums);
        Result result = new Result(user, computer);

        assertThat(result.getResult())
                .isEqualTo(expected);
    }

    private static Stream<Arguments> resultStringInput() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3), List.of(1, 2, 3), "3스트라이크"),
                Arguments.arguments(List.of(1, 2, 3), List.of(1, 4, 5), "1스트라이크"),
                Arguments.arguments(List.of(1, 2, 3), List.of(2, 1, 5), "2볼"),
                Arguments.arguments(List.of(1, 2, 3), List.of(1, 3, 5), "1볼 1스트라이크"),
                Arguments.arguments(List.of(1, 2, 3), List.of(4, 5, 6), "낫싱")
        );
    }
}
