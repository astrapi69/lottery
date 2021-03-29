/**
 * Commercial License
 *
 * Copyright (C) 2015 Asterios Raptis - All Rights Reserved
 *
 * Proprietary and confidential
 *
 * Unauthorized copying of this software and its files,
 * via any medium is strictly prohibited
 *
 * Written by Asterios Raptis
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package de.alpharogroup.lottery.drawings;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

/**
 * The unit test class for the class {@link DrawModelBean}
 */
public class DrawModelBeanTest
{

	/**
	 * Test method for creation of object {@link DrawModelBean}
	 */
	@Test
	public void testObjectCreation()
	{
		DrawModelBean object;
		object = DrawModelBean.builder().build();
		assertNotNull(object);
		object = DrawModelBean.builder().maxNumbers(6).minVolume(1).maxVolume(49).build();
		assertNotNull(object);
	}

}
