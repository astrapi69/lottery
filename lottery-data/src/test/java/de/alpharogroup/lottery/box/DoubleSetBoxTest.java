package de.alpharogroup.lottery.box;

import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.evaluate.object.verifier.ContractVerifier;
import org.meanbean.test.BeanTester;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * The unit test class for the class {@link DoubleSetBox}
 */
public class DoubleSetBoxTest
{

	/**
	 * Test method for creation of object {@link DoubleSetBox}
	 */
	@Test
	public void testObjectCreation()
	{
		DoubleSetBox object;
		object = DoubleSetBox.builder().build();
		assertNotNull(object);
		object = new DoubleSetBox(SetFactory.newHashSet(1,2), SetFactory.newHashSet(1,2));
		assertNotNull(object);
		object = new DoubleSetBox();
		assertNotNull(object);
	}

	/**
	 * Test method for {@link DoubleSetBox}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(DoubleSetBox.class);
	}

	/**
	 * Test method for {@link DoubleSetBox#equals(Object)} , {@link DoubleSetBox#hashCode()} and
	 * {@link DoubleSetBox#toString()}
	 */
	@Test
	public void verifyEqualsHashcodeAndToStringContracts()
	{
		ContractVerifier.of(DoubleSetBox.class).verify();
	}

}
