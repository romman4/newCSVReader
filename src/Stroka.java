import java.util.ArrayList;

public class Stroka {
    long A, B, C;
    String stringValueCsv;
    ArrayList<Integer> indexesOfStringCompares;

    public Stroka(String stringValueCsv, long a, long b, long c) {
        this.stringValueCsv = stringValueCsv;
        A = a;
        B = b;
        C = c;
    }

    @Override
    public String toString() {
        return stringValueCsv + indexesOfStringCompares;
    }
}
