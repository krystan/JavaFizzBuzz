package com.forward.thinking.it.fizzbuzz;

import java.util.LinkedHashMap;
import java.util.stream.IntStream;

public class FizzBuzzWorker {
    public static String Fizz = "fizz";
    public static String Buzz = "buzz";
    public static String FizzBuzz = "fizzbuzz";
    public static String Lucky = "lucky";
    public static String AnInteger = "integer";

    private LinkedHashMap<String, Integer> _report;
    private String[] _fizzBuzzValues;

    public LinkedHashMap<String, Integer> getReport() { return _report;}
    public String[] getFizzBuzzValues() { return _fizzBuzzValues;}

    /**
     * Generate a stream of FizzBuzz strings.
     * Uses special case of 3 to output "lucky"
     *
     * @param beginning number to begin from
     * @param end number to end on
     * @return stream of FizzBuzz values.
     */
    public void createFizzBuzz(int beginning, int end) {
        if (end < beginning) {
            throw new IllegalArgumentException("Bad number range");
        }

        _fizzBuzzValues = IntStream.rangeClosed(beginning, end).mapToObj(val -> {
            String retVal = String.valueOf(val);

            if (retVal.contains("3")) {
                retVal = Lucky;
            } else if (val % 15 == 0) {
                retVal = FizzBuzz;
            } else if (val % 5 == 0) {
                retVal = Buzz;
            } else if (val % 3 == 0) {
                retVal = Fizz;
            }

            return retVal;
        }).sequential().toArray(String[]::new);
    }

    public void GenerateFizzBuzzReport() {
        if (_fizzBuzzValues == null) {
            throw new IllegalArgumentException("please submit results");
        }

        LinkedHashMap<String, Integer> results = new LinkedHashMap<>();
        results.put(Fizz, 0);
        results.put(Buzz, 0);
        results.put(FizzBuzz, 0);
        results.put(Lucky, 0);
        results.put(AnInteger, 0);

        for (String str: _fizzBuzzValues) {
            if (str.equals(Fizz)) {
                results.put(Fizz, results.get(Fizz) + 1);
            } else if (str.equals(Buzz)) {
                results.put(Buzz, results.get(Buzz) + 1);
            } else if (str.equals(FizzBuzz)) {
                results.put(FizzBuzz, results.get(FizzBuzz) + 1);
            } else if (str.equals(Lucky)) {
                results.put(Lucky, results.get(Lucky) + 1);
            } else {
                results.put(AnInteger, results.get(AnInteger) + 1);
            }
        }

        _report = results;
    }

    /**
     * Format the fizzbuzz results
     *
     * @return A properly formatted string of results ready for output
     */
    public String formatFizzBuzzResults() {
        return String.join(" ", _fizzBuzzValues);
    }

    /**
     * Format a fizzbuzz _report
     *
     * @return formatted results string
     */
    public String formatFizzBuzzResultsReport() {
        StringBuffer buffer = new StringBuffer();
        _report.entrySet().stream().forEach(entry ->buffer.append(entry.getKey() + ": " + entry.getValue()).append("\n"));
        return buffer.toString().trim();
    }

    public void outputResults() {
        System.out.println(formatFizzBuzzResults());
        System.out.println();
        System.out.println(formatFizzBuzzResultsReport());
    }
}
