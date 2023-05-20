package com.telusko.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//
//Pascal Triangle
//		1
//	  1   1
//	1	2	1	
//1   3    3   1
//

public class PascalTriangle {
	private static List<List<Integer>> memoizeTable = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		List<List<Integer>> li = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number ");
		n = sc.nextInt();

//		Pascal Triangle using Iteration
		System.out.println("Pascal triangle using Iteration");
		pascalTriangleIteration(n, li);
		printPascalTriangle(li);

//		Pascal Triangle using memoization

		System.out.println("Pascal triangle using Memoization");
		pascalTraingleMemoization(n);
		printPascalTriangle(memoizeTable);

//		Pascal Triangle using Recursion
		System.out.println("Pascal triangle using Recusrion");
		pascalTraingleRecursion(n, li);
		printPascalTriangle(li);

	}

//Recursion
	public static void pascalTraingleRecursion(int rows, List<List<Integer>> li) {
        li.clear();
        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(recursionHelper(i, j));
            }
            li.add(row);
        }
    }

    public static int recursionHelper(int i, int j) {
        if (j == 0 || j == i) {
            return 1;
        } else {
            return recursionHelper(i - 1, j - 1) + recursionHelper(i - 1, j);
        }
    }

//Memoization
	private static void pascalTraingleMemoization(int rows) {
		for (int i = 1; i <= rows; i++) {
			List<Integer> row = new ArrayList<>();
			for (int j = 1; j <= i; j++) {
				row.add(helper(i, j));
			}
			memoizeTable.add(row);
		}
	}

	private static int helper(int i, int j) {
		if (j == 1 || j == i) {
			return 1;
		} else {
			return memoizeTable.get(i - 2).get(j - 2) + memoizeTable.get(i - 2).get(j - 1);
		}
	}

//Iteration
	public static void pascalTriangleIteration(int n, List<List<Integer>> li) {
		List<Integer> temp = new ArrayList();
		temp.add(1); // Adding first Element
		li.add(temp);
		temp = null; // Making null for next row
		for (int i = 2; i <= n; i++) {
			temp = new ArrayList();
			for (int j = 1; j <= i; j++) {
				if (j == 1 || j == i) {
					temp.add(1);
				} else {
					temp.add(li.get(i - 2).get(j - 2) + li.get(i - 2).get(j - 1));
				}
			}
			li.add(temp);
		}
	}

// Print Function
	private static void printPascalTriangle(List<List<Integer>> li) {
		// TODO Auto-generated method stub
		for (List<Integer> liEle : li) {
			System.out.println();
			for (int ele : liEle) {
				System.out.print(ele + " ");
			}
		}
		System.out.println();
	}

}
