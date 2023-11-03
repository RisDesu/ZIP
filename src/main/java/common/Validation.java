/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package common;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Validation {
    
    public static int checkIntLimit(int min, int max) {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Re-input!!!");
            }

        }
    }

    public static String checkString() {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                String str = in.nextLine().trim();
                if (str.length() == 0) {
                    throw new NumberFormatException();
                }
                return str;
            } catch (NumberFormatException e) {
                System.err.println("Not empty!!!");
            }
        }
    }
}
