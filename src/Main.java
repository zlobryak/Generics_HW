import boxes.DoubleBox;

public class Main {

    public static void main(String[] args) {
        DoubleBox<String> box = new DoubleBox<>();
        System.out.println("111 -> " + box.get(111)); // null
        System.out.println("SIZE: " + box.size()); // 0
        System.out.println();

        System.out.println("PUT: " + box.put(111, "First string")); // true
        System.out.println("111 -> " + box.get(111)); // First string
        System.out.println("111 -> " + box.get(22)); // null
        System.out.println("111 -> " + box.get(3333)); // null
        System.out.println("SIZE: " + box.size()); // 1
        System.out.println();

        System.out.println("PUT: " + box.put(22, "Second string")); // true
        System.out.println("111 -> " + box.get(111)); // First string
        System.out.println("111 -> " + box.get(22)); // Second string
        System.out.println("111 -> " + box.get(3333)); // null
        System.out.println("SIZE: " + box.size()); // 2
        System.out.println();

        System.out.println("PUT: " + box.put(3333, "First string")); // false
        System.out.println("111 -> " + box.get(111)); // First string
        System.out.println("111 -> " + box.get(22)); // Second string
        System.out.println("111 -> " + box.get(3333)); // null
        System.out.println("SIZE: " + box.size()); // 2
    }
}

//Вашей задачей будет реализовать дженерик-класс boxes.DoubleBox, который позволяет положить в себя
//два объекта со своими ключами. Реализовывать нужно через хранение объектов в boxes.RandomBox-ах
//(уже даны в полях).

//Условие задачи
//Перед вами готовый дженерик-класс boxes.RandomBox.
//В неё можно положить любой объект и ключ к нему.
//Вынуть положенный объект можно только если правильно указать ключ, иначе в ответе будет null.
//Вашей задачей будет реализовать дженерик-класс boxes.DoubleBox, который позволяет положить в себя
//два объекта со своими ключами. Реализовывать нужно через хранение объектов в boxes.RandomBox-ах
//(уже даны в полях).
//Никакие другие классы кроме boxes.DoubleBox менять нельзя. В main дана демонстрация его работы