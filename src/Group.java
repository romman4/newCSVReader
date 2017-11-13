import java.util.ArrayList;
import java.util.TreeSet;

public class Group implements Comparable<Group>{
    private ArrayList<String> listOfStrok = new ArrayList<>();
    private TreeSet<Long> setOfAValuesOfGroup = new TreeSet<>();
    private TreeSet<Long> setOfBValuesOfGroup = new TreeSet<>();
    private TreeSet<Long> setOfCValuesOfGroup = new TreeSet<>();

    Group(Stroka s) {
        addStrokaToList(s);
    }

    void addStrokaToList(Stroka s) {
        listOfStrok.add(s.stringValueCsv);
        setOfAValuesOfGroup.add(s.A);
        setOfBValuesOfGroup.add(s.B);
        setOfCValuesOfGroup.add(s.C);
    }

    boolean checkStroka(Stroka s) {
        long a = s.A, b = s.B, c = s.C;
        return (a != 0) && (b != 0) && (c != 0) && (setOfAValuesOfGroup.contains(s.A) ||
                setOfBValuesOfGroup.contains(s.B) || setOfCValuesOfGroup.contains(s.C));
    }

    @Override
    public int compareTo(Group o) {
        return o.listOfStrok.size() - listOfStrok.size();
    }

    @Override
    public String toString() {
        StringBuilder resultStroka = new StringBuilder();
        for (String s :
                this.listOfStrok) {
            resultStroka.append(s).append("\n");
        }
        return resultStroka.toString();
    }
}

