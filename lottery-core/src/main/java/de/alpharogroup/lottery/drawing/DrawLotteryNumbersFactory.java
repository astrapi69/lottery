package de.alpharogroup.lottery.drawing;

import de.alpharogroup.collections.list.ListFactory;
import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.random.DefaultSecureRandom;
import de.alpharogroup.random.number.RandomIntFactory;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class DrawLotteryNumbersFactory {

    /**
     * Draw of lottery numbers.
     *
     * @param maxNumbers
     *            the max number to draw
     * @param volume
     *            the volume of the numbers starts from 1 till volume
     * @return the sets the
     */
    public static Set<Integer> draw(int maxNumbers, int volume, SecureRandom secureRandom)
    {
        Set<Integer> numbers = SetFactory.newTreeSet();
        int cnt = 0;
        while (cnt < maxNumbers)
        {
            final int num = RandomIntFactory.randomIntBetween(1, volume, secureRandom);

            if (!numbers.contains(num))
            {
                numbers.add(num);
                ++cnt;
            }
        }
        return numbers;
    }

    /**
     * Draw of lottery numbers.
     *
     * @param maxNumbers
     *            the maximum of numbers to draw
     * @param minVolume
     *            the min volume
     * @param maxVolume
     *            the max volume
     * @return the sets of the drawn numbers
     */
    public static Set<Integer> draw(int maxNumbers, int minVolume, int maxVolume, SecureRandom secureRandom)
    {
        Set<Integer> numbers = SetFactory.newTreeSet();
        int cnt = 0;
        while (cnt < maxNumbers)
        {
            final int num = RandomIntFactory.randomIntBetween(minVolume, maxVolume, true,
                    true, secureRandom);
            if (!numbers.contains(num))
            {
                numbers.add(num);
                ++cnt;
            }
        }
        return numbers;
    }

    /**
     * Draw of lottery numbers.
     *
     * @param maxNumbers
     *            the maximum of numbers to draw
     * @param minVolume
     *            the min volume
     * @param maxVolume
     *            the max volume
     * @return the sets of the drawn numbers
     */
    public static Set<Integer> drawWithShuffle(int maxNumbers, int minVolume, int maxVolume, SecureRandom secureRandom)
    {
        Set<Integer> numbers = SetFactory.newTreeSet();
        ArrayList<Integer> rangeList = new ArrayList<>(
                ListFactory.newRangeList(minVolume, maxVolume));
        int cnt = 0;
        while (cnt < maxNumbers)
        {
            Collections.shuffle(rangeList, secureRandom);
            final int index = RandomIntFactory.randomIntBetween(0, rangeList.size(), true,
                    false, secureRandom);
            Integer drawnNumber = rangeList.get(index);
            if (!numbers.contains(drawnNumber))
            {
                numbers.add(drawnNumber);
                ++cnt;
            }
        }
        return numbers;
    }

    /**
     * Draw of lottery numbers.
     *
     * @param maxNumbers
     *            the max number to draw
     * @param volume
     *            the volume of the numbers starts from 1 till volume
     * @return the sets the
     */
    public static Set<Integer> draw(int maxNumbers, int volume)
    {
        return draw(maxNumbers, volume, DefaultSecureRandom.get());
    }

    /**
     * Draw of lottery numbers.
     *
     * @param maxNumbers
     *            the maximum of numbers to draw
     * @param minVolume
     *            the min volume
     * @param maxVolume
     *            the max volume
     * @return the sets of the drawn numbers
     */
    public static Set<Integer> draw(int maxNumbers, int minVolume, int maxVolume)
    {
        return draw(maxNumbers, minVolume, maxVolume, DefaultSecureRandom.get());
    }
}
