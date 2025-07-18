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

//Перед вами готовый дженерик-класс RandomBox.
//В неё можно положить любой объект и ключ к нему.
class RandomBox<T> {
    private int key;
    private T value;

    public RandomBox(int key, T value) {
        this.key = key;
        this.value = value;
    }

    public T tryUnlock(int key) {
        if (this.key == key) {
            return value;
        } else {
            return null;
        }
    }

    public int getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }
}

//Вашей задачей будет реализовать дженерик-класс DoubleBox, который позволяет положить в себя
//два объекта со своими ключами. Реализовывать нужно через хранение объектов в RandomBox-ах
//(уже даны в полях).

class DoubleBox<T> {
    private RandomBox<T> first;
    private RandomBox<T> second;
    private int boxSize = 0; //Пробую сделпть то же самое через массив
    RandomBox<T>[] boxArray = new RandomBox[2];

    public boolean put(int key, T value) {
        //проверить, пустая ли первая коробка.
        if (first == null) {
            //Положить объект в коробку, если она пустая
            first = new RandomBox<>(key, value);
            boxArray[0] = first; //Дублирую это в массив, можно было обойтись без переменных
            boxSize += 1;
            return true;
        } else if (second == null) { //Иначе проверить пустая ли вторая коробка.
            //Если вторая пустая - положить объект во вторую коробку
            second = new RandomBox<>(key, value);
            boxArray[1] = second; //Дублирую это в массив, можно было обойтись без переменных
            boxSize += 1;
            return true;
        }
        return false;
    }

    public T get(int key) {
        if (first != null && first.getKey() == key) {
//            return first.tryUnlock(key);
            return boxArray[0].tryUnlock(key); //То же жействие, но через массим
        }
        if (second != null && second.getKey() == key) {
//            return second.tryUnlock(key);
            return boxArray[1].tryUnlock(key); //Тоже действие, но через массив

        }
        return null;
    }

    public int size() {
        return boxSize;
        //Или можно проверить все поля коробки.
//                if (first != null) {
//            if (second != null) {
//                return 2;
//            } else {
//                return 1;
//            }
//        } else {
//            return 0;
//        }
    }
}

//Условие задачи
//Перед вами готовый дженерик-класс RandomBox.
//В неё можно положить любой объект и ключ к нему.
//Вынуть положенный объект можно только если правильно указать ключ, иначе в ответе будет null.
//Вашей задачей будет реализовать дженерик-класс DoubleBox, который позволяет положить в себя
//два объекта со своими ключами. Реализовывать нужно через хранение объектов в RandomBox-ах
//(уже даны в полях).
//Никакие другие классы кроме DoubleBox менять нельзя. В main дана демонстрация его работы