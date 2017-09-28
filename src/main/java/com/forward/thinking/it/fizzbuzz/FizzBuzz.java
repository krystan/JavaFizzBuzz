package com.forward.thinking.it.fizzbuzz;

import java.util.LinkedHashMap;

public class FizzBuzz {
    public static void main(String[] args) {
        boolean inputIsValid = IsInputArrayIsValid(args);

        if (!inputIsValid) {
            System.out.println("Usage Part1 <num1> <num2>");
            System.exit(-1);
        }

        int beginning, end;

        try {
            beginning = Integer.parseInt(args[0]);
            end = Integer.parseInt(args[1]);

            FizzBuzzWorker worker = new FizzBuzzWorker();
            worker.createFizzBuzz(beginning, end);
            worker.GenerateFizzBuzzReport();
            worker.outputResults();
        } catch (NumberFormatException nfe) {
            System.err.println("Unable to convert supplied parameters, check your parameters are Integers");
            System.exit(-1);
        } catch (IllegalArgumentException argException) {
            System.err.println("Unable to generate FizzBuzz numbers due to internal error, check your parameters");
            System.exit(-1);
        }
    }

    public static boolean IsInputArrayIsValid(String[] args) {
        return args != null && args.length == 2;
    }
}
