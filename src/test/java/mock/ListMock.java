package mock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ListMock {

    ListMock() {
    }

    public static List<Integer> integerList(int max) {
        return integerList(0, max);
    }

    public static List<Integer> integerList(int min, int max) {
        return IntStream.range(min, max)
                .collect(ArrayList::new, List::add, List::addAll);
    }
}
