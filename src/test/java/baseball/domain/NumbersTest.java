package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class NumbersTest {

    @DisplayName("[Exception] 세 자리가 아닌 숫자를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("InputNumbers")
    void createNumbersByOverSize(List<Integer> input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Numbers(input));
    }

    private static Stream<Arguments> InputNumbers() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4)),
                Arguments.arguments(List.of(1, 2))
        );
    }

    @DisplayName("[Exception] 중복된 숫자를 입력하면 예외가 발생한다.")
    @Test
    void createNumbersByDuplicateNumbers() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Numbers(List.of(1, 1, 2)));
    }

    @DisplayName("[Exception] 1~9가 아닌 숫자를 입력하면 예외가 발생한다.")
    @Test
    void createNumbersByOutOfBound() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Numbers(List.of(0, 1, 2)));
    }

    @DisplayName("[Success] 두 Numbers의 동일한 위치에 동일한 숫자가 있는지 세서 개수를 리턴한다.")
    @ParameterizedTest
    @MethodSource("strikeTestItems")
    void countStrike(List<Integer> computerNums, List<Integer> userNums, int expected) {
        Numbers computer = new Numbers(computerNums);
        Numbers user = new Numbers(userNums);
        assertThat(computer.countStrike(user))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> strikeTestItems() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3), List.of(1, 2, 3), 3),
                Arguments.arguments(List.of(1, 2, 3), List.of(1, 2, 4), 2),
                Arguments.arguments(List.of(1, 2, 3), List.of(4, 5, 6), 0)
        );
    }

    @DisplayName("[Success] 두 Numbers의 다른 위치에 동일한 숫자가 있는지 세서 개수를 리턴한다.")
    @ParameterizedTest
    @MethodSource("ballTestItems")
    void countBall(List<Integer> computerNums, List<Integer> userNums, int expected) {
        Numbers computer = new Numbers(computerNums);
        Numbers user = new Numbers(userNums);
        assertThat(computer.countBall(user))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> ballTestItems() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3), List.of(3, 1, 2), 3),
                Arguments.arguments(List.of(1, 2, 3), List.of(1, 3, 2), 2),
                Arguments.arguments(List.of(1, 2, 3), List.of(1, 2, 3), 0)
        );
    }
}
