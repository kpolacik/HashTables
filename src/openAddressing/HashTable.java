package openAddressing;

import java.util.Objects;

public class HashTable {
    String[] data;

    public HashTable(int size){
        data = new String[size];
    }


    public int hash(String name){
        int result = 0;
        for (int i=0; i<name.length(); i++){
            result += name.charAt(i);
        }
        return result % data.length;
    }

    public void insert(String name){
        int index = hash(name);
        if (data[index] == null){
            data[index] = name;
        }
        else{
            while(data[index] != null){
                index = (index+1)% data.length;
                if (index == hash(name)){
                    System.out.println("Hash table is full, Cannot insert " + name);
                    break;
                }
            }
            data[index] = name;
        }
    }

    public boolean search(String name){
        int index = hash(name);
        if(Objects.equals(data[index], name)){
            return true;
        }
        else {
            while(!Objects.equals(data[index], name)){
                index = (index+1)% data.length;
                if (index == hash(name)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean delete(String name){
        int index = hash(name);
        if(Objects.equals(data[index], name)){
            data[index] = null;
        }
        else {
            while(!Objects.equals(data[index], name)) {
                index = (index+1)% data.length;
                if (index == hash(name)){
                    return false;
                }
            }
        }
        data[index] = null;
        return true;
    }

    public void print(){
        for (int i=0; i< data.length; i++){
            if(data[i] != null){
                System.out.println("Index " +i + " " + data[i].toString());
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
        System.out.println(hashTable.search("David"));
        System.out.println(hashTable.search("boB"));
    }

}
