package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {
    private final String COMMA = ",";
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("split 으로 분리된 값에 대한 테스트")
    @Test
    void splitTest() {
        String number = "1,2";
        String[] numberArray = number.split(COMMA);

        assertThat(numberArray).containsExactly("1", "2");
    }

    @DisplayName("split 으로 단일값을 분리했을 경우에 대한 테스트")
    @Test
    void splitTestForSingleValue() {
        String number = "1";
        String[] numberArray = number.split(COMMA);

        assertThat(numberArray).contains(number);
    }

    @DisplayName("substring 테스트")
    @Test
    void substringTest() {
        String numberInParentheses = "(1,2)";
        String number = numberInParentheses.substring(1, 4);

        assertThat(number).isEqualTo("1,2");
    }

    @DisplayName("charAt 테스트")
    @Test
    void charAtTest() {
        String sample = "abc";

        assertEquals("a", String.valueOf(sample.charAt(0)));
        assertEquals("b", String.valueOf(sample.charAt(1)));
        assertEquals("c", String.valueOf(sample.charAt(2)));
    }

    @DisplayName("charAt 의 StringIndexOutOfBoundsException 발생 테스트")
    @Test
    void charAtExceptionTest() {
        String sample = "abc";
        String exceptionDescription = "String index out of range: 3";

        assertThatThrownBy(() -> sample.charAt(3))
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining(exceptionDescription);

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> sample.charAt(3))
            .withMessageMatching(exceptionDescription);
    }

    @DisplayName("Set 크기 확인 테스트")
    @Test
    void checkSetSizeTest() {
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("set contains test")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void checkSetContainsTest(int number) {
        assertTrue(numbers.contains(number));
    }

    @DisplayName("set contains test - 결과 값이 다른 경우")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void checkSetContainsTest_differentResult(int input, boolean expected) {
        assertEquals(expected, numbers.contains(input));
    }
}
