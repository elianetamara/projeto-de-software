import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScrumBoardTest {

    private ScrumBoard scrumBoard;

    @BeforeEach
    void setUp(){
        scrumBoard = new ScrumBoard();
        scrumBoard.addUs(1);
        scrumBoard.addUs(2);
        scrumBoard.addUs(3);
        scrumBoard.addUs(4);
    }

    @Test
    void testAdicionarUSValida(){
        assertTrue(scrumBoard.addUs(5));
    }

    @Test
    void testAdicionarUSRepetida(){
        assertThrows(UnsupportedOperationException.class, () -> scrumBoard.addUs(1));
    }

    @Test
    void testRemoverUSValida(){
        assertTrue(scrumBoard.removeUs(1));
    }

    @Test
    void testRemoverUSInexistente(){
        assertThrows(UnsupportedOperationException.class, () -> scrumBoard.removeUs(100));
    }

    @Test
    void testGetUSValida(){
        UserStorie userStorie = new UserStorie(1);

        UserStorie resultado = scrumBoard.getUsById(1);
        assertEquals(resultado, userStorie);
    }

    @Test
    void testGetUSInexistente(){
        assertNull(scrumBoard.getUsById(100));
    }

    @Test
    void testMoverUSValida(){
        scrumBoard.moverUs(1, User.DESENVOLVEDOR);
        assertInstanceOf(InProgress.class, scrumBoard.getUsById(1).getStatus());
    }

    @Test
    void testMoverUSInexistente(){
        assertThrows(UnsupportedOperationException.class, () -> scrumBoard.moverUs(100, User.DESENVOLVEDOR));
    }

    @Test
    void testAprovarUSValida(){
        scrumBoard.aprovarUs(1, User.SCRUM_MASTER);
        assertTrue(scrumBoard.getUsById(1).isAprovada());
    }

    @Test
    void testAprovarUSInexistente(){
        assertThrows(UnsupportedOperationException.class, () -> scrumBoard.moverUs(100, User.SCRUM_MASTER));
    }


}
