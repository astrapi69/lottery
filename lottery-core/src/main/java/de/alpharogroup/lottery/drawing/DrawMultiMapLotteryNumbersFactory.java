package de.alpharogroup.lottery.drawing;

import de.alpharogroup.collections.list.ListFactory;
import de.alpharogroup.collections.map.MapExtensions;
import de.alpharogroup.collections.map.MapFactory;
import de.alpharogroup.collections.set.SetFactory;
import de.alpharogroup.comparators.ComparatorFactory;
import de.alpharogroup.random.DefaultSecureRandom;
import de.alpharogroup.random.number.RandomBooleanFactory;
import de.alpharogroup.random.number.RandomIntFactory;

import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The factory class {@link DrawMultiMapLotteryNumbersFactory} provides factory methods to draw
 * lottery numbers
 * with different algorithms and {@link SecureRandom} argument for custom randomize draws, like
 * for a special draw date we could initialize the {@link SecureRandom} with the draw date. It
 * has provides methods for merge several multi maps
 */
public final class DrawMultiMapLotteryNumbersFactory {

    private DrawMultiMapLotteryNumbersFactory()
    {
    }

    /**
     * Draw of lottery numbers from given drawCount and take the numbers that are drawn the most
     * times and return a new set.
     *
     * @param maxNumbers
     *            the maximum of numbers to draw
     * @param minVolume
     *            the min volume
     * @param maxVolume
     *            the max volume
     * @param drawCount
     *            the draw count defines how many times to draw numbers
     * @return the sets of the drawn numbers
     */
    public static Set<Integer> drawFromMultiMap(int maxNumbers, int minVolume, int maxVolume,
        int drawCount)
    {
        return drawFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount, DefaultSecureRandom.get());
    }

    /**
     * Draw of lottery numbers from given drawCount and take the numbers that are drawn the most
     * times and return a new set.
     *
     * @param maxNumbers
     *            the maximum of numbers to draw
     * @param minVolume
     *            the min volume
     * @param maxVolume
     *            the max volume
     * @param drawCount
     *            the draw count defines how many times to draw numbers
     * @return the sets of the drawn numbers
     */
    public static Set<Integer> drawFromMultiMap(int maxNumbers, int minVolume, int maxVolume,
        int drawCount, SecureRandom secureRandom)
    {
        return drawFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount, true,
            false, secureRandom);
    }

    /**
     * Draw of lottery numbers from given drawCount and take the numbers that are drawn the most
     * times and return a new set.
     *
     * @param maxNumbers
     *            the maximum of numbers to draw
     * @param minVolume
     *            the min volume
     * @param maxVolume
     *            the max volume
     * @param drawCount
     *            the draw count defines how many times to draw numbers
     * @param mostDrawn
     *            the flag that indicates if the most drawn numbers should be taken if true,
     *            otherwise the reverse order will be taken
     * @return the sets of the drawn numbers
     */
    public static Set<Integer> drawFromMultiMap(int maxNumbers, int minVolume, int maxVolume,
        int drawCount, boolean mostDrawn)
    {
        return drawFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount, mostDrawn, DefaultSecureRandom.get());
    }

    /**
     * Draw of lottery numbers from given drawCount and take the numbers that are drawn the most
     * times and return a new set.
     *
     * @param maxNumbers
     *            the maximum of numbers to draw
     * @param minVolume
     *            the min volume
     * @param maxVolume
     *            the max volume
     * @param drawCount
     *            the draw count defines how many times to draw numbers
     * @param mostDrawn
     *            the flag that indicates if the most drawn numbers should be taken if true,
     *            otherwise the reverse order will be taken
     * @return the sets of the drawn numbers
     */
    public static Set<Integer> drawFromMultiMap(int maxNumbers, int minVolume, int maxVolume,
        int drawCount, boolean mostDrawn, SecureRandom secureRandom)
    {
        return drawFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount, mostDrawn, false, secureRandom);
    }

    /**
     * Draw of lottery numbers from given drawCount and take the numbers that are drawn the most
     * times and return a new set.
     *
     * @param maxNumbers
     *            the maximum of numbers to draw
     * @param minVolume
     *            the min volume
     * @param maxVolume
     *            the max volume
     * @param drawCount
     *            the draw count defines how many times to draw numbers
     * @param mostDrawn
     *            the flag that indicates if the most drawn numbers should be taken if true,
     *            otherwise the reverse order will be taken
     * @param paranoid
     *            the flag paranoid indicates to create a custom comparator from the counter map and
     *            define a random defined order to draw if true, otherwise the flag mostDrawn will
     *            define the order to draw
     * @return the sets of the drawn numbers
     */
    public static Set<Integer> drawFromMultiMap(int maxNumbers, int minVolume, int maxVolume,
        int drawCount, boolean mostDrawn, boolean paranoid)
    {
        return drawFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount, mostDrawn, paranoid, DefaultSecureRandom.get());
    }

    /**
     * Draw of lottery numbers from given drawCount and take the numbers that are drawn the most
     * times and return a new set.
     *
     * @param maxNumbers
     *            the maximum of numbers to draw
     * @param minVolume
     *            the min volume
     * @param maxVolume
     *            the max volume
     * @param drawCount
     *            the draw count defines how many times to draw numbers
     * @param mostDrawn
     *            the flag that indicates if the most drawn numbers should be taken if true,
     *            otherwise the reverse order will be taken
     * @param paranoid
     *            the flag paranoid indicates to create a custom comparator from the counter map and
     *            define a random defined order to draw if true, otherwise the flag mostDrawn will
     *            define the order to draw
     * @return the sets of the drawn numbers
     */
    public static Set<Integer> drawFromMultiMap(int maxNumbers, int minVolume, int maxVolume,
        int drawCount, boolean mostDrawn, boolean paranoid, SecureRandom secureRandom)
    {
        Map<Integer, Integer> numberCounterMap = MapFactory
            .newNumberCounterMap(minVolume, maxVolume);
        Comparator<Integer> mostDrawnComparator = drawFromMultiMap(maxNumbers, minVolume, maxVolume,
            drawCount, mostDrawn, paranoid, numberCounterMap, secureRandom);
        return resolveLotteryNumbers(maxNumbers, mostDrawnComparator, numberCounterMap);
    }

    /**
     * Factory method for create a comparator for sort the lottery numbers
     *
     * @param maxNumbers
     *            the maximum of numbers to draw
     * @param minVolume
     *            the min volume
     * @param maxVolume
     *            the max volume
     * @param drawCount
     *            the draw count defines how many times to draw numbers
     * @param mostDrawn
     *            the flag that indicates if the most drawn numbers should be taken if true,
     *            otherwise the reverse order will be taken
     * @param paranoid
     *            the flag paranoid indicates to create a custom comparator from the counter map and
     *            define a random defined order to draw if true, otherwise the flag mostDrawn will
     *            define the order to draw
     * @param numberCounterMap
     *            the counter map for generate statistics of the drawn lottery numbers
     * @return the comparator for sort the lottery numbers
     */
    public static Comparator<Integer> drawFromMultiMap(int maxNumbers, int minVolume, int maxVolume,
                                                       int drawCount, boolean mostDrawn, boolean paranoid, Map<Integer, Integer> numberCounterMap)
    {
        return drawFromMultiMap(
                maxNumbers, minVolume, maxVolume, drawCount, mostDrawn, paranoid,
                numberCounterMap, DefaultSecureRandom.get());
    }

    /**
     * Factory method for create a comparator for sort the lottery numbers
     *
     * @param maxNumbers
     *            the maximum of numbers to draw
     * @param minVolume
     *            the min volume
     * @param maxVolume
     *            the max volume
     * @param drawCount
     *            the draw count defines how many times to draw numbers
     * @param mostDrawn
     *            the flag that indicates if the most drawn numbers should be taken if true,
     *            otherwise the reverse order will be taken
     * @param paranoid
     *            the flag paranoid indicates to create a custom comparator from the counter map and
     *            define a random defined order to draw if true, otherwise the flag mostDrawn will
     *            define the order to draw
     * @param numberCounterMap
     *            the counter map for generate statistics of the drawn lottery numbers
     * @return the comparator for sort the lottery numbers
     */
    public static Comparator<Integer> drawFromMultiMap(int maxNumbers, int minVolume, int maxVolume,
        int drawCount, boolean mostDrawn,
        boolean paranoid, Map<Integer, Integer> numberCounterMap, SecureRandom secureRandom)
    {
        return newMostDrawnComparator(
            mergeDrawings(maxNumbers, minVolume, maxVolume, drawCount, numberCounterMap), paranoid,
            mostDrawn, secureRandom);
    }

    /**
     * Factory method for create a comparator for sort the lottery numbers
     *
     * @param maxNumbers
     *            the maximum of numbers to draw
     * @param minVolume
     *            the min volume
     * @param maxVolume
     *            the max volume
     * @param drawCount
     *            the draw count defines how many times to draw numbers
     * @param numberCounterMap
     *            the counter map for generate statistics of the drawn lottery numbers
     * @return the comparator for sort the lottery numbers
     */
    public static Comparator<Integer> drawFromMultiMap(int maxNumbers, int minVolume, int maxVolume,
                                                       int drawCount, Map<Integer, Integer> numberCounterMap)
    {
        return drawFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount, numberCounterMap, DefaultSecureRandom.get());
    }

    /**
     * Factory method for create a comparator for sort the lottery numbers
     *
     * @param maxNumbers
     *            the maximum of numbers to draw
     * @param minVolume
     *            the min volume
     * @param maxVolume
     *            the max volume
     * @param drawCount
     *            the draw count defines how many times to draw numbers
     * @param numberCounterMap
     *            the counter map for generate statistics of the drawn lottery numbers
     * @return the comparator for sort the lottery numbers
     */
    public static Comparator<Integer> drawFromMultiMap(int maxNumbers, int minVolume, int maxVolume,
        int drawCount, Map<Integer, Integer> numberCounterMap, SecureRandom secureRandom)
    {
        return newMostDrawnComparator(
            mergeDrawings(maxNumbers, minVolume, maxVolume, drawCount, numberCounterMap), false,
            true, secureRandom);
    }

    /**
     * Draw of paranoid lottery numbers from given drawCount and take the numbers that are drawn the
     * most times and return a new set.
     *
     * @param maxNumbers
     *            the maximum of numbers to draw
     * @param minVolume
     *            the min volume
     * @param maxVolume
     *            the max volume
     * @param drawCount
     *            the draw count defines how many times to draw numbers
     * @return the sets of the drawn numbers
     */
    public static Set<Integer> drawParanoidFromMultiMap(int maxNumbers, int minVolume,
        int maxVolume, int drawCount)
    {
        return drawParanoidFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount, DefaultSecureRandom.get());
    }

    /**
     * Draw of paranoid lottery numbers from given drawCount and take the numbers that are drawn the
     * most times and return a new set.
     *
     * @param maxNumbers
     *            the maximum of numbers to draw
     * @param minVolume
     *            the min volume
     * @param maxVolume
     *            the max volume
     * @param drawCount
     *            the draw count defines how many times to draw numbers
     * @return the sets of the drawn numbers
     */
    public static Set<Integer> drawParanoidFromMultiMap(int maxNumbers, int minVolume,
        int maxVolume, int drawCount, SecureRandom secureRandom)
    {
        return drawFromMultiMap(maxNumbers, minVolume, maxVolume, drawCount,
            RandomBooleanFactory.randomBoolean(), true, secureRandom);
    }

    /**
     * Factory method for create a comparator for sort the lottery numbers
     *
     * @param numberCounterMap
     *            the counter map for generate statistics of the drawn lottery numbers
     * @param paranoid
     *            the flag paranoid indicates to create a custom comparator from the counter map and
     *            define a random defined order to draw if true, otherwise the flag mostDrawn will
     *            define the order to draw
     * @param mostDrawn
     *            the flag that indicates if the most drawn numbers should be taken if true,
     *            otherwise the reverse order will be taken
     * @return the comparator for sort the lottery numbers
     */
    private static Comparator<Integer> newMostDrawnComparator(
        Map<Integer, Integer> numberCounterMap, boolean paranoid, boolean mostDrawn)
    {
        return newMostDrawnComparator(numberCounterMap, paranoid, mostDrawn, DefaultSecureRandom.get());
    }

    /**
     * Factory method for create a comparator for sort the lottery numbers
     *
     * @param numberCounterMap
     *            the counter map for generate statistics of the drawn lottery numbers
     * @param paranoid
     *            the flag paranoid indicates to create a custom comparator from the counter map and
     *            define a random defined order to draw if true, otherwise the flag mostDrawn will
     *            define the order to draw
     * @param mostDrawn
     *            the flag that indicates if the most drawn numbers should be taken if true,
     *            otherwise the reverse order will be taken
     * @return the comparator for sort the lottery numbers
     */
    private static Comparator<Integer> newMostDrawnComparator(
        Map<Integer, Integer> numberCounterMap, boolean paranoid, boolean mostDrawn, SecureRandom secureRandom)
    {
        Comparator<Integer> mostDrawnComparator;
        if (paranoid)
        {
            List<Integer> numberCounterValues = ListFactory
                .newArrayList(SetFactory.newTreeSet(numberCounterMap.values()));
            Collections.shuffle(numberCounterValues, secureRandom);
            mostDrawnComparator = ComparatorFactory.newComparator(numberCounterValues);
        }
        else
        {
            mostDrawnComparator = mostDrawn ? Comparator.reverseOrder() : Comparator.naturalOrder();
        }
        return mostDrawnComparator;
    }

    /**
     * Merges several drawings of lottery numbers from the given arguments
     *
     * @param maxNumbers
     *            the maximum of numbers to draw
     * @param minVolume
     *            the min volume
     * @param maxVolume
     *            the max volume
     * @param drawCount
     *            the draw count defines how many times to draw numbers
     * @param numberCounterMap
     *            the counter map for generate statistics of the drawn lottery numbers
     * @return the map with the merged lottery numbers
     */
    public static Map<Integer, Integer> mergeDrawings(int maxNumbers, int minVolume, int maxVolume,
                                                      int drawCount, Map<Integer, Integer> numberCounterMap)
    {
        for (int i = 0; i < drawCount; i++)
        {
            DrawLotteryNumbersFactory.draw(maxNumbers, minVolume, maxVolume)
                    .forEach(key -> numberCounterMap.merge(key, 1, Integer::sum));
        }
        return numberCounterMap;
    }

    /**
     * Resolves the lottery numbers from the given number counter map in the order from the given
     * comparator limited to maxNumbers
     *
     * @param maxNumbers
     *            the max numbers
     * @param numberCounterMap
     *            the number counter map
     * @return the sets of the lottery numbers
     */
    public static Set<Integer> resolveLotteryNumbers(int maxNumbers, Map<Integer, Integer> numberCounterMap)
    {
        return resolveLotteryNumbers(maxNumbers, newMostDrawnComparator(numberCounterMap,false, true), numberCounterMap);
    }

    /**
     * Resolves the lottery numbers from the given number counter map in the order from the given
     * comparator limited to maxNumbers
     *
     * @param maxNumbers
     *            the max numbers
     * @param mostDrawn
     *            the comparator that defines in which order to take the drawn numbers. For instance
     *            if you want to have the reverse order you can simply give the
     *            <code>Comparator.reverseOrder()</code> or you can define your custom order
     * @param numberCounterMap
     *            the number counter map
     * @return the sets of the lottery numbers
     */
    public static Set<Integer> resolveLotteryNumbers(int maxNumbers, Comparator<Integer> mostDrawn,
                                                     Map<Integer, Integer> numberCounterMap)
    {
        List<Map.Entry<Integer, Integer>> sortByValue = MapExtensions
                .sortByValueAsList(numberCounterMap, mostDrawn);

        List<Integer> newLotteryNumbers = sortByValue.stream().map(Map.Entry::getKey)
                .limit(maxNumbers).collect(Collectors.toList());
        return SetFactory.newTreeSet(newLotteryNumbers);
    }
}
