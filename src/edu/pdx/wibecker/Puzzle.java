package edu.pdx.wibecker;

import java.util.Scanner;

public class Puzzle extends Event
{
    String answer;

    Puzzle()
    {
        super();
        answer = null;
    }

    Puzzle(String name, String description, String left_path, String right_path, String answer)
    {
        super(name, description, left_path, right_path);
        this.answer = new String(answer);
    }

    public void create()
    {
        input = new Scanner(System.in);
        System.out.println("Creating new Puzzle event");
        super.create();
        System.out.print("Answer: ");
        answer = input.nextLine();
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
