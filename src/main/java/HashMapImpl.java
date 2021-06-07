/**
 * Simple implementation of a HashMap.
 *
 * @author Baranivskyi Volodymyr
 */
public class HashMapImpl implements IHashMap{

    private final float LOAD = 0.75f;

    private int capacity = 32;
    private int size = 0;

    private int currentSize;

    //key-value entries
    private Entry[] entries;

    public HashMapImpl() {
        entries = new Entry[capacity];
        currentSize = (int) (capacity * LOAD);

        for (int i = 0; i < capacity; i++) {
            entries[i] = null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    int hashCode(Integer key) {
        int hash =  key.hashCode();
        return (key == null) ? 0 : hash ^ ( key.hashCode() >>> 16);
    }

    @Override
    public void put(int key, long value) {
        int Index = hashCode(key) & (capacity - 1);

        while (entries[Index] != null && entries[Index].key != key) {
            entries[Index].flag = true;
            Index++;
            Index %= capacity;
        }

        if (entries[Index] == null) {
            size++;
            entries[Index] = new Entry(key, value, hashCode(key));
        }

        if (size >= currentSize) {
            resize(2 * entries.length);
        }

    }

    void resize(int newCapacity) {
        Entry[] newEntries = new Entry[newCapacity];
        move(newEntries);
        entries = newEntries;
        capacity = newCapacity;
        currentSize = (int) (entries.length * LOAD);
    }


    void move(Entry[] newEntries) {
        for (int i = 0; i < entries.length; i++) {
            Entry entry = entries[i];
            if (entry != null) {
                entries[i] = null;
                int currentIdx = indexOF(entry.hash, newEntries.length);
                newEntries[currentIdx] = entry;
            }
        }
    }

    //search index
    int indexOF(int hash, int capacity) {
        return hash & (capacity - 1);
    }

    @Override
    public Long get(int key) {
        int Index = indexOF(hashCode(key), capacity);


        if (entries[Index] != null && entries[Index].flag) {
            for (int i = Index; i < entries.length; i++) {
                Entry currEntry = entries[i];
                if (currEntry.key == key) {
                    return currEntry.value;
                }
            }
        }

        if ((entries[(capacity - 1) & hashCode(key)]) != null) {

            while (entries[Index] != null) {
                int counter = 0;

                if (counter++ > capacity) {
                    return null;
                }

                if (entries[Index].key == key) {
                    return entries[Index].value;
                }

                Index++;
                Index %= capacity;
            }
        }
        return null;
    }
}




//
//public class HashMapImpl implements IHashMap{



//
//    private final int CAPACITY = 16;
//    private final float LOAD = 0.75f;
//
//    private Integer[] keys;
//    private Long[] values;
//    private int size;
//    private int currentize;
//
//    public HashMapImpl(){
//        this.size = CAPACITY;
//        this.keys = new Integer[size];
//        this.values = new Long[size];
//    }
//
//    private int getSize(){
//        return size;
//    }
//
//    private void setSize(int size){
//        this.size = size;
//    }
//    private int getCurrentSize(){
//        return currentize;
//    }
//
//
//    @Override
//    public int size() {
//        return size;
//    }
//
//    int hashCode(Integer key){
//        if(key==0) return 0;
//        return (1 + key) % (this.capacity - 1);
//    }
//
//    @Override
//    public void put(Integer key, Long value) {
//        if(getSize()*LOAD <=size()){
//            resize();
//        }
//        int index = getIndex(key);
//        for (int i = index;;i++){
//            if(i == size){
//                i = 0;
//            }
//            if(keys[i] == null){
//                keys[i] = key;
//                currentize++;
//            }
//            if(keys[i] == key){
//                values[i] = value;
//                break;
//            }
//
//        }
//
//    }
//
//
//
//    @Override
//    public Long get(Integer key) {
//        return null;
//    }
//}
