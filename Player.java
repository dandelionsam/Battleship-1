
import java.util.Objects;

public class Player {
    private String name;
    private int[][] personalGrid;
    private int[][] versusGrid;
    private int[][] ship;
    public enum Response {
        HIT,
        MISS,
        HIT_AND_DESTROY
    }


    public Player(String name, int[][] ship) {
        this.name = name;
        this.personalGrid = new int[3][3];
        this.versusGrid = new int[3][3];
        this.ship = ship;
    }
    
    public Response firedAt (int x, int y) throws Exception {
        if(x<0 || x>this.personalGrid.length || y<0 || y>this.personalGrid.length) throw new Exception("Invalid coordinate");
        for (int i=0; i<2; i++) {
            if (ship[i][0]==x && ship[i][1]==y) {
                personalGrid[x][y]=1;
                return shipDestroyed() ? Response.HIT_AND_DESTROY : Response.HIT;
            }
        }
        personalGrid[x][y]=-1;
        return Response.MISS;
    }
    public boolean shipDestroyed (){
        int counter=0;
        for(int i=0; i<this.ship.length;i++){
            int [] coords= this.ship[i];
            counter += this.personalGrid[coords[0]][coords[1]];
        }
        return counter==this.ship.length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    public void hittedAt (boolean hit, int x, int y) {
        this.versusGrid[x][y] = hit ? 1 : -1;
    }

    @Override
    public String toString() {
        String s = "";
        
        for (int i=this.personalGrid.length-1; i>=0; i--) {
            for (int j=0; j<this.personalGrid[i].length; j++) {
                s+="| "+this.personalGrid[i][j]+" |";
            }
            s+="\n";
        }
        
        s+="\n\n";
        
        for (int i=this.versusGrid.length-1; i>=0; i--) {
            for (int j=0; j<this.versusGrid[i].length; j++) {
                s+="| "+this.versusGrid[i][j]+" |";
            }
            s+="\n";
        }
        
        return s;             
    }
    
    
}
