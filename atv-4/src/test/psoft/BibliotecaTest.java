package test.psoft;

import main.psoft.Biblioteca;
import main.psoft.Livro;
import main.psoft.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private Livro livro1;
    private Livro livro2;
    private Usuario usuario;

    @BeforeEach
    void setup(){
        biblioteca = new Biblioteca();
        livro1 = new Livro(1010, "livro1");
        livro2 = new Livro(2020, "l2");
        usuario = new Usuario(1, "fulano");
        biblioteca.getLivros().add(livro1);
        biblioteca.getLivros().add(livro2);
        biblioteca.getUsuarios().add(usuario);
    }

    @AfterEach
    void afterEach(){
        biblioteca = null;
        livro1 = null;
        livro2 = null;
        usuario = null;
    }

    @Test
    @DisplayName("Quando quero buscar livros pelo titulo que estão no sistema")
    public void testBuscaLivrosExistentes() {
        //Arrange
        // nada necessario alem do setup()

        //Act
        // deve retornar array de tamanho 1, contendo livro1
        List<Livro> livrosExistentes = biblioteca.getLivrosByTitulo("livro");

        //Assert
        assertEquals(livrosExistentes.size(), 1);
        assertEquals(livrosExistentes.get(0), livro1);
    }

    @Test
    @DisplayName("Quando quero buscar livros pelo titulo que não estão no sistema")
    public void testBuscaLivrosInexistentes() {
        //Arrange
        // nada necessario alem do setup()

        //Act
        // deve retornar array de tamanho 0
        List<Livro> livrosExistentes = biblioteca.getLivrosByTitulo("teste");

        //Assert
        assertEquals(livrosExistentes.size(), 0);
    }

    @Test
    @DisplayName("Quando quero listar os livros disponiveis na biblioteca")
    public void testGetLivrosDisponiveis() {
        //Arrange
        Livro livro3 = new Livro(3030, "l3");
        livro3.setDisponivel(false);
        biblioteca.getLivros().add(livro3);

        //Act
        // deve retornar array de tamanho 2, contendo livro1 e l2
        List<Livro> livrosDisponiveis = biblioteca.getLivrosDisponiveis();

        //Assert
        assertEquals(livrosDisponiveis.size(), 2);
        assertEquals(livrosDisponiveis.get(0), livro1);
        assertEquals(livrosDisponiveis.get(1), livro2);
    }

    @Test
    @DisplayName("Quando quero listar todos os livros da biblioteca")
    public void testGetLivrosCadastrados() {
        //Arrange
        Livro livro3 = new Livro(3030, "l3");
        livro3.setDisponivel(false);
        biblioteca.getLivros().add(livro3);

        //Act
        // deve retornar array de tamanho 3, contendo todos os livros adicionados
        List<Livro> livrosDisponiveis = biblioteca.getLivrosCadastrados();

        //Assert
        assertEquals(livrosDisponiveis.size(), 3);
    }

    @Test
    @DisplayName("Quando quero reservar livro com dados validos (livro disponivel e usuario cadastrado)")
    public void testReservaLivroDadosValidos() throws Exception {
        //Arrange
        // nada necessario alem do setup()

        //Act + Assert
        assertTrue(biblioteca.reservarLivro(livro2.getCod(), usuario.getCod()));
    }

    @Test
    @DisplayName("Quando quero reservar livro indisponível")
    public void testReservaLivroIndisponivel() {
        //Arrange
        Livro livro3 = new Livro(3030, "l3");
        livro3.setDisponivel(false);
        biblioteca.getLivros().add(livro3);

        //Act + Assert
        assertThrows(OperationNotSupportedException.class, () -> biblioteca.reservarLivro(livro3.getCod(), usuario.getCod()));
    }

    @Test
    @DisplayName("Quando quero reservar livro nao cadastrado")
    public void testReservaLivroInvalido() {
        //Arrange
        Livro livro3 = new Livro(3030, "l3");

        //Act + Assert
        assertThrows(OperationNotSupportedException.class, () -> biblioteca.reservarLivro(livro3.getCod(), usuario.getCod()));
    }

    @Test
    @DisplayName("Quando quero reservar livro com usuario nao cadastrado")
    public void testReservaLivroUsuarioInvalido() {
        //Arrange
        // nada necessario alem do setup()

        //Act + Assert
        assertThrows(OperationNotSupportedException.class, () -> biblioteca.reservarLivro(livro1.getCod(), 2));
    }
}