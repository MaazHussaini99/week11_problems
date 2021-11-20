/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week11_problemssolutions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Solve problem 03:
 * We can easily verify that none of the entries in the first seven rows of Pascal's triangle are divisible by 7:

 	 	 	 	 	 	 1
 	 	 	 	 	 1	 	 1
 	 	 	 	 1	 	 2	 	 1
 	 	 	 1	 	 3	 	 3	 	 1
 	 	 1	 	 4	 	 6	 	 4	 	 1
 	 1	 	 5	 	10	 	10	 	 5	 	 1
1	 	 6	 	15	 	20	 	15	 	 6	 	 1
However, if we check the first one hundred rows, we will find that only 2361 of the 5050 entries are not divisible by 7.

Find the number of entries which are not divisible by 7 in the first one billion (109) rows of Pascal's triangle.
* 
 */
public class Problem03 {
    
    
    public static List<List<BigInteger>> generate(int numRows){
        
        List<List<BigInteger>> triangle = new ArrayList<>();
        
        if (numRows == 0) return triangle;
        
        List<BigInteger> first_row = new ArrayList<>();
        first_row.add(BigInteger.valueOf(1));
        triangle.add(first_row);
        
        for (int i = 1; i < numRows; i++) {
            List<BigInteger> prev_row = triangle.get(i-1);
            List< BigInteger> row = new ArrayList<>();
            
            row.add(BigInteger.valueOf(1));
            
            for (int j = 1; j < i; j++) {
                row.add(prev_row.get(j-1).add(prev_row.get(j)));
            }
            row.add(BigInteger.valueOf(1));
            triangle.add(row);
        }
        
        return triangle;
    }
    
    static boolean isDivisibleBy7(Long num)
    {
        // If number is negative, make it positive
        if( num < 0 )
            return isDivisibleBy7( -num );
  
        // Base cases
        if( num == 0 || num == 7 )
            return true;
        if( num < 10 )
            return false;
  
        // Recur for ( num / 10 - 2 * num % 10 )
        return isDivisibleBy7( num / 10 - 2 * ( num - num / 10 * 10 ) );
    }
    
    public static void main(String[] args) {
        
        List<List<BigInteger>> triangle = new ArrayList<>();
        
        triangle = generate(101);
        long counter = 0;
        long counter1 = 0;
        
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("    ");
                System.out.print(triangle.get(i).get(j));
                counter1++;
                if (isDivisibleBy7((triangle.get(i).get(j)).longValue())) {
                    counter+=1;
                }
            }
           
            System.out.println("    ");
        }
        System.out.println("Counter of Number's not divisible by 7: " + counter);
        System.out.println("Total numbers: " + counter1);
    }
}