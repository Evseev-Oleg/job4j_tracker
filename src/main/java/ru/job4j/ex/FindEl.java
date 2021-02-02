package ru.job4j.ex;

public class FindEl {
    public static void indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        int index = 0;
        for (String val:
             value) {
           if(val.equals(key)){
               rsl = index;
           }
           index++;
        }
        if(rsl == -1){
            throw new ElementNotFoundException("Index no found");
        }
    }

    public static void main(String[] args) {
        String[] value = new String[]{"Hello", "Good By", "Happy", "My friend"};
        try {
            indexOf(value,"Today");
        }catch (ElementNotFoundException e){
            e.printStackTrace();
        }
    }
}
