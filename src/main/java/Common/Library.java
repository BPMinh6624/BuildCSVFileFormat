/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import java.io.File;

import java.util.Scanner;

public class Library {
    protected Scanner sc;

    public Library() {
        sc = new Scanner(System.in);
    }
    public int getInt(String promt, int m, int n) {
        int a = -1;
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a >= m && a <= n) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + m + " and " + n);
            }
        }
        return a;
    }

    
    public int getIntNoLimit(String promt) {
        int a = -1;
        while (true) {
            System.out.print(promt);
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a > 0 && a <= 10000) {
                    return a;
                } else {
                    System.out.println("Invalid input");
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }
    
    public String getString(String mes) {
        System.out.print(mes);
        return sc.nextLine();
    }


    public boolean checkInputYN(String mes) {
        System.out.print(mes);
        while (true) {
            String result = sc.nextLine();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
    
 
    public String checkInputPathFile(String promt) {
        System.out.print(promt);
        while (true) {
            String result = sc.nextLine().trim();
            File file = new File(result);
            if (!file.exists() || !file.isDirectory()) {
                System.err.println("Path doesn't exist or is not a valid directory!!!");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
    
}
