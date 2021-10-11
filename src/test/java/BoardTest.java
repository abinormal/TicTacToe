import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class BoardTest {

    Board gameBoard = new Board();

    @Test
    public void checkMove(){
        gameBoard.makeMove();

        assertEquals(true, false);
    }

}
