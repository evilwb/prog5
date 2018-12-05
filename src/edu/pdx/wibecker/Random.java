// William Becker - CS202 - 11/29/18
// Random.java

package edu.pdx.wibecker;

import java.io.BufferedWriter;
import java.io.IOException;
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

    public void write(BufferedWriter file) throws IOException
    {
        file.append("random#" + name + "#" + description + "#" + left_path + "#" + right_path);
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
            System.out.println("Random");
            super.edit();
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

                case 'x':
                    editing = false;
                    break;
            }
        }
    }

    public String encounter()
    {
        input = new Scanner(System.in);

        System.out.println(description + "\nPress Enter to continue");
        input.nextLine();

        if(random_number.nextInt(2) == 0)
        {
            path_used = false;
            return left_path;
        }
        else
        {
            path_used = true;
            return right_path;
        }
    }
}
