package baseball.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateBound(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("세 자리 숫자가 아닙니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long uniqueNumber = numbers.stream()
                .distinct()
                .count();
        if (uniqueNumber != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
        }
    }

    private void validateBound(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < 1) {
                throw new IllegalArgumentException("1~9 사이의 숫자만 입력해주세요.");
            }
        }
    }

    public int countStrike(Numbers compare) {
        return (int) IntStream.range(0, numbers.size())
                .filter(i -> compare.isStrike(numbers.get(i), i))
                .count();
    }

    private boolean isStrike(int number, int index) {
        return number == numbers.get(index);
    }

    public int countBall(Numbers compare) {
        return (int) IntStream.range(0, numbers.size())
                .filter(i -> compare.isBall(numbers.get(i), i))
                .count();
    }

    private boolean isBall(int number, int index) {
        return !isStrike(number, index) && numbers.contains(number);
    }
}
