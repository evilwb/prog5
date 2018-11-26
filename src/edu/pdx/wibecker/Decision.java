package edu.pdx.wibecker;

import java.util.Scanner;

public class Decision extends Event
{
    protected String choice1;
    protected String choice2;

    public Decision()
    {
        super();
        choice1 = null;
        choice2 = null;
    }

    public Decision(String name, String description, String left_path, String right_path, String choice1, String choice2)
    {
        super(name, description, left_path, right_path);
        this.choice1 = new String(choice1);
        this.choice2 = new String(choice2);
    }

    public void create()
    {
        input = new Scanner(System.in);
        System.out.println("Creating new Decision event");
        super.create();
        System.out.print("Choice 1: ");
        choice1 = input.nextLine();
        System.out.print("Choice 2: ");
        choice2 = input.nextLine();
    }

    public String encounter()
    {
        int selection = 0;
        input = new Scanner(System.in);

        System.out.println(description);
        System.out.println("(1) " + choice1);
        System.out.println("(2) " + choice2);

        while(selection != 1 && selection != 2)
        {
            System.out.print("Enter your choice number: ");
            if(input.hasNextInt())
            {
                selection = input.nextInt();
            }
            input.nextLine();
        }

        if(selection == 1)
        {
            return left_path;
        }
        else
        {
            return right_path;
        }
    }
}
