package conway;

public class Patterns {
	public static void yourDesignOne(Conway conway) {

		// TODO

	}

	public static void yourDesignTwo(Conway conway) {

		// TODO

	}

	public static void blinker(Conway conway) {
		conway.clear();
		conway.setAlive(true, 1, 0);
		conway.setAlive(true, 1, 1);
		conway.setAlive(true, 1, 2);
	}

	public static void toad(Conway conway) {
		conway.clear();
		conway.setAlive(true, 2, 2);
		conway.setAlive(true, 2, 3);
		conway.setAlive(true, 2, 4);
		conway.setAlive(true, 3, 1);
		conway.setAlive(true, 3, 2);
		conway.setAlive(true, 3, 3);
	}

	public static void beacon(Conway conway) {
		conway.clear();
		conway.setAlive(true, 1, 1);
		conway.setAlive(true, 1, 2);
		conway.setAlive(true, 2, 1);
		conway.setAlive(true, 3, 4);
		conway.setAlive(true, 4, 3);
		conway.setAlive(true, 4, 4);
	}

	public static void fourBlinkers(Conway conway) {
		conway.clear();
		for (int i = 3; i < 6; i++) {
			for (int j = 3; j < 6; j++) {
				conway.setAlive(true, i, j);
			}
		}
	}

	public static void gosperGliderGun(Conway conway) {
		conway.clear();
		conway.setAlive(true, 0, 27);
		conway.setAlive(true, 1, 25);
		conway.setAlive(true, 1, 27);
		conway.setAlive(true, 2, 15);
		conway.setAlive(true, 2, 16);
		conway.setAlive(true, 2, 23);
		conway.setAlive(true, 2, 24);
		conway.setAlive(true, 2, 37);
		conway.setAlive(true, 2, 38);
		conway.setAlive(true, 3, 14);
		conway.setAlive(true, 3, 18);
		conway.setAlive(true, 3, 23);
		conway.setAlive(true, 3, 24);
		conway.setAlive(true, 3, 37);
		conway.setAlive(true, 3, 38);
		conway.setAlive(true, 4, 3);
		conway.setAlive(true, 4, 4);
		conway.setAlive(true, 4, 13);
		conway.setAlive(true, 4, 19);
		conway.setAlive(true, 4, 23);
		conway.setAlive(true, 4, 24);
		conway.setAlive(true, 5, 3);
		conway.setAlive(true, 5, 4);
		conway.setAlive(true, 5, 13);
		conway.setAlive(true, 5, 17);
		conway.setAlive(true, 5, 19);
		conway.setAlive(true, 5, 20);
		conway.setAlive(true, 5, 25);
		conway.setAlive(true, 5, 27);
		conway.setAlive(true, 6, 13);
		conway.setAlive(true, 6, 19);
		conway.setAlive(true, 6, 27);
		conway.setAlive(true, 7, 14);
		conway.setAlive(true, 7, 18);
		conway.setAlive(true, 8, 15);
		conway.setAlive(true, 8, 16);
	}

	public static void glider(Conway conway) {
		conway.clear();
		conway.setAlive(true, 1, 1);
		conway.setAlive(true, 1, 3);
		conway.setAlive(true, 2, 2);
		conway.setAlive(true, 2, 3);
		conway.setAlive(true, 3, 2);
	}
}
