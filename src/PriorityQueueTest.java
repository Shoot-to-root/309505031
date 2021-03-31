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
                Arguments.of(new Integer[] {-1, -2, -3}, new Integer[] {-3, -2, -1}),
                Arguments.of(new Integer[] {10, 5, 8, 11, 0}, new Integer[] {0, 5, 8, 10, 11}),
                Arguments.of(new Integer[] {9}, new Integer[] {9}),
                Arguments.of(new Integer[] {0, 0, 0}, new Integer[] {0, 0, 0}),
                Arguments.of(new Integer[] {}, new Integer[] {})
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
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
            queue.add(1);
            queue.add("bad code");
        });
    }
}
