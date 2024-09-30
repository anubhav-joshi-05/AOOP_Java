package Com.Max_value_and_Min_value;
import java.util.Arrays;
import java.util.Comparator;
public interface MinMax {
	<T> T min();
    <T> T max();
}
class MinMaxImpl<T extends Comparable<T>> implements MinMax {
    private T[] array;

    public MinMaxImpl(T[] array) {
        this.array = array;
    }

    public T min() {
        return Arrays.stream(array).min(Comparator.naturalOrder()).orElse(null);
    }

    public T max() {
        return Arrays.stream(array).max(Comparator.naturalOrder()).orElse(null);
    }
}