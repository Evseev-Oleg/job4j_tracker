package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> bySize = attachment -> attachment.getSize() > 100;
        return find(list, bySize);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> byName = attachment -> attachment.getName().contains("bug");
        return find(list, byName);
    }

    public static List<Attachment> find(List<Attachment> list, Predicate<Attachment> predicate) {
        List<Attachment> res = new ArrayList<>();
        for (Attachment attachment : list) {
            if (predicate.test(attachment)) {
                res.add(attachment);
            }
        }
        return res;
    }
}
