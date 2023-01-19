package assignment9;

import java.util.Scanner;

import assignment9.scenes.Bubbles;
import assignment9.scenes.Clear;
import assignment9.scenes.Forest;
import assignment9.scenes.Leaves;
import edu.princeton.cs.introcs.StdDraw;

public class SceneComposer {



	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		// Note: Double Buffering is enabled!  
		//       You'll need to call show() to update the screen.
		//       In most cases you'll want to call show() after you've drawn something
		StdDraw.enableDoubleBuffering();
		
		
		//
		// for demo only, remove this code and write your own to do what
		//   is needed for this assignment
		while(true) {
			StdDraw.show();
			StdDraw.pause(10);
			for (int i=0; i < 10; ++i) {
				Forest f = new Forest(5);
				f.draw(); f.draw(); f.draw(); f.draw();
				Leaves l = new Leaves(5);
				l.draw(); l.draw();
			}
			Bubbles b = new Bubbles(10);
			b.draw();
			StdDraw.show();
			StdDraw.pause(10);
			System.out.println("Again?");
			String resp = in.nextLine();
			if (resp.equals("no")) {
				break;
			}
			else {
				new Clear().draw();
			}
		}
		//
		// end of demo code
		//
	}

}
