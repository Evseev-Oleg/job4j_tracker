package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> bySize = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > 100;
            }
        };
        return find(list, bySize);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> byName = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
        return find(list, byName);
    }

    public static List<Attachment>find(List<Attachment> list, Predicate<Attachment> predicate) {
        List<Attachment> res = new ArrayList<>();
        for (Attachment attachment : list) {
            if (predicate.test(attachment)) {
                res.add(attachment);
            }
        }
        return res;
    }
}
