/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /* 
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
			StdDraw.line(x1, y1, x2, y2);
			return;
		}
		
		// calculate the difference between the two points
		double dx = x2 - x1;
		double dy = y2 - y1;

		// calculate the 1/3 points on the line (A being 1/3 B being 2/3)
		double xa = x1 + (dx / 3);
		double ya = y1 + (dy / 3);
		double xb = x1 + 2 * (dx / 3);
		double yb = y1 + 2 * (dy / 3);

		// calculate the 'peak' between A and B (call it C)
		double xc = (Math.sqrt(3) / 2) * (ya - yb) + 0.5 * (xa + xb);
		double yc = (Math.sqrt(3) / 2) * (xb - xa) + 0.5 * (ya + yb);

		//// Write the rest of your code below. 
		curve(n - 1, x1, y1, xa, ya);   // P1 --> A
		curve(n - 1, xa, ya, xc, yc);   // A --> C
		curve(n - 1, xc, yc, xb, yb);   // C --> B
		curve(n - 1, xb, yb, x2, y2);   // B --> P2
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);

		// Draws curve on top left point to top right
		curve(n, 0.10, 0.8, 1.00, 0.8);

		// Draws curve on top right point to bottom tip
		curve(n, 1.00, 0.8, 0.55, 0.03);

		// Draws curve on bottom tip to to left
		curve(n, 0.55, 0.03, 0.10, 0.8);	
		
	}
}
