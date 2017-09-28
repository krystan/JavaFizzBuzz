package com.forward.thinking.it.fizzbuzz.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import com.forward.thinking.it.fizzbuzz.FizzBuzzWorker;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

public class FizzBuzzWorkerTests {

    private FizzBuzzWorker _fizzBuzzWorker;

    @Before
    public void setup() {
        _fizzBuzzWorker = new FizzBuzzWorker();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateFizzBuzzIsCalledAndTheEndIsLessThanTheBeginningAnExceptionIsThrown() {
        // Arrange
        int beginning = 1;
        int end = 0;

        // Act
        _fizzBuzzWorker.createFizzBuzz(beginning,end);
    }

    @Test(expected = NullPointerException.class)
    public void whenNullReportObjectGivenToFormatReportAnExceptionIsThrown() {
        // Act
        _fizzBuzzWorker.formatFizzBuzzResultsReport();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNullValuesGivenToGenerateReportAnExceptionIsThrown() {
        // Act
        _fizzBuzzWorker.GenerateFizzBuzzReport();
    }

    @Test
    public void whenValuesArePassedToReportGenerationAReportIsGenerated() {
        // Arrange
        _fizzBuzzWorker.createFizzBuzz(1,15);

        LinkedHashMap<String, Integer> expectedResults = new LinkedHashMap<>();
        expectedResults.put(FizzBuzzWorker.Fizz, 3);
        expectedResults.put(FizzBuzzWorker.Buzz, 2);
        expectedResults.put(FizzBuzzWorker.FizzBuzz, 1);
        expectedResults.put(FizzBuzzWorker.Lucky, 2);
        expectedResults.put(FizzBuzzWorker.AnInteger, 7);

        // Act
        _fizzBuzzWorker.GenerateFizzBuzzReport();

        // Assert
        assertEquals(expectedResults.get(FizzBuzzWorker.Fizz), _fizzBuzzWorker.getReport().get(FizzBuzzWorker.Fizz));
        assertEquals(expectedResults.get(FizzBuzzWorker.Buzz), _fizzBuzzWorker.getReport().get(FizzBuzzWorker.Buzz));
        assertEquals(expectedResults.get(FizzBuzzWorker.FizzBuzz), _fizzBuzzWorker.getReport().get(FizzBuzzWorker.FizzBuzz));
        assertEquals(expectedResults.get(FizzBuzzWorker.Lucky), _fizzBuzzWorker.getReport().get(FizzBuzzWorker.Lucky));
        assertEquals(expectedResults.get(FizzBuzzWorker.AnInteger), _fizzBuzzWorker.getReport().get(FizzBuzzWorker.AnInteger));
    }

    @Test
    public void whenASetOffNumbersWhereNoNumbersArDivisibleByThreeOrFiveAreEncounteredSimplyReturnTheNumberSequence() {
        // Arrange
        int beginning = 1;
        int end = 2;
        String[] expectedOutput = new String[] {"1","2"};

        // Act
        _fizzBuzzWorker.createFizzBuzz(beginning, end);

        // Assert
        assertArrayEquals(expectedOutput, _fizzBuzzWorker.getFizzBuzzValues());
    }

    @Test
    public void whenANumberDivisibleByThreeIsInTheNumberSequenceThenLuckyIsOutput() {
        // Arrange
        int beginning = 1;
        int end = 3;
        String[] expectedOutput = new String[] {"1","2","lucky"};

        // Act
        _fizzBuzzWorker.createFizzBuzz(beginning, end);

        // Assert
        assertArrayEquals(expectedOutput, _fizzBuzzWorker.getFizzBuzzValues());
    }

    @Test
    public void whenANumberDivisibleByFiveIsInTheNumberSequenceThenBuzzIsOutput() {
        // Arrange
        int beginning = 1;
        int end = 5;
        String[] expectedOutput = new String[] {"1","2","lucky","4","buzz"};

        // Act
        _fizzBuzzWorker.createFizzBuzz(beginning, end);


        // Assert
        assertArrayEquals(expectedOutput, _fizzBuzzWorker.getFizzBuzzValues());
    }

    @Test
    public void whenANumberDivisibleByBothThreeAndFiveIsInTheNumberSequenceThenFizzBuzzIsOutput() {
        // Arrange
        int beginning = 1;
        int end = 15;
        String[] expectedOutput = new String[] {"1","2","lucky","4","buzz","fizz","7","8","fizz","buzz","11","fizz","lucky","14","fizzbuzz"};

        // Act
         _fizzBuzzWorker.createFizzBuzz(beginning, end);

        // Assert
        assertArrayEquals(expectedOutput, _fizzBuzzWorker.getFizzBuzzValues());
    }

    @Test
    public void whenASetOfResultsAreFormattedEnsureTheyAreFormattedCorrectly() {
        // Arrange
        int beginning = 1;
        int end = 15;
        String expectedFizzBuzzOutput = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz";
        _fizzBuzzWorker.createFizzBuzz(beginning, end);

        // Act
        String result = _fizzBuzzWorker.formatFizzBuzzResults();

        // Assert
        assertEquals(expectedFizzBuzzOutput, result);
    }
}

