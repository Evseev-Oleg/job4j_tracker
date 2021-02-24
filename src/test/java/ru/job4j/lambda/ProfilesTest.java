package ru.job4j.lambda;


import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void collectAddress() {
        List<Profile> prof = Collections.singletonList(new Profile(new Address("O",
                "O", 0, 0)));
        Profiles profiles = new Profiles();
        List<Address> list = profiles.collect(prof);
        assertThat(list.get(0).getCity(), is("O"));
    }

    @Test
    public void sortAddress() {
        List<Address> addresses = Arrays.asList(
                new Address("Moskow", "OOO", 0, 0),
                new Address("Abakan", "OOO", 0, 0),
                new Address("Baku", "OOO", 0, 0),
                new Address("Baku", "XXX", 0, 0)
        );
        addresses = addresses.stream().sorted(new AddressByCityComparator())
                .collect(Collectors.toList());
        List<Address> excepted = Arrays.asList(
                new Address("Abakan", "OOO", 0, 0),
                new Address("Baku", "OOO", 0, 0),
                new Address("Baku", "XXX", 0, 0),
                new Address("Moskow", "OOO", 0, 0)
        );
        assertThat(addresses, is(excepted));
    }

    @Test
    public void whenDistinctAddressThisNoMatches() {
        Profiles profiles = new Profiles();
        List<Profile> prof = Arrays.asList(
                new Profile(new Address("Moskow", "OOO", 0, 0)),
                new Profile(new Address("Abakan", "OOO", 0, 0)),
                new Profile(new Address("Baku", "OOO", 0, 0)),
                new Profile(new Address("Baku", "XXX", 0, 0)));
        List<Address> excepted = Arrays.asList(
                new Address("Abakan", "OOO", 0, 0),
                new Address("Baku", "OOO", 0, 0),
                new Address("Baku", "XXX", 0, 0),
                new Address("Moskow", "OOO", 0, 0)
        );
        assertThat(profiles.collect(prof), is(excepted));
    }

    @Test
    public void whenDistinctAddressThisOneMatches() {
        Profiles profiles = new Profiles();
        List<Profile> prof = Arrays.asList(
                new Profile(new Address("Moskow", "OOO", 0, 0)),
                new Profile(new Address("Abakan", "OOO", 0, 0)),
                new Profile(new Address("Baku", "OOO", 0, 0)),
                new Profile(new Address("Baku", "OOO", 0, 0)));
        List<Address> excepted = Arrays.asList(
                new Address("Abakan", "OOO", 0, 0),
                new Address("Baku", "OOO", 0, 0),
                new Address("Moskow", "OOO", 0, 0)
        );
        assertThat(profiles.collect(prof), is(excepted));
    }
}