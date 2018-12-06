// William Becker - CS202 - 12/4/18
// Decision.java

package edu.pdx.wibecker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

    public Event create()
    {
        input = new Scanner(System.in);
        System.out.println("Creating new Decision event");
        super.create();
        System.out.print("Choice 1: ");
        choice1 = input.nextLine();
        System.out.print("Choice 2: ");
        choice2 = input.nextLine();

        return this;
    }

    public void write(BufferedWriter file) throws IOException
    {
        file.append("decision#" + name + "#" + description + "#" + left_path + "#" + right_path + "#" + choice1 + "#" + choice2);
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
            System.out.println("Decision");
            super.edit();
            System.out.format("%-20s", "(1) Choice 1: ");
            System.out.println(choice1);
            System.out.format("%-20s", "(2) Choice 2: ");
            System.out.println(choice2);
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

                case '1':
                    System.out.print("Enter a new choice 1: ");
                    choice1 = input.nextLine();
                    break;

                case '2':
                    System.out.print("Enter a new choice 2: ");
                    choice2 = input.nextLine();
                    break;

                case 'x':
                    editing = false;
                    break;
            }
        }
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
