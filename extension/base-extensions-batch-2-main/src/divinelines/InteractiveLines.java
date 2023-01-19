package divinelines;

import edu.princeton.cs.introcs.StdDraw;

public class InteractiveLines {

	public static void main(String[] args) {
		
		StdDraw.text(0.5, 0.9, "Press and drag the mouse.");
		StdDraw.text(0.5, 0.85, "A line will be drawn when you release.");
		while (true) {
			//
			// Wait for the mousebutton to be pressed
			//
			while (!StdDraw.isMousePressed()) {
				// wait, do nothing
				StdDraw.pause(10);
			}
			//
			// Capture the mouse's location is now that is has been pressed
			//
			double x1 = StdDraw.mouseX();
			double y1 = StdDraw.mouseY();
			//
			// Now wait for the button to be released
			//
			while (StdDraw.isMousePressed()) {
				// wait, do nothing
				StdDraw.pause(10);
			}
			//
			// Capture the mouse's location now that it has been released
			//
			double x2 = StdDraw.mouseX();
			double y2 = StdDraw.mouseY();

			//
			// Run the student's code to draw the line
			//
			Lines.drawLine(x1, y1, x2, y2);

		}

	}

}
