public class Main {
    public static void main(String[] args) {
        showInfo();
        NHashTable<String, String> dictionary = new NHashTable<>();
        dictionary.put("Apple", "Яблоко");
        dictionary.put("Banana", "Банан");
        dictionary.put("Candy", "Конфета");
        dictionary.put("Deep", "Глубокий");
        dictionary.put("Excellent", "Отличный");
        dictionary.print();
        System.out.println(dictionary.contains("Отличный"));
        System.out.println(dictionary.contains("Яблоко"));
        System.out.println(dictionary.contains("Лилия"));
        System.out.println(dictionary.getKey("Отличный"));
    }
    public static void showInfo(){
        System.out.println("#==================================================#");
        System.out.println("# Hash table and binary search tree implementation #");
        System.out.println("# Made by Nariman Almanov                          #");
        System.out.println("# 2022                                             #");
        System.out.println("#==================================================#");
    }
}