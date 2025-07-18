package boxes;

public class DoubleBox<T> {
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
