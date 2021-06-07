import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class HasMapImplTest {

    @Test
    public void testGetAllValues() {
        HashMapImpl hashMapExample = new HashMapImpl();
        hashMapExample.put(20, 1256L);
        hashMapExample.put(5458, 56L);
        hashMapExample.put(578, 34587L);

        assertEquals(Optional.of(1256L).get(), hashMapExample.get(20));
        assertEquals(Optional.of(56L).get(), hashMapExample.get(5458));
        assertEquals(Optional.of(34587L).get(), hashMapExample.get(578));
    }


    @Test
    public void testMissingValue() {
        HashMapImpl hashMapExample = new HashMapImpl();
        hashMapExample.put(20, 1256L);

        int expected = 123;
        assertNull(hashMapExample.get(expected));
    }


    @Test
    public void testSizeEntries() {
        HashMapImpl hashMapExample = new HashMapImpl();
        hashMapExample.put(13, 1116L);
        hashMapExample.put(322, 516L);
        hashMapExample.put(122, 34187L);
        hashMapExample.put(3333, 34287L);
        hashMapExample.put(1442, 34387L);
        hashMapExample.put(9, 34587L);
        hashMapExample.put(1875, 34587L);
        hashMapExample.put(799, 34587L);
        hashMapExample.put(211, 34587L);
        hashMapExample.put(98, 34587L);

        assertEquals(10, hashMapExample.size());
    }



}
