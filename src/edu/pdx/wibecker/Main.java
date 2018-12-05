// William Becker - CS202 - 11/29/18
// Main.java

package edu.pdx.wibecker;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    private Scanner input = new Scanner(System.in);
    private Balanced_tree tree = new Balanced_tree();
    private Array_list list = new Array_list();
    private File in = new File("./tree.txt");
    private Scanner file;
    private String next_event;


    public static void main(String[] args)
    {
        Main program = new Main();
        program.run();
    }

    private void run()
    {
        try
        {
            file = new Scanner(in).useDelimiter("#");
        }
        catch(IOException error)
        {
            System.out.println(error);
        }

        boolean running = true;
        char response;

        next_event = file.nextLine();
        while(file.hasNextLine())
        {
            add_event(file);
        }

        while(next_event != null)
        {
            Event curr_event = tree.retrieve(next_event);
            next_event = curr_event.encounter();
            list.insert(curr_event);
        }
        input.close();

        System.out.println("Path through the events:");
        list.display();
    }

    private void edit_event()
    {
        String event_name;
        Event selected_event;

        System.out.print("Enter the event name: ");
        event_name = input.nextLine();

        selected_event = tree.retrieve(event_name);
        if(selected_event != null)
        {

            selected_event.edit();
        }
    }

    private void add_event(Scanner file)
    {
        switch(file.next())
        {
            case "decision" :
                Decision decision = new Decision(file.next(), file.next(), file.next(), file.next(), file.next(), file.next());
                tree.insert(decision);
                break;

            case "random" :
                Random random = new Random(file.next(), file.next(), file.next(), file.next());
                tree.insert(random);
                break;

            case "end" :
                End end = new End(file.next(), file.next());
                tree.insert(end);
                break;

            case "puzzle" :
                Puzzle puzzle = new Puzzle(file.next(), file.next(), file.next(), file.next(), file.next());
                tree.insert(puzzle);
                break;
        }
        file.nextLine();
    }
}
