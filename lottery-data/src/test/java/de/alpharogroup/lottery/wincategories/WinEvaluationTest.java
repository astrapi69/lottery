package de.alpharogroup.lottery.wincategories;

import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.evaluate.object.verifier.ContractVerifier;
import de.alpharogroup.lottery.box.DoubleSetBox;
import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * The unit test class for the class {@link WinEvaluation}
 */
public class WinEvaluationTest
{

	/**
	 * Test method for creation of object {@link WinEvaluation}
	 */
	@Test
	public void testObjectCreation()
	{
		WinEvaluation object;
		object = WinEvaluation.builder().build();
		assertNotNull(object);
		object = new WinEvaluation<LotteryWinCategory>(2.0, LotteryWinCategory.EIGHTH_CLASS);
		assertNotNull(object);
		object = new WinEvaluation<LotteryWinCategory>();
		assertNotNull(object);
	}

}
