package ru.job4j.lambda;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void collect() {
        List<Profile> prof = Arrays.asList(new Profile(new Address("O"
                , "O", 0,0)));
        Profiles profiles = new Profiles();
        List<Address> list = profiles.collect(prof);
        assertThat(list.get(0).getCity(), is("O"));
    }
}