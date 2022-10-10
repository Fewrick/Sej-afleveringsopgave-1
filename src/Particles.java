import java.util.Random;

public class Particles {
    public int x;
    public int y;
    public Particles(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void runSimulation(int n, int s, int t) {
        Random r = new Random();
        Particles[] p = new Particles[3];
        for(int i = 0; i<p.length; i++) p[i] = new Particles(r.nextInt(n), r.nextInt(n)); //initialize all particles with random position

        System.out.println("n="+n+" s="+s+" t="+t); //starting conditions

        for(int i = 1; i<=t; i++) { 
            String out = "move " + i+ ", positions ";
            for(int j = 0; j<p.length; j++) {
                p[j].move(r.nextInt(2*s+1)-s, r.nextInt(2*s+1)-s, n); //move a random amount between -s and s (inclusive) in x and y direction
                out+="P"+(j+1)+"=["+p[j].x+";"+p[j].y+"] "; //Format positions in string
            }
            System.out.println(out.substring(0, out.length()-1));
        } 

    }

    public void move(int moveX, int moveY, int n) {
        //move x
        this.x +=moveX;
        //fit within borders of grid
        this.x = Math.max(0,this.x);
        this.x = Math.min(n-1,this.x);

        //move y
        this.y +=moveY;
        this.y = Math.max(0,this.y);
        this.y = Math.min(n-1,this.y);
    }
}
