package edu.pdx.wibecker;

import java.util.Scanner;

public class Random extends Event
{
    java.util.Random random_number = new java.util.Random();

    public Random()
    {
        super();
    }

    public Random(String name, String description, String left_path, String right_path)
    {
        super(name, description, left_path, right_path);
    }

    public Event create()
    {
        input = new Scanner(System.in);
        System.out.println("Creating new Random event");
        super.create();

        return this;
    }

    public String encounter()
    {
        input = new Scanner(System.in);

        System.out.println(description + "\nPress Enter to continue");
        input.nextLine();

        if(random_number.nextInt(2) == 0)
        {
            return left_path;
        }
        else
        {
            return right_path;
        }
    }
}
