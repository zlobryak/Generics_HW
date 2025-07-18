package boxes;

import java.util.ArrayList;
import java.util.List;

public class DoubleBox<T> {
    private RandomBox<T> first;
    private RandomBox<T> second;
    private int boxSize = 0;
    List<RandomBox<T>> boxList = new ArrayList<>();

    public boolean put(int key, T value) {
        //проверить, пустая ли первая коробка.
        if (first == null && boxList.isEmpty()) {
            //Положить объект в коробку, если она пустая
            first = new RandomBox<>(key, value);
            boxList.add(first); //Дублирую это в массив, можно было обойтись без переменных
            boxSize += 1;
            return true;
        } else if (second == null && boxList.contains(first)) { //Иначе проверить пустая ли вторая коробка.
            //Если вторая пустая - положить объект во вторую коробку
            second = new RandomBox<>(key, value);
            boxList.add(second); //Дублирую это в массив, можно было обойтись без переменных
            boxSize += 1;
            return true;
        }
        return false;
    }

    public T get(int key) {
        if (first != null && first.getKey() == key) {
//            return first.tryUnlock(key);
            return boxList.get(0).tryUnlock(key); //То же действие, но через массив
        }
        if (second != null && second.getKey() == key) {
//            return second.tryUnlock(key);
            return boxList.get(1).tryUnlock(key); //То же действие, но через массив
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
