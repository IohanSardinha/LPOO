package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {
    class StubListDeduplicator1 implements IListDeduplicator
    {
        @Override
        public List<Integer> deduplicate(IListSorter iListSorter)
        {
            List<Integer> l = new ArrayList<>();
            l.add(1);
            l.add(2);
            l.add(4);
            l.add(5);
            return l;
        }
    }

    class StubListDeduplicator2 implements IListDeduplicator
    {
        @Override
        public List<Integer> deduplicate(IListSorter iListSorter)
        {
            List<Integer> l = new ArrayList<>();
            l.add(1);
            l.add(2);
            l.add(4);
            return l;
        }
    }

    private List<Integer> list;

    @Before
    public void setUp()
    {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(5, max);

        List<Integer> list1 = new ArrayList<>();
        list1.add(-1);
        list1.add(-4);
        list1.add(-5);

        aggregator = new ListAggregator(list1);

        max = aggregator.max();
        assertEquals(-1,max);

    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {
        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(new StubListDeduplicator1());

        assertEquals(4, distinct);

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(4);
        list1.add(2);

        aggregator = new ListAggregator(list1);
        distinct = aggregator.distinct(new StubListDeduplicator2());

        assertEquals(3,distinct);
    }
}