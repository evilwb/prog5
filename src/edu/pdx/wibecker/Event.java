package edu.pdx.wibecker;

import java.util.Scanner;

abstract public class Event
{
    protected String name;
    protected String description;
    protected String left_path;
    protected String right_path;
    protected Scanner input;

    public Event()
    {
        name = null;
        description = null;
        left_path = null;
        right_path = null;
    }

    public Event(String name, String description, String left_path, String right_path)
    {
        this.name = new String(name);
        this.description = new String(description);
        this.left_path = new String(left_path);
        this.right_path = new String(right_path);
    }

    public void create()
    {
        input = new Scanner(System.in);
        System.out.print("Event name: ");
        name = input.nextLine();
        System.out.print("Event description: ");
        description = input.nextLine();
        System.out.print("Event left path: ");
        left_path = input.nextLine();
        System.out.print("Event right path: ");
        right_path = input.nextLine();
    }

    abstract public String encounter();
}

