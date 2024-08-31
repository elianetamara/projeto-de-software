import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class ClienteTest {

    private Cliente cliente;

    private List<Integer> elemen;

    @BeforeEach
    void setup(){
        cliente = new Cliente();
        elemen = new ArrayList<>();
        elemen.add(1);
    }

    @Test
    @DisplayName("Ordenação padrão da criação de uma instância de cliente")
    public void testOrdenacaoPadrao(){
        // arrange + act
        // nada necessario alem do setup()

        // assert
        assertInstanceOf(BubbleSort.class, cliente.getOrdenator());
        assertEquals(elemen, cliente.ordena(elemen));
    }

    @Test
    @DisplayName("Troca de ordenação em tempo de execução")
    public void testTrocaOrdenacao(){
        // arrange

        // act + assert
        assertInstanceOf(BubbleSort.class, cliente.getOrdenator());
        assertEquals(elemen, cliente.ordena(elemen));

        cliente.setOrdenatorQuick();
        assertInstanceOf(QuickSort.class, cliente.getOrdenator());
        assertEquals(elemen, cliente.ordena(elemen));

        cliente.setOrdenatorInsertion();
        assertInstanceOf(InsertionSort.class, cliente.getOrdenator());
        assertEquals(elemen, cliente.ordena(elemen));
    }

    @Test
    @DisplayName("Tipo de ordenação: merge sort")
    public void testMergeSort(){
        // arrange
        cliente.setOrdenatorMerge();

        // act nao necessario

        // assert
        assertInstanceOf(MergeSort.class, cliente.getOrdenator());
        assertEquals(elemen, cliente.ordena(elemen));
    }

    @Test
    @DisplayName("Tipo de ordenação: insertion sort")
    public void testInsertionSort(){
        // arrange
        cliente.setOrdenatorInsertion();

        // act nao necessario

        // assert
        assertInstanceOf(InsertionSort.class, cliente.getOrdenator());
        assertEquals(elemen, cliente.ordena(elemen));
    }

    @Test
    @DisplayName("Tipo de ordenação: quick sort")
    public void testQuickSort(){
        // arrange
        cliente.setOrdenatorQuick();

        // act nao necessario

        // assert
        assertInstanceOf(QuickSort.class, cliente.getOrdenator());
        assertEquals(elemen, cliente.ordena(elemen));
    }

    @Test
    @DisplayName("Tipo de ordenação: bubble sort")
    public void testBubbleSort(){
        // arrange
        cliente.setOrdenatorBubble();

        // act nao necessario

        // assert
        assertInstanceOf(BubbleSort.class, cliente.getOrdenator());
        assertEquals(elemen, cliente.ordena(elemen));
    }

}
