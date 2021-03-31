import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    private static Stream<Arguments> provideArgsForQueueTest() {
        return Stream.of(
                Arguments.of(new int[] {-1, -2, -3}, new int[] {-3, -2, -1}),
                Arguments.of(new int[] {10, 5, 8, 11, 0}, new int[] {0, 5, 8, 10, 11}),
                Arguments.of(new int[] {9}, new int[] {9}),
                Arguments.of(new int[] {0, 0, 0}, new int[] {0, 0, 0}),
                Arguments.of(new int[] {}, new int[] {})
        );
    }

    @ParameterizedTest(name = "Test {index}: Input: {0} Correct: {1}")
    @MethodSource("provideArgsForQueueTest")
    public void QueueTest(int [] random_input, int[] correct_input) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i: random_input) queue.add(i);
        assertEquals(correct_input.length, queue.size());
        for (int j : correct_input) assertEquals(j, queue.poll());
    }

    @Test
    public void NullPointerTest() {
        assertThrows(NullPointerException.class, () -> {
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
            queue.add(null);
        });
    }

    @Test
    public void IllegalArgTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>(0);
        });
    }

    @Test
    public void BadCastTest() {
        assertThrows(ClassCastException.class, () -> {
            PriorityQueue<int[]> queue = new PriorityQueue<int[]>();
            int [] test = new int[] {1, 2};
            queue.add(test);
            queue.add("bad");
        });
    }
}
