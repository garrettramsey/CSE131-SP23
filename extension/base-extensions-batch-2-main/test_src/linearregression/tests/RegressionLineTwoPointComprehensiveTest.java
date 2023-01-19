package linearregression.tests;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import linearregression.RegressionLine;
import linearregression.XY;
import test.cse131.UnitTestUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class RegressionLineTwoPointComprehensiveTest {
	private final XY a;
	private final XY b;
	private final double expectedSlope;
	private final double expectedIntercept;

	public RegressionLineTwoPointComprehensiveTest(XY a, XY b, double expectedSlope, double expectedIntercept) {
		super();
		this.a = a;
		this.b = b;
		this.expectedSlope = expectedSlope;
		this.expectedIntercept = expectedIntercept;
	}

	@Test
	public void test() {
		RegressionLine regressionLine = new RegressionLine();
		regressionLine.accept(a);
		regressionLine.accept(b);
		assertEquals(expectedSlope, regressionLine.getSlope(), UnitTestUtils.reasonableDelta());
		assertEquals(expectedIntercept, regressionLine.getIntercept(), UnitTestUtils.reasonableDelta());
	}

	@Parameterized.Parameters(name = "{0}, {1}")
	public static Collection<Object[]> getConstructorArguments() {
		Collection<Object[]> args = new LinkedList<>();
		
		// specific point on y axis cases
		args.add(new Object[] {new XY(0.0, 0.0), new XY(1.0, 0.0), 0.0, 0.0});
		args.add(new Object[] {new XY(0.0, 0.0), new XY(1.0, 1.0), 1.0, 0.0});
		args.add(new Object[] {new XY(0.0, 0.0), new XY(1.0, 2.0), 2.0, 0.0});
		args.add(new Object[] {new XY(0.0, 0.0), new XY(2.0, 1.0), 0.5, 0.0});
		args.add(new Object[] {new XY(0.0, 1.0), new XY(1.0, 1.0), 0.0, 1.0});
		args.add(new Object[] {new XY(0.0, 1.0), new XY(2.0, 1.0), 0.0, 1.0});
		args.add(new Object[] {new XY(0.0, 1.0), new XY(2.0, -1.0), -1.0, 1.0});

		// random point on y axis cases
		args.add(new Object[] {new XY(0.0, -1.3009393443066486), new XY(-6.08040602225711, 4.229159752072377), -0.9094950363736065, -1.300939344306649});
		args.add(new Object[] {new XY(0.0, -1.4007751484484903), new XY(-6.382187760074773, -5.856563226252948), 0.6981599798236355, -1.4007751484484907});
		args.add(new Object[] {new XY(0.0, -0.6391075758580573), new XY(-0.15136302052310313, -2.2684509275310605), 10.764474348107434, -0.6391075758580576});
		args.add(new Object[] {new XY(0.0, 8.007373177986935), new XY(2.276472075233496, -2.9565683814033488), -4.8161985726382, 8.007373177986935});
		args.add(new Object[] {new XY(0.0, -4.631215257299768), new XY(4.935043955657788, 1.9588265584979325), 1.335356255184422, -4.631215257299768});
		args.add(new Object[] {new XY(0.0, 9.381961678048032), new XY(0.09781029662525498, 7.065468986148318), -23.68352588454973, 9.381961678048032});
		args.add(new Object[] {new XY(0.0, 8.522618448060761), new XY(-9.779454012474233, -4.507023573731419), 1.332348616310497, 8.522618448060761});
		args.add(new Object[] {new XY(0.0, 0.15273512536219158), new XY(-0.362455851309452, -6.082271769328374), 17.202114056553988, 0.15273512536219203});
		args.add(new Object[] {new XY(0.0, -6.171675564099786), new XY(0.8306833270638059, -0.3392262988217283), 7.021266799580364, -6.171675564099786});
		args.add(new Object[] {new XY(0.0, -7.461296369297883), new XY(-7.8696874091201945, 5.890164698605179), -1.6965681575141132, -7.461296369297884});
		args.add(new Object[] {new XY(0.0, 2.2872518026353745), new XY(7.647582783818969, -2.6934278673323213), -0.6512750251629832, 2.2872518026353745});
		args.add(new Object[] {new XY(0.0, 9.157872762671463), new XY(-8.625780632462474, -3.5809463704510636), 1.4768308720002619, 9.157872762671463});
		args.add(new Object[] {new XY(0.0, -7.5222407252003265), new XY(4.63212900199286, -3.4310004076558513), 0.8832310835437267, -7.5222407252003265});
		args.add(new Object[] {new XY(0.0, 8.429919184025646), new XY(5.174736478406603, 0.7224363788778803), -1.4894445035626322, 8.429919184025646});
		args.add(new Object[] {new XY(0.0, 0.4667207319451254), new XY(9.744890109220904, -5.276527653397487), -0.5893599949278219, 0.46672073194512587});
		args.add(new Object[] {new XY(0.0, 9.756005610938875), new XY(-7.752676339869606, -5.7100852663962565), 1.9949357098525873, 9.756005610938875});

		// random cases
		args.add(new Object[] {new XY(0.9252011312801116, 9.355860855127425), new XY(-0.9111526113619117, 9.010246102534229), 0.18820706738993986, 9.18173146346334});
		args.add(new Object[] {new XY(9.049545908767385, -2.1384393986180106), new XY(1.1266507240600614, 8.939337872913796), -1.3981981350597694, 10.514618814158313});
		args.add(new Object[] {new XY(7.1934595145122735, 4.654944644473218), new XY(8.325869935602839, -8.941423940070123), -12.006573174635127, 91.02374268424006});
		args.add(new Object[] {new XY(1.2189925108889774, 8.069750448698997), new XY(8.357090890108413, -8.293239796311626), -2.29234585679666, 10.864102880501502});
		args.add(new Object[] {new XY(9.768068227172808, -1.4946663027319431), new XY(3.4128485215159863, -8.697852165691096), 1.1334282993469997, -12.566071261361882});
		args.add(new Object[] {new XY(7.262574632298048, 2.431140911394607), new XY(0.8752348221773474, -7.731210154802721), 1.5910146271058174, -9.12372155903924});
		args.add(new Object[] {new XY(-3.6667328553503094, -5.840016347270758), new XY(7.842549897316399, 1.3127790511762747), 0.6214805520169989, -3.5612131882287805});
		args.add(new Object[] {new XY(-7.218884388934432, 6.584573358282714), new XY(2.745588979003422, -4.4270401211492665), -1.1050873511151582, -1.3929244690914042});
		args.add(new Object[] {new XY(-4.040113623590347, 9.513181974576877), new XY(-1.3681932488642445, 3.6745296032238386), -2.185189508857109, 0.6847680697165694});
		args.add(new Object[] {new XY(-4.621084411338532, -5.193302550526441), new XY(-7.831729517459607, 7.342887829949298), -3.904570566387293, -23.236652727830034});
		args.add(new Object[] {new XY(-9.639825967779323, -8.789248935524396), new XY(-9.988047746693201, 6.988985924846894), -45.31087891626245, -445.5782361354163});
		args.add(new Object[] {new XY(-6.256107548396528, 8.593000182846403), new XY(-0.08141465693149108, -4.443661994974155), -2.111305356715064, -4.615553196268732});
		args.add(new Object[] {new XY(-7.077839058877062, 1.2370570377942691), new XY(7.8089494016293095, 8.923758769503), 0.5163438542907373, 4.891655737504376});
		args.add(new Object[] {new XY(-8.109920253133748, 2.910953047542881), new XY(-6.015882284909477, 8.286807848894867), 2.567219354628349, 23.730897285880285});
		args.add(new Object[] {new XY(-3.460805066782198, 2.619451006866381), new XY(-8.221153843537913, 0.1948142011649896), 0.5093401595993633, 4.38217801192351});
		args.add(new Object[] {new XY(-7.921898596625205, -0.7340985152923025), new XY(0.16495286618532745, -6.70073328741271), -0.7378192612488943, -6.579027885542963});

		return args;
	}
}
