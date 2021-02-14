package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    Predicate<List<Attachment>> filter1 = new Predicate<List<Attachment>>() {
        @Override
        public boolean test(List<Attachment> attachments) {
            for (Attachment att : attachments) {
                if (att.getSize() > 100 || att.getName().contains("bug")) {
                    return true;
                }
            }
            return false;
        }
    };
}
