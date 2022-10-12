import java.util.*;

public class ParticlesWithCollide {
    public int x;
    public int y;

    public ParticlesWithCollide(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void runSimulation(int n, int s, int t) {
        Random r = new Random();
        Particles[] p = new Particles[2];
        for (int i = 0; i < p.length; i++)
            p[i] = new Particles(r.nextInt(n), r.nextInt(n)); // initialize all particles with random position

        System.out.println("n=" + n + " s=" + s + " t=" + t); // print starting conditions

        for (int i = 1; i <= t; i++) { // t number of times
            String out = "move " + i + ", positions ";
            for (int j = 0; j < p.length; j++) {
                p[j].move(r.nextInt(2 * s + 1) - s, r.nextInt(2 * s + 1) - s, n); // for all particles move a random
                                                                                  // amount between -s and s (inclusive)
                                                                                  // in x and y direction
                out += "P" + (j + 1) + "=[" + p[j].x + ";" + p[j].y + "] "; // Format positions in string
            }

            System.out.println(out.substring(0, out.length() - 1));

            if ((p[0].x == p[1].x) && (p[0].y == p[1].y)) { // if statement that checks wether the position of p1 is equal to that of p2
                System.out.println("particles collide");
                for (int j = i + 1; j <= t; j++) { // Output is only the position of p1
                    out = "move " + j + ", positions ";
                    p[0].move(r.nextInt(2 * s + 1) - s, r.nextInt(2 * s + 1) - s, n);
                    out += "P" + 1 + "=[" + p[0].x + ";" + p[0].y + "] ";
                    System.out.println(out.substring(0, out.length() - 1));
                }
                break; // breaks the "for i" loop
            }
        }

    }
}
