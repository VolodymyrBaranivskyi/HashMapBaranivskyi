/**
 * Pair key-value
 *
 * @author Baranivskyi Volodymyr
 */
public class Entry {
    int key;
    long value;
    int hash;
    boolean flag;

    public Entry(int key, long value, int hash) {
        this.key = key;
        this.value = value;
        this.hash = hash;
        this.flag = false;
    }
}