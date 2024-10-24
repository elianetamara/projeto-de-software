import java.util.List;

public class Cliente {

    private Ordenator ordenator;

    Cliente() {
        this.ordenator = new BubbleSort();
    }

    public List<Integer> ordena(List<Integer> elementos) {
        return ordenator.ordena(elementos);
    }

    public void setOrdenatorBubble() {
        this.ordenator = new BubbleSort();
    }

    public void setOrdenatorMerge() {
        this.ordenator = new MergeSort();
    }

    public void setOrdenatorInsertion() {
        this.ordenator = new InsertionSort();
    }

    public void setOrdenatorQuick() {
        this.ordenator = new QuickSort();
    }

    public Ordenator getOrdenator() {
        return ordenator;
    }
}
