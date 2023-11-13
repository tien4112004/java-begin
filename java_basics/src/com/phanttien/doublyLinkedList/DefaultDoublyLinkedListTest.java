import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DefaultDoublyLinkedListTest {
    private DefaultDoublyLinkedList<Integer> list;

    @BeforeEach
    public void setup() {
        list = new DefaultDoublyLinkedList<>();
    }

    @Test
    public void testAddAndSize() {
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
        list.add(2);
        assertEquals(2, list.size());
    }

    @Test
    public void testAddFirst() {
        list.addFirst(1);
        assertEquals(1, list.peekFirst());
        list.addFirst(2);
        assertEquals(2, list.peekFirst());
    }

    @Test
    public void testAddLast() {
        list.addLast(1);
        assertEquals(1, list.peekLast());
        list.addLast(2);
        assertEquals(2, list.peekLast());
    }

    @Test
    public void testRemoveFirst() {
        list.add(1);
        list.add(2);
        assertEquals(1, list.removeFirst());
        assertEquals(1, list.size());
    }

    @Test
    public void testRemoveLast() {
        list.add(1);
        list.add(2);
        assertEquals(2, list.removeLast());
        assertEquals(1, list.size());
    }

    @Test
    public void testRemoveAt() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.removeAt(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testIndexOf() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(1, list.indexOf(2));
        assertEquals(-1, list.indexOf(4));
    }

    @Test
    public void testContains() {
        list.add(1);
        list.add(2);
        assertTrue(list.contains(1));
        assertFalse(list.contains(3));
    }

    @Test
    public void testClear() {
        list.add(1);
        list.add(2);
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.empty());
    }
}