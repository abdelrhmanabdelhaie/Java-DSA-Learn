package org.example.collection;

import org.example.Foo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NonPrimitivesUnitTest {
    @Test
    public void whenModifyingObjects_thenOriginalObjectChanged() {
        Foo a = new Foo(1);
        Foo b = new Foo(1);

        // Before Modification
        assertEquals(a.num, 1);
        assertEquals(b.num, 1);

        modify(a, b);

        // After Modification
        assertEquals(a.num, 3);
        assertEquals(b.num, 1);
    }

    public static void modify(Foo a, Foo b1) {
        a.num++;
        a.num++;

        b1 = new Foo(1);
        b1.num++;
    }
}
