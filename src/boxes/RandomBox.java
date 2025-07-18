package boxes;

//Перед вами готовый дженерик-класс RandomBox.
//В неё можно положить любой объект и ключ к нему.
public class RandomBox<T> {
    private final int key;
    private final T value;

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
