// William Becker - CS202 - 11/29/18
// End.java

package edu.pdx.wibecker;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class End extends Event
{
    public End()
    {
        super();
    }

    public End(String name, String description)
    {
        super(name, description, "", "");
    }

    public Event create()
    {
        input = new Scanner(System.in);
        System.out.println("Creating new End event");
        System.out.print("Event name: ");
        name = input.nextLine();
        System.out.print("Event description: ");
        description = input.nextLine();

        return this;
    }

    public void display()
    {
        System.out.format("%-24s", name);
        System.out.println("No paths");
    }

    public void write(BufferedWriter file) throws IOException
    {
        file.append("end#" + name + "#" + description);
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
            System.out.println("End");
            System.out.format("%-20s", "    Name: ");
            System.out.println(name);
            System.out.format("%-20s", "(d) Description: ");
            System.out.println(description);
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

                case 'x':
                    editing = false;
                    break;
            }
        }
    }

    public String encounter()
    {
        input = new Scanner(System.in);
        System.out.println(description + "\nThanks for playing\nPress Enter to end the program");
        input.nextLine();

        return null;
    }
}
