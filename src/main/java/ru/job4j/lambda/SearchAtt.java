package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
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

    UnaryOperator<List<Attachment>> filter = new UnaryOperator<List<Attachment>>() {
        @Override
        public List<Attachment> apply(List<Attachment> attachments) {
            List<Attachment> list = new ArrayList<>();
            for (Attachment att : attachments) {
                if (att.getSize() > 100 || att.getName().contains("bug")) {
                    list.add(att);
                }
            }
            return list;
        }
    };
}
