package baseball.domain;

public class Result {
    private final int strike;
    private final int ball;

    public Result(Numbers user, Numbers computer) {
        strike = computer.countStrike(user);
        ball = computer.countBall(user);
    }

    public String getResult() {
        if (strike != 0 && ball != 0) {
            return String.format("%d볼 %d스트라이크", ball, strike);
        }
        if (strike != 0 && ball == 0) {
            return String.format("%d스트라이크", strike);
        }
        if (strike == 0 && ball != 0) {
            return String.format("%d볼", ball);
        }
        return "낫싱";
    }
}
