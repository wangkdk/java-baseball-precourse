package baseball;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.test.NSTest;
import nextstep.utils.Randoms;

public class ApplicationTest extends NSTest {
    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    void 낫싱() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 3, 5);
            running("246");
            verify("낫싱");
        }
    }

    @Test
    void 게임종료_후_재시작() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(7, 1, 3)
                .thenReturn(5, 8, 9);
            run("713", "1", "597", "589", "2");
            verify("3스트라이크", "게임 끝", "1스트라이크 1볼");
        }
    }

    @Test
    @DisplayName("2스트라이크 확인")
    void strike() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 3, 5);
            running("137");
            verify("2스트라이크");
        }
    }

    @Test
    @DisplayName("3볼 확인")
    void ball() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 3, 5);
            running("513");
            verify("3볼");
        }
    }

    @Test
    @DisplayName("스트라이크 볼 둘다 포함 확인")
    void strike_ball() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 3, 5);
            running("153");
            verify("1스트라이크 2볼");
        }
    }

    @Test
    @DisplayName("게임 종료 확인")
    void endGame() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(3, 5, 2);
            run("352", "2");
            verify("3스트라이크", "게임 끝");
        }
    }

    @Test
    @DisplayName("게임 종료 후 재시작 선택 - 알파벳 입력")
    void endGame_restart_select_en() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(3, 5, 2);
            run("352", "a", "2");
            verify("3스트라이크", "게임 끝", "[ERROR] 잘못된 문자를 입력하였습니다. 다시 입력해주세요.");
        }
    }

    @Test
    @DisplayName("게임 종료 후 재시작 선택 - 한글 입력")
    void endGame_restart_select_ko() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(3, 5, 2);
            run("352", "하", "2");
            verify("3스트라이크", "게임 끝", "[ERROR] 잘못된 문자를 입력하였습니다. 다시 입력해주세요.");
        }
    }

    @Test
    @DisplayName("게임 종료 후 재시작 선택 - 5 입력")
    void endGame_restart_select_number() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(3, 5, 2);
            run("352", "5", "2");
            verify("3스트라이크", "게임 끝", "[ERROR] 잘못된 문자를 입력하였습니다. 다시 입력해주세요.");
        }
    }

    @Test
    @DisplayName("플레이어 잘못된 숫자 입력 - 2자리 숫자")
    void input_lessThan_numbers() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(3, 5, 2);
            run("35", "352", "2");
            verify("[ERROR] 야구 게임 숫자는 3개만 가능합니다.");
        }
    }

    @Test
    @DisplayName("플레이어 잘못된 숫자 입력 - 5자리 숫자")
    void input_greaterThan_numbers() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(3, 5, 2);
            run("35192", "352", "2");
            verify("[ERROR] 야구 게임 숫자는 3개만 가능합니다.");
        }
    }

    @Test
    @DisplayName("플레이어 잘못된 숫자 입력 - 중복된 숫자")
    void input_duplicate_numbers() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(3, 5, 2);
            run("332", "352", "2");
            verify("[ERROR] 야구 게임 숫자는 중복될 수 없습니다.");
        }
    }

    @Test
    @DisplayName("플레이어 잘못된 숫자 입력 - 0 포함된 숫자")
    void input_zero_numbers() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(3, 5, 2);
            run("025", "352", "2");
            verify("[ERROR] 1 ~ 9 사이의 숫자만 입력 가능합니다.");
        }
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
