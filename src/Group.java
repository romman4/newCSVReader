import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Group implements Comparable<Group>{
    ArrayList<String> listOfStrok = new ArrayList<>();

    private TreeSet<Long> setOfAValuesOfGroup = new TreeSet<Long>();
    private TreeSet<Long> setOfBValuesOfGroup = new TreeSet<Long>();
    private TreeSet<Long> setOfCValuesOfGroup = new TreeSet<Long>();

    public Group(Stroka s) {
        addStrokaToList(s);
    }

    public void addStrokaToList(Stroka s) {
        listOfStrok.add(s.stringValueCsv);
        setOfAValuesOfGroup.add(s.A);
        setOfBValuesOfGroup.add(s.B);
        setOfCValuesOfGroup.add(s.C);
    }

    public boolean checkStroka(Stroka s) {
        long a = s.A, b = s.B, c = s.C;
        if ((a == 0) || (b == 0) || (c == 0)) {
            return false;
        }
        return ((setOfAValuesOfGroup.contains(a)) || (setOfBValuesOfGroup.contains(b)) ||
                ((setOfCValuesOfGroup.contains(c))));
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
