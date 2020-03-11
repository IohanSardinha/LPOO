package com.aor.numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {

    class StubListSorter1 implements IListSorter
    {
        @Override
        public List<Integer> sort() {
            List<Integer> l = new ArrayList<>();
            l.add(1);
            l.add(2);
            l.add(2);
            l.add(4);
            l.add(5);
            return l;
        }
    }

    class StubListSorter2 implements IListSorter
    {
        @Override
        public List<Integer> sort() {
            List<Integer> l = new ArrayList<>();
            l.add(1);
            l.add(2);
            l.add(2);
            l.add(4);
            return l;
        }
    }

    @Test
    public void deduplicate() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new StubListSorter1());

        assertEquals(expected, distinct);

        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        deduplicator = new ListDeduplicator(list);
        distinct = deduplicator.deduplicate(new StubListSorter2());

        assertEquals(expected,distinct);
    }
}