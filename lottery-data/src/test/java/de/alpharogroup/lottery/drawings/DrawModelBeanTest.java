package de.alpharogroup.lottery.drawings;

import de.alpharogroup.evaluate.object.verifier.ContractVerifier;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * The unit test class for the class {@link DrawModelBean}
 */
public class DrawModelBeanTest {

    /**
     * Test method for creation of object {@link DrawModelBean}
     */
    @Test
    public void testObjectCreation()
    {
        DrawModelBean object;
        object = DrawModelBean.builder().build();
        assertNotNull(object);
        object = DrawModelBean.builder()
                .maxNumbers(6)
                .minVolume(1)
                .maxVolume(49)
                .build();
        assertNotNull(object);
    }

}
