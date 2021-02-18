package ru.job4j.lambda;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        List<Address> list;
        list = profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
        list = list.stream().sorted(new AddressByCityComparator()).distinct().collect(Collectors.toList());
        return list;
    }
}
