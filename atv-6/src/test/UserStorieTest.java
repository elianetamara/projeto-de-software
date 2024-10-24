import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserStorieTest {

    private UserStorie userStorie;

    @BeforeEach
    void setUp(){
        userStorie = new UserStorie(1);
        userStorie.mover(User.DESENVOLVEDOR);
    }

    @Test
    void aprovarUsScrum(){
        userStorie.aprovar(User.SCRUM_MASTER);

        assertTrue(userStorie.isAprovada());
    }

    @Test
    void aprovarUsDev(){
        userStorie.aprovar(User.DESENVOLVEDOR);

        assertFalse(userStorie.isAprovada());
    }

    @Test
    void moverInProgressUs(){
        UserStorie userStorie1 = new UserStorie(2);
        UserStorie userStorie2 = new UserStorie(3);

        userStorie1.mover(User.SCRUM_MASTER);
        userStorie2.mover(User.DESENVOLVEDOR);

        assertInstanceOf(InProgress.class, userStorie1.getStatus());
        assertInstanceOf(InProgress.class, userStorie2.getStatus());
    }

    @Test
    void moverToVerifyUsScrum(){
        userStorie.mover(User.SCRUM_MASTER);

        assertInstanceOf(InProgress.class, userStorie.getStatus());
    }


    @Test
    void moverToVerifyUsDev(){
        userStorie.mover(User.DESENVOLVEDOR);

        assertInstanceOf(ToVerify.class, userStorie.getStatus());
    }

    @Test
    void moverDoneUsAprovadaScrum(){
        userStorie.aprovar(User.SCRUM_MASTER);
        // movendo ToVerify
        userStorie.mover(User.DESENVOLVEDOR);
        // movendo done
        userStorie.mover(User.SCRUM_MASTER);

        assertInstanceOf(Done.class, userStorie.getStatus());
    }

    @Test
    void moverDoneUsNaoAprovadaScrum(){
        // movendo ToVerify
        userStorie.mover(User.DESENVOLVEDOR);
        // movendo done
        userStorie.mover(User.SCRUM_MASTER);

        assertInstanceOf(ToDo.class, userStorie.getStatus());
    }


    @Test
    void moverDoneUsDev(){
        // movendo ToVerify
        userStorie.mover(User.DESENVOLVEDOR);
        // movendo done
        userStorie.mover(User.DESENVOLVEDOR);

        assertInstanceOf(ToVerify.class, userStorie.getStatus());
    }
}
