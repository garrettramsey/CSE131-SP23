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
public class NetPresentValueTest {
	private final double investment;
	private final int years;
	private final double payout;
	private final double r;
	private final double expected;

	public NetPresentValueTest(double investment, int years, double payout, double r, double expected) {
		this.investment = investment;
		this.years = years;
		this.payout = payout;
		this.r = r;
		this.expected = expected;
	}

	@Test
	public void test() {
		double actual = NPV.netPresentValue(investment, years, payout, r);
		assertEquals(expected, actual, 0.0001);
	}

	@Parameterized.Parameters(name = "investment: {0}; years: {1}; payout: {2}; r: {3}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();
		
		// specific cases
		args.add(new Object[] {10000.0, 50, 1000.0, 0.1, -85.18551279501565});

		// random cases
		args.add(new Object[] {4349.530327846675, 26, 4796.891712505966, 0.3318049524718707, 10099.025435674354});
		args.add(new Object[] {5534.095195068509, 45, 1035.8591934367628, 0.4680446212070971, -3320.9319324420317});
		args.add(new Object[] {4924.318489738448, 99, 3803.411118713666, 0.8799386562976776, -601.9590940091665});
		args.add(new Object[] {7448.321186329659, 73, 1342.1961856750581, 0.7467521977828894, -5650.9428998511685});
		args.add(new Object[] {5979.413279248966, 21, 2576.334290570803, 0.894701210458181, -3099.8704382195006});
		args.add(new Object[] {8643.822807987173, 98, 55.13649688144162, 0.27464882131342905, -8443.07009179062});
		args.add(new Object[] {5076.3675626810955, 58, 4892.117470196367, 0.5510551361950669, 3801.360179650756});
		args.add(new Object[] {1958.3521100184553, 33, 2415.193425294568, 0.12693518153510586, 16699.90294284558});
		args.add(new Object[] {1065.156295439903, 26, 424.07405483443904, 0.5078406167384852, -230.12210562443835});
		args.add(new Object[] {6484.024281103701, 72, 4789.468190667866, 0.06871096837687629, 62638.006143298546});
		args.add(new Object[] {3209.526814774468, 26, 2549.3175336425334, 0.7612597246237096, 139.2862328666894});
		args.add(new Object[] {129.33953426718102, 98, 3793.6841196016508, 0.536121818943894, 6946.821117196003});
		args.add(new Object[] {5233.360365972562, 95, 1258.662658644737, 0.16579546016157076, 2358.295446007722});
		args.add(new Object[] {6863.866912181104, 61, 1072.4786834009358, 0.5462600565640056, -4900.555352950851});
		args.add(new Object[] {9677.930427563713, 32, 830.2172236526245, 0.015074982531030456, 11275.692135440857});
		args.add(new Object[] {2826.61339537472, 44, 2781.662681015015, 0.9469668936456899, 110.83109152332545});

		return args;
	}
}
