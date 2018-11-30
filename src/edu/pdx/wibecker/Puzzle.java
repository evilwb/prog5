// William Becker - CS202 - 11/29/18
// Puzzle.java

package edu.pdx.wibecker;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class Puzzle extends Event
{
    String answer;

    public Puzzle()
    {
        super();
        answer = null;
    }

    public Puzzle(String name, String description, String left_path, String right_path, String answer)
    {
        super(name, description, left_path, right_path);
        this.answer = new String(answer);
    }

    public Event create()
    {
        input = new Scanner(System.in);
        System.out.println("Creating new Puzzle event");
        super.create();
        System.out.print("Answer: ");
        answer = input.nextLine();

        return this;
    }

    public void write(BufferedWriter file) throws IOException
    {
        file.append("puzzle#" + name + "#" + description + "#" + left_path + "#" + right_path + "#" + answer);
        file.append("\n");
    }

    public void edit()
    {
        input = new Scanner(System.in);
        char response;
        boolean editing = true;

        while(editing == true)
        {
            System.out.format("%-20s", "    Event Type: ");
            System.out.println("Puzzle");
            super.edit();
            System.out.format("%-20s", "(a) Answer: ");
            System.out.println(answer);
            System.out.println("(x) Done editing");
            System.out.print("Choose an attribute to edit: ");
            response = input.next().charAt(0);
            input.nextLine();

            switch (Character.toLowerCase(response))
            {
                case 'd':
                    System.out.print("Enter a new description: ");
                    description = input.nextLine();
                    break;

                case 'l':
                    System.out.print("Enter a new left path: ");
                    left_path = input.nextLine();
                    break;

                case 'r':
                    System.out.print("Enter a new right path: ");
                    right_path = input.nextLine();
                    break;

                case 'a':
                    System.out.print("Enter a new answer: ");
                    answer = input.nextLine();
                    break;

                case 'x':
                    editing = false;
                    break;
            }
        }
    }

    public String encounter()
    {
        String response;
        input = new Scanner(System.in);
        System.out.println(description + "\nEnter your answer: ");
        response = input.nextLine();

        if(response.equals(answer))
        {
            System.out.println("Your answer was correct\nPress Enter to continue");
            input.nextLine();
            return left_path;
        }
        else
        {
            System.out.println("Your answer was incorrect\nPress return to continue");
            input.nextLine();
            return right_path;
        }
    }
}
