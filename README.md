# SOFTENG 282 Assignment 2

Author: Brandon Seng Han Chan
UPI: bcha389
UoA Student ID: 501744077

This Java program calculates the greatest common divisor of the sum of the first A Fibonacci numbers and the sum of the first B Fibonacci numbers. This is done by first calculating the sums, and then using the Euclidean Algorithm to compute the GCD.

## To compile and run



The following constraints must be adhered to:
- Should not rely on precomputed Fibonacci numbers
- Should not brute-force compute the Fibonacci series up to the desired number (cannot explictly generate the entire series)

## Calculating the nth Fibonacci number

To avoid computing every single number in the series until the nth Fibonacci number, we can instead find an explicit formula for Fibonacci numbers by solving the recurrence relation

a_n = a_(n-1) + a_(n-2)

which can also be written as

a_(n+1) = a_(n+1) + a_n

Referring to pages 43 to 45 in Course book II (Discrete Structures in Mathematics and Computer Science), a solution to recurrence relations of this type can be found of the form a_n = r^n. The following working details this solution:

![Image_1](Image_1.jpg)

This solution of the Fibonacci sequence can thus be used for all integers n >= 0.

The method implementing this formula was made to return an integer; this decision means that it will only work between n = 0 and n = 46. Any higher input integer and the maximum value for integers (2147483647) is reached and the method does not work.

## Calculating the sum of the first n Fibonacci numbers

In the above image, the first 10 Fibonacci numbers and the sums at each integer n from 0 to 10 were calculated manually. A pattern can be found in which the sum of the first n Fibonacci numbers is very close to the (n+2)th Fibonacci number.

The following working proves the relationship, in which the sum of Fibonacci numbers from 0 to n can be calculated where like terms cancel out to result in only two remaining terms.

![Image_2](Image_2.jpg)

So the sum of the first n Fibonacci numbers is equal to the (n+2)th Fibonacci number minus 1.

The method implementing this formula also returns an integer, and so will only work between n = 0 and n = 44. This is because the method uses the fibonacci method to find the (n+2)th fibonacci number. Since (n+2) will not give the correct answer when more than 46, this method will not work when n is more than 44.

## Calculating the GCD of two numbers

This program uses the Euclidean Algorithm to calculate the greatest common divisor of two numbers n and mm.

If n = m, return n.

Equate n and m to a and b such that a > b.

Let a = qb + r, where r is the remainder of a / b.
If r does not equal 0, let a = b and b = r, and repeat the process.

When r = 0, return b.

