import java.util.Comparator;

public class SortComparator implements Comparator<FinalPlayer> {
    public int compare(FinalPlayer fP1, FinalPlayer fP2) {
        return fP1.getName().compareTo(fP2.getName());
    }
}