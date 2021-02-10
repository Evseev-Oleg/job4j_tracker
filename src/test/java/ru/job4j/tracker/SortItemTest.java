package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SortItemTest {
    @Test
    public void whenSortByNameAscending() {
        List<Item> list = Arrays.asList(new Item(2, "ebc"), new Item(4, "bds"),
                new Item(1, "ads"), new Item(3, "cde"));
        list.sort(new SortItemByNameAscending());
        List<Item> expected = Arrays.asList(new Item(1, "ads"), new Item(4, "bds"),
                new Item(3, "cde"), new Item(2, "ebc"));
        assertThat(list, is(expected));
    }

    @Test
    public void whenSortByIdAscending() {
        List<Item> list = Arrays.asList(new Item(2, "ebc"), new Item(4, "bds"),
                new Item(1, "ads"), new Item(3, "cde"));
        list.sort(new SortItemByIdAscending());
        List<Item> expected = Arrays.asList(new Item(1, "ads"), new Item(2, "ebc"),
                new Item(3, "cde"), new Item(4, "bds"));
        assertThat(list, is(expected));
    }

    @Test
    public void whenSortByNameDescending() {
        List<Item> list = Arrays.asList(new Item(2, "ebc"), new Item(4, "bds"),
                new Item(1, "ads"), new Item(3, "cde"));
        list.sort(new SortItemByNameDescending());
        List<Item> expected = Arrays.asList(new Item(2, "ebc"), new Item(3, "cde"),
                new Item(4, "bds"), new Item(1, "ads"));
        assertThat(list, is(expected));
    }

    @Test
    public void whenSortByIdDescending() {
        List<Item> list = Arrays.asList(new Item(2, "ebc"), new Item(4, "bds"),
                new Item(1, "ads"), new Item(3, "cde"));
        list.sort(new SortItemByIdDescending());
        List<Item> expected = Arrays.asList(new Item(4, "bds"), new Item(3, "cde"),
                new Item(2, "ebc"), new Item(1, "ads"));
        assertThat(list, is(expected));
    }

    @Test
    public void whenSortByIdAndNameDescending() {
        List<Item> list = Arrays.asList(new Item(2, "ebc"), new Item(4, "bds"),
                new Item(1, "ads"), new Item(3, "cde"), new Item(1, "bcd"),
                new Item(3, "atr"), new Item(2, "dir"), new Item(4, "opu"));
        Comparator<Item> itemComparator = new SortItemByIdAscending().thenComparing(new SortItemByNameAscending());
        list.sort(itemComparator);
        List<Item> expected = Arrays.asList(new Item(1, "ads"), new Item(1, "bcd"),
                new Item(2, "dir"), new Item(2, "ebc"), new Item(3, "atr"),
                new Item(3, "cde"), new Item(4, "bds"), new Item(4, "opu"));
        assertThat(list, is(expected));
    }
}
