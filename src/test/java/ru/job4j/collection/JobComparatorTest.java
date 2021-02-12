package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JobComparatorTest {
    @Test
    public void whenSortByNameAscending() {
        List<Job> list = Arrays.asList(new Job("ebc", 2), new Job("bds", 4),
                new Job("ads", 1), new Job("cde", 3));
        list.sort(new JobAscenByName());
        List<Job> expected = Arrays.asList(new Job("ads", 1), new Job("bds", 4),
                new Job("cde", 3), new Job("ebc", 2));
        assertThat(list, is(expected));
    }

    @Test
    public void whenSortByIdAscending() {
        List<Job> list = Arrays.asList(new Job("ebc", 2), new Job("bds", 4),
                new Job("ads", 1), new Job("cde", 3));
        list.sort(new JobAscenByPriority());
        List<Job> expected = Arrays.asList(new Job("ads", 1), new Job("ebc", 2),
                new Job("cde", 3), new Job("bds", 4));
        assertThat(list, is(expected));
    }

    @Test
    public void whenSortByNameDescending() {
        List<Job> list = Arrays.asList(new Job("ebc", 2), new Job("bds", 4),
                new Job("ads", 1), new Job("cde", 3));
        list.sort(new JobDescByName());
        List<Job> expected = Arrays.asList(new Job("ebc", 2), new Job("cde", 3),
                new Job("bds", 4), new Job("ads", 1));
        assertThat(list, is(expected));
    }

    @Test
    public void whenSortByIdDescending() {
        List<Job> list = Arrays.asList(new Job("ebc", 2), new Job("bds", 4),
                new Job("ads", 1), new Job("cde", 3));
        list.sort(new JobDescByPriority());
        List<Job> expected = Arrays.asList(new Job("bds", 4), new Job("cde", 3),
                new Job("ebc", 2), new Job("ads", 1));
        assertThat(list, is(expected));

    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndPrority2() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("AAA", 0),
                new Job("AAA", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityAndLength() {
        Comparator<Job> comb = new JobDescByNameLn().thenComparing(new JobDescByName()).
                thenComparing(new JobDescByPriority());
        int rsl = comb.compare(new Job("Aaa", 1), new Job("Aaa", 0));
        assertThat(rsl, lessThan(0));
    }
}