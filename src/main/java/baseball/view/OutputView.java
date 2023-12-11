package baseball.view;

public class OutputView {
    private OutputView() {
        // 인스턴스 생성 방지용
    }

    public static void printStartMessage() {
        System.out.println(Message.START_MESSAGE.message);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void printGameOverMessage() {
        System.out.println(Message.GAME_OVER_MESSAGE.message);
    }

    private enum Message {
        START_MESSAGE("숫자 야구 게임을 시작합니다."),
        GAME_OVER_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
