import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.io.PrintWriter;
/**
 *
 * CS 313 Warm Up Project
 *
 * This program will encrypt and decrypt a message using a simple
 * columnar transposition encryption algorithm.
 *
 * Perry Raskin
 * Computer Science, CUNY Queens College
 */

 public class WarmUpProj {
   public static void main(String[] args){

         /*//read string from file
         String input = readFromFile("input1.txt");
         System.out.println("INPUT: " + input);
         System.out.println();*/

         try {
           File inputFile = new File("input.txt");
           Scanner in = new Scanner(inputFile);
           //PrintWriter out = new PrintWriter(output.txt);

           while (in.hasNextLine()) {
             String input = in.nextLine();

             //if leads with "E", encrypt string
             if (input.substring(0,1).equals("E")){
               //remove * from string
               input = input.replace("*","");

               System.out.println("ENCRYPTION TABLE: ");
               encrypt(input);
               System.out.println();
             }
             //if leads with 'D', decrypt string
             else if (input.substring(0,1).equals("D")){
               //remove * from string
               input = input.replace("*","");

               System.out.println("DECRYPTION TABLE: ");
               decrypt(input);
               System.out.println();
             }
           }
           in.close();
           //out.close();

         } catch (FileNotFoundException e) {
           System.err.println("Caught IOException: " + e.getMessage());
         }

 }

    private static void encrypt(String input){
      char[] charInput = input.toCharArray();
      //amount of columns and rows
      int colNum = Character.getNumericValue(charInput[1]);
      //System.out.println(colNum);
      int rowNum = ((charInput.length-2)/colNum)+1;
      //System.out.println(rowNum);
      int elmt = 2;

      //input is written to a table of col columns of chars, filling row by row
      char[][] encArray = new char[rowNum][colNum];
      for (int row = 0; row < rowNum; row++){
        for (int col = 0; col < colNum; col++){
          if (charInput[elmt] != 0) encArray[row][col] = charInput[elmt];
          else encArray[row][col] = 'X';
          elmt++;
          System.out.print(encArray[row][col] + " ");
        }
        System.out.println();
      }

      System.out.println();
      System.out.println("ENCRYPTED STRING: ");
      //write by reading column by column
      for (int col = 0; col < colNum; col++){
        for (int row = 0; row < rowNum; row++){

          System.out.print(encArray[row][col]);
        }

      }
      //System.out.println();

    }

    private static void decrypt(String input){
      char[] charInput = input.toCharArray();
      //amount of columns and rows
      int colNum = Character.getNumericValue(charInput[1]);
      //System.out.println(colNum);
      int rowNum = ((charInput.length-2)/colNum)+1;
      //System.out.println(rowNum);
      int elmt = 2;

      //input is written to a table of col columns of chars, filling column by column
      char[][] decArray = new char[rowNum][colNum];
      for (int col = 0; col < colNum; col++){
        for (int row = 0; row < rowNum; row++){
          if (charInput[elmt] != 0) decArray[row][col] = charInput[elmt];
          else break;
          elmt++;
          System.out.print(decArray[row][col] + " ");
        }
        System.out.println();
      }

      System.out.println();
      System.out.println("DECRYPTED STRING: ");
      //write by reading column by column
      for (int row = 0; row < rowNum; row++){
        for (int col = 0; col < colNum; col++){

          System.out.print(decArray[row][col]);
        }

      }
      //System.out.println();

    }

 }
