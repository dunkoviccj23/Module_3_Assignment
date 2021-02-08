package edu.wctc;

public class Main {

    public static void main(String[] args) {
        String evens = "evens";
        String primes = "primes";
        String Fibonaccis = "Fibonaccis";

        VennDiagram<Integer> numbers = new VennDiagram<>(evens, primes, Fibonaccis);

        numbers.add(1, Fibonaccis);
        numbers.add(2, evens, primes, Fibonaccis);
        numbers.add(3, primes, Fibonaccis);
        numbers.add(4, evens);
        numbers.add(5, primes, Fibonaccis);
        numbers.add(6, evens);
        numbers.add(7, primes);
        numbers.add(8, evens, Fibonaccis);
        numbers.add(9);
        numbers.add(10, evens);

        //Numbers that are either prime or even
        System.out.println(numbers.unionOf(primes, evens));
        //Numbers that are both prime and Fibonacci
        System.out.println(numbers.intersectionOf(primes, Fibonaccis));
        //Odd Fibonacci numbers
        System.out.println(numbers.complementOf(Fibonaccis, evens));
        //Numbers that are even and prime and Fibonacci
        System.out.println(numbers.diagramCenter());
    }
}
