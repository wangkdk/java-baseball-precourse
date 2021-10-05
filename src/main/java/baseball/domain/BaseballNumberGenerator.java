package baseball.domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import nextstep.utils.Randoms;

public class BaseballNumberGenerator {
    private static final int BASEBALL_NUMBERS_SIZE = 3;
    private static final int BASEBALL_NUMBER_MIN = 1;
    private static final int BASEBALL_NUMBER_MAX = 9;

    private BaseballNumberGenerator() {
    }

    public static List<Integer> generateNonDuplicateNumbers() {
        Set<Integer> nonDuplicateNumbers = new LinkedHashSet<>();
        while (nonDuplicateNumbers.size() < BASEBALL_NUMBERS_SIZE) {
            nonDuplicateNumbers.add(Randoms.pickNumberInRange(BASEBALL_NUMBER_MIN, BASEBALL_NUMBER_MAX));
        }
        return new ArrayList<>(nonDuplicateNumbers);
    }
}
