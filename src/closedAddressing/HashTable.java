package closedAddressing;

import java.util.LinkedList;

public class HashTable {
    LinkedList<String>[] data;

    public HashTable(int size){
        data = new LinkedList[size];
    }

    public int hash(String name){
        int result = 0;
        for (int i=0; i<name.length(); i++){
            result += name.charAt(i);
        }
        return result% data.length;
    }

    public void insert(String name){
        int index = hash(name);
        if (data[index] == null){
            data[index] = new LinkedList<>(); //create a linked list at the index if its null
        }
        data[index].add(name); //add name to teh linked list at teh index
    }

    public boolean search(String name){
        int index = hash(name);
        if(data[index] != null){
            return data[index].contains(name);
        }
        return false;
    }

    public boolean delete(String name){
        int index = hash(name);
        if(data[index] != null){
            return data[index].remove(name);
        }
        return false;
    }

    public void print(){
        for (int i=0; i< data.length; i++){
            if(data[i] != null){
                System.out.println("Index " +i + data[i].toString());
            }
            else {
                System.out.println("Index: " +i + " null");
            }
        }
    }


    public static void main(String[] args){
        HashTable hashTable = new HashTable(100);
        hashTable.insert("Bob");
        hashTable.insert("boB");
        hashTable.insert("David");
        hashTable.insert("Charlie");
        hashTable.insert("Alice");
        hashTable.insert("Luke");
        hashTable.insert("Martha");
        hashTable.search("Charlie");
        hashTable.print();
    }
}
