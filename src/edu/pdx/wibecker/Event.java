// William Becker - CS202 - 11/29/18
// Event.java

package edu.pdx.wibecker;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

abstract public class Event
{
    protected String name;
    protected String description;
    protected String left_path;
    protected String right_path;
    protected Scanner input;
    protected boolean path_used;

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

    public Event create()
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

        return this;
    }

    public void display()
    {
        if(path_used)
        {
            System.out.format("%-24s%-24s%-24s", name, right_path, left_path);
        }
        else
        {
            System.out.format("%-24s%-24s%-24s", name, left_path, right_path);
        }
        System.out.println();
    }

    abstract public void write(BufferedWriter file) throws IOException;

    public void edit()
    {
        System.out.format("%-20s", "    Name: ");
        System.out.println(name);
        System.out.format("%-20s", "(d) Description: ");
        System.out.println(description);
        System.out.format("%-20s", "(l) Left Path: ");
        System.out.println(left_path);
        System.out.format("%-20s", "(r) Right Path: ");
        System.out.println(right_path);
    }

    public boolean less_than(Event other)
    {
        return (this.name.compareTo(other.name) < 0);
    }

    public boolean less_than(String other)
    {
        return (this.name.compareTo(other) < 0);
    }

    public boolean greater_than(String other)
    {
        return (this.name.compareTo(other) > 0);
    }

    public boolean equal_to(String other)
    {
        return (this.name.compareTo(other) == 0);
    }

    abstract public String encounter();
}

