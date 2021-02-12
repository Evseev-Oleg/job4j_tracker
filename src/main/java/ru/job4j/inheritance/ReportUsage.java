package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report = new TextReport();
        JSONRepor jsonRepor = new JSONRepor();
        String text = report.generate("Report's name", "Report's body");
        String text2 = jsonRepor.generate("name", "body");
        System.out.println(text2);

    }
}
