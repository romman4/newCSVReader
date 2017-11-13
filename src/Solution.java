import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    private static String FILE_NAME = "doc/lng.csv";
    private static String FILE_NAME1 = "doc/test1kEntries.csv";
    private static String FILE_NAME2 = "doc/test10kEntries.csv";
    private static List<Group> listOfGroups;

    public static void main(String[] args) throws Exception{
        String lineIn;
        Stroka tempStroka = null;
        listOfGroups = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME2)));

        long start = System.currentTimeMillis();
        while (reader.ready()) {
            lineIn = reader.readLine();
            try {
                tempStroka = new Stroka(lineIn, longFromStringWithoutQuotes((lineIn.split(";")[0])),
                        longFromStringWithoutQuotes((lineIn.split(";")[1])),                    // создаем строку tempStroka, которая явл строкой файла csv
                        longFromStringWithoutQuotes((lineIn.split(";")[2])));
                tempStroka.stringValueCsv = lineIn;
            } catch (RuntimeException e) {
                System.out.println("Invalid string!");
                System.out.println(lineIn);
            }
            strAddToHerGroup(tempStroka);                                          // добавляем в список строку из файла цсв
        }

        Collections.sort(listOfGroups);
        for (Group g :
                listOfGroups) {
            System.out.println("Группа:");
            System.out.println(g);
        }
        long finish = System.currentTimeMillis();
        System.out.println("Суммарное время: " + (finish - start));
    }

    private static void strAddToHerGroup(Stroka stroka) {
        if (!isGroupsContainsOurStrokaGroup(stroka)) {
            listOfGroups.add(new Group(stroka));
        }
    }

    private static boolean isGroupsContainsOurStrokaGroup(Stroka stroka) {

        for (Group g : listOfGroups) {
            if (g.checkStroka(stroka)) {
                g.addStrokaToList(stroka);
                return true;
            }
        }

        return false;
    }

    private static Long longFromStringWithoutQuotes(String s) {
        if (s.length() == 2) {
            return (long) 0;
        } else return Long.parseLong(s.substring(1, s.length() - 1));
    }
}
