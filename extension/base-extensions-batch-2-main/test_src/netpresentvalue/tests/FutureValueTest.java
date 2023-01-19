package netpresentvalue.tests;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import netpresentvalue.NPV;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class FutureValueTest {
	private final double dollars;
	private final int years;
	private final double r;
	private final double expected;

	public FutureValueTest(double dollars, int years, double r, double expected) {
		this.dollars = dollars;
		this.years = years;
		this.r = r;
		this.expected = expected;
	}

	@Test
	public void test() {
		double actual = NPV.futureValue(dollars, years, r);
		assertEquals(expected, actual, expected*0.0000001);
	}

	@Parameterized.Parameters(name = "dollars: {0}; years: {1}; r: {2}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();
		
		// specific cases
		args.add(new Object[] {1.0, 50, 0.1, 117.39085287969579});

		// random cases
		args.add(new Object[] {106.63556803351626, 7, 0.7341231744587554, 5028.768941234642});
		args.add(new Object[] {1247.7360495442401, 23, 0.09731015939590448, 10560.851247470742});
		args.add(new Object[] {4591.434589214084, 12, 0.42965508252374196, 334752.37910623394});
		args.add(new Object[] {3481.937655982902, 71, 0.9710334440766812, 2.918062027999043E24});
		args.add(new Object[] {2384.8655638668824, 69, 0.1404020600404957, 2.0628394595428605E7});
		args.add(new Object[] {4357.828688446819, 75, 0.16244762384702416, 3.48557723377557E8});
		args.add(new Object[] {3111.1493166595096, 65, 0.779244858111981, 5.7311611148399575E19});
		args.add(new Object[] {8883.165974462112, 24, 0.09179304354729168, 73103.0546621446});
		args.add(new Object[] {9043.958535185433, 69, 0.6700447006799354, 2.1115295601561747E19});
		args.add(new Object[] {6814.575040508218, 67, 0.4743265196567973, 1.3465273326972105E15});
		args.add(new Object[] {288.7699683011158, 12, 0.020014930556094823, 366.294477636696});
		args.add(new Object[] {4732.348836806679, 39, 0.15229703086615332, 1191488.9554496652});
		args.add(new Object[] {2266.91360780193, 21, 0.5455688795635529, 2.119779190737431E7});
		args.add(new Object[] {98.50301739472656, 52, 0.7058175115518168, 1.1322519952236247E14});
		args.add(new Object[] {3665.29101855237, 57, 0.6021713893031667, 1.7081258733179345E15});
		args.add(new Object[] {3050.2652015459544, 30, 0.5924888487755586, 3.520704681666996E9});

		return args;
	}
}

