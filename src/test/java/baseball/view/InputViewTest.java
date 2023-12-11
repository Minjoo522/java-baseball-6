package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
    @AfterEach
    void close() {
        Console.close();
    }

    @DisplayName("[Exception] 세 자리 숫자 입력 시 공백을 입력하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {" ", "\t", "\n"})
    void readNumbersByNull(String input) {
        command(input);
        assertThatIllegalArgumentException()
                .isThrownBy(InputView::readNumbers);
    }

    @DisplayName("[Exception] 세 자리 숫자 입력 시 숫자가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "1a", "12a", "숫자아님"})
    void readNumbersByNotNumber(String input) {
        command(input);
        assertThatIllegalArgumentException()
                .isThrownBy(InputView::readNumbers);
    }

    @DisplayName("[Success] 세 자리 숫자 입력 시 세 자리 숫자가 순서대로 포함된 리스트를 반환한다")
    @Test
    void getNumbersList() {
        command("123");
        assertThat(InputView.readNumbers())
                .isEqualTo(List.of(1, 2, 3));
    }

    @DisplayName("[Exception] 재시작 여부 입력 시 공백을 입력하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {" ", "\t", "\n"})
    void readNumberByNull(String input) {
        command(input);
        assertThatIllegalArgumentException()
                .isThrownBy(InputView::readNumber);
    }

    @DisplayName("[Exception] 재시작 여부 입력 시 숫자가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "1a", "12a", "숫자아님"})
    void readNumberByNotNumber(String input) {
        command(input);
        assertThatIllegalArgumentException()
                .isThrownBy(InputView::readNumber);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
