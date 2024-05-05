package edu.learn.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class MergeSorterTest {
	final Random random = new Random();
	final Sorter mergeSorter = new MergeSorter();
	
    @Test
    public void testSort() {
    	final int[]input = IntStream.generate(random::nextInt).limit(50).toArray();
        final int[]result = mergeSorter.sort(input);
        final int[]expected = Arrays.stream(input).sorted().toArray();
        Assert.assertArrayEquals(expected, result);
    }
    
    @Test
    public void testSortSet2() {
    	final int[]input = IntStream.generate(random::nextInt).limit(2*50).toArray();
        final int[]result = mergeSorter.sort(input);
        final int[]expected = Arrays.stream(input).sorted().toArray();
        Assert.assertArrayEquals(expected, result);
    }
}