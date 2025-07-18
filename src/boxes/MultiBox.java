package boxes;

import java.util.ArrayList;
import java.util.List;

public class MultiBox<T> {
    List<RandomBox<T>> boxList = new ArrayList<>();

    public boolean put(int key, T value) {
            boxList.add(new RandomBox<>(key, value)); //Дублирую это в массив, можно было обойтись без переменных
            return true;
    }

    public T get(int key) {
        for (RandomBox<T> box : boxList) {
            T value = box.tryUnlock(key);
            if (value != null){
            return value;
            }
        }
        return null;

    }

    public int size() {
        return boxList.size();

    }
}
