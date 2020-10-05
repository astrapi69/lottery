package de.alpharogroup.lottery.box;

import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.evaluate.object.verifier.ContractVerifier;
import de.alpharogroup.lottery.enums.LotteryGameType;
import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * The unit test class for the class {@link EurojackpotBox}
 */
public class EurojackpotBoxTest
{

	/**
	 * Test method for creation of object {@link EurojackpotBox}
	 */
	@Test
	public void testObjectCreation()
	{
		EurojackpotBox object;
		object = EurojackpotBox.builder().build();
		assertNotNull(object);
		object = new EurojackpotBox(SetFactory.newHashSet(1,2), SetFactory.newHashSet(1,2));
		assertNotNull(object);
		object = new EurojackpotBox();
		assertNotNull(object);
	}

	/**
	 * Test method for {@link EurojackpotBox}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(EurojackpotBox.class);
	}

	/**
	 * Test method for {@link EurojackpotBox#equals(Object)} , {@link EurojackpotBox#hashCode()} and
	 * {@link EurojackpotBox#toString()}
	 */
	@Test
	public void verifyEqualsHashcodeAndToStringContracts()
	{
		ContractVerifier.of(EurojackpotBox.class).verify();
	}

}
