
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main (String [] args) {
        Game g = new Game ();
        try {
            System.out.println(g.attackAt(1, 1));
            System.out.println(g.attackAt(0, 1));
            System.out.println(g.attackAt(1, 0));
            System.out.println(g.attackAt(2, 2));
            System.out.println(g.attackAt(2, 0));
            System.out.println(g.attackAt(0, 2));
            System.out.println(g.attackAt(0, 2));
            System.out.println(g.attackAt(1, 0));
            System.out.println(g.attackAt(0, 1));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        
        // System.out.println(g.player1.toString());
        // System.out.println(g.player2.toString());
    }
}
