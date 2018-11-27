package edu.pdx.wibecker;

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

    public String encounter()
    {
        input = new Scanner(System.in);
        System.out.println(description + "\nThanks for playing\nPress Enter to end the program");
        input.nextLine();

        return "";
    }
}
