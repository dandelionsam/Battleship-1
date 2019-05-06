public class Game {
    public Player player1; 
    public Player player2; 
    private Player currentPlayer;
  
    public Game() {
        int [][] ship1 = new int [][] {{1,0},{2,0}};
        int [][] ship2 = new int [][] {{0,1},{0,2}};
        this.player1 = new Player("Player1", ship1);
        this.player2 = new Player("Player2", ship2);
        this.currentPlayer = this.player1;
    }
    
    public Player nextPlayer () {
        if (this.currentPlayer.equals(this.player1)) return this.player2;
        else return this.player1;
    }
    
    public Player.Response attackAt (int x, int y) throws Exception {
        Player p = this.nextPlayer();
        Player.Response response = p.firedAt(x, y);
        if (response.equals(Player.Response.HIT_AND_DESTROY)) {
            return response;
        }
        boolean hit = response.equals(Player.Response.HIT);
        this.currentPlayer.hittedAt(hit, x, y);
        this.currentPlayer = this.nextPlayer();
        return response;
    }   
}
