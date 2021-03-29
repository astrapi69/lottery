package de.alpharogroup.lottery.drawings;

import de.alpharogroup.random.DefaultSecureRandom;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.security.SecureRandom;

/**
 * The class {@link DrawModelBean} contains data that can be used for the draw of lottery numbers
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DrawModelBean {
    /**
     * the maximum of numbers to draw
     */
    int maxNumbers;
    /**
     * the min volume
     */
    int minVolume;
    /**
     * the max volume
     */
    int maxVolume;
    /**
     * the draw count defines how many times to draw numbers
     */
    @Builder.Default
    int drawCount = 1;
    /**
     * the progress status for a progress bar if the draw count is very large
     */
    @Builder.Default
    int progressStatus = 0;
    /**
     * flag that indicates if the numbers should be additionally shuffled
     */
    boolean shuffle;
    /**
     * flag that indicates if the most drawn numbers should be taken if true,
     * otherwise the reverse order will be taken
     **/
    @Builder.Default
    boolean mostDrawn = true;
    /**
     * the flag paranoid indicates to create a custom comparator from the counter map and
     * define a random defined order to draw if true, otherwise the flag mostDrawn will
     * define the order to draw
     **/
    boolean paranoid;
    /**
     * the secure random object for random generation
     */
    @Builder.Default
    SecureRandom secureRandom = DefaultSecureRandom.get();
}
