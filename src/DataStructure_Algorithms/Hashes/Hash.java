package DataStructure_Algorithms.Hashes;

import java.util.LinkedList;

public class Hash<K,V>{
   class HashElement<K,V> implements Comparable<HashElement<K,V>>{
       K key;
       V value;
       public HashElement(K key, V value){
           this.key=key;
           this.value=value;
       }

       @Override
       public int compareTo(HashElement<K,V> o) {
           return ((Comparable<K>)o.key).compareTo(this.key);
       }
       //we could override methods : toString(), equals(), hashcode()
       //but is fine because is a INNER class so its private and is only on our Data structure
   }
        int numElements, tableSize;//numElements if we add ++ , if we remove --, keeps track of the number of elements; tableSize is the array length
        double maxloadFactor;

        LinkedList<HashElement<K,V>> [] HashArray;

        public Hash(int tableSize){
            this.tableSize = tableSize;
            //initiate the array
            HashArray = (LinkedList<HashElement<K,V>>[]) new LinkedList[tableSize];
            //we can do the next thing:
            //we get hashCode from an element and find his place in array, and then check if is null, if is null create a LinkedList and add then - we have to do this with every element; it costs time
            //or... we can initialize array with empty LinkedLists on every cell
            for(int i = 0; i<tableSize;i++){
                HashArray[i] = new LinkedList<HashElement<K,V>>();
            }
            maxloadFactor = 0.75;
            numElements = 0;
        }
        public int loadFactor(){
            return (numElements/tableSize);
        }
        public void resize(int newSize){
            newSize = tableSize * newSize;
            LinkedList<HashElement<K,V>>[] new_array;
            new_array = (LinkedList<HashElement<K,V>> []) new LinkedList[newSize];
            for(int i = 0; i<newSize; i++){
                new_array[i] = new LinkedList<HashElement<K,V>>();
            }
            for(LinkedList<HashElement<K,V>> lk : HashArray){
                for(HashElement<K,V> el : lk){
                    int hashvalue = el.key.hashCode();
                    hashvalue = hashvalue & 0x7FFFFFFF;
                    hashvalue = hashvalue % newSize;

                    new_array[hashvalue].add(el);
                }
            }

            HashArray = new_array;
           tableSize = newSize;
        }
        public void addKVElement(K key, V value){
            if(loadFactor()>maxloadFactor){
                resize(2);
                System.out.println("Resized");
            }
            HashElement<K,V> he = new HashElement<>(key, value);
            //find the position in array where we can add this element;
            int hashvalue = key.hashCode();
            hashvalue = hashvalue & 0x7FFFFFFF;
            hashvalue = hashvalue % tableSize;

            HashArray[hashvalue].add(he);
            numElements++;
        }

        public void removeKVElement(K key){
            int hashvalue = key.hashCode();
            hashvalue = hashvalue & 0x7FFFFFFF;
            hashvalue = hashvalue % tableSize;
            HashArray[hashvalue].remove();
            numElements--;
        }

        public V getKVElement(K key){
             int hashvalue = key.hashCode();
             hashvalue = hashvalue &0x7FFFFFFF;
             hashvalue = hashvalue % tableSize;

             for(HashElement<K,V> he : HashArray[hashvalue]){
                 if(((Comparable<K>)key).compareTo(he.key) == 0){
                     return he.value;
                 }
             }
             String empty = "There is no value at that key!";
             return (V) empty;
        }
//    class IteratorHelper<T> implements Iterator<T>{
//        T[] keys;
//        int position;
//
//        public IteratorHelper(){
//            keys = (T[])new Object[numElements];
//            int p = 0;
//            for(int i = 0; i< tableSize; i++){
//                LinkedList<Hash.HashElement<K,V>> list = HashArray[i];
//                for(Hash.HashElement<K,V> each : list){
//                    keys[p++] =(T) each.key;
//                }
//            }
//            position++;
//        }
//
//
//        @Override
//        public boolean hasNext() {
//            return position < keys.length;
//        }
//
//        @Override
//        public T next() {
//            if(!hasNext()){
//                return null;
//            }
//            return keys[position++];
//        }
//    }

    public static void main(String[] args) {
        Hash<String,Integer> myHash = new Hash<>(4);
        myHash.addKVElement("1el",1);
        myHash.addKVElement("2el", 2);
        myHash.addKVElement("3el", 3);
        myHash.addKVElement("4el", 4);
        myHash.addKVElement("5el", 5);

        System.out.println(myHash.getKVElement("5el"));
        System.out.println(myHash.getKVElement("5el"));
        System.out.println(myHash.getKVElement("2el"));
//        IteratorHelper it = new IteratorHelper<>();
    }

}
