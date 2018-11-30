// William Becker - CS202 - 11/29/18
// Main.java

package edu.pdx.wibecker;

import java.util.Scanner;
import java.io.BufferedWriter;

public class Main
{
    private Scanner input = new Scanner(System.in);
    private Balanced_tree tree = new Balanced_tree();
    BufferedWriter file;

    public static void main(String[] args)
    {
        Main program = new Main();
        program.run();
    }

    private void run()
    {
        /*
        //For testing
        //Examples:
        Event event1 = new Decision("tunnel", "There is a split with one tunnel going left and one going right.", "left", "right", "left", "right");
        Event event2 = new Random("teleport", "You find a teleporter.", "left", "right");
        Event event3 = new Puzzle("math", "What is 2+5?", "left", "right", "7");
        Event event4 = new End("exit", "You have found the exit.");

        tree.insert(event1);
        tree.insert(event2);
        tree.insert(event3);
        tree.insert(event4);
        */

        /*
        //Insert all letter:
        for(char i = 'a'; i <= 'z'; ++i)
        {
            Event temp = new End(String.valueOf(i), "test");
            tree.insert(temp);
        }
        */

        boolean running = true;
        char response;

        while(running == true)
        {

            System.out.println("\n\n");
            System.out.println("(a) Add Event\n(e) Edit Event\n(l) List Events\n(s) Save Tree\n(q) Quit Program");
            System.out.print("Choose an action: ");
            response = input.next().charAt(0);
            input.nextLine();

            switch(Character.toLowerCase(response))
            {
                case 'a':
                    add_event();
                    break;

                case 'e':
                    edit_event();
                    break;

                case 'l':
                    System.out.println("\n");
                    tree.display();
                    System.out.println("\nPress Enter to continue");
                    input.nextLine();
                    break;

                case 's':
                    tree.write_all(file);
                    break;

                case 'q':
                    running = false;
                    break;
            }

        }
        input.close();
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

    private void add_event()
    {
        char response;

        System.out.println("(d) Decision\n(r) Random\n(e) End\n(p) Puzzle");
        System.out.print("Choose an event type: ");
        response = input.next().charAt(0);
        input.nextLine();

        switch(Character.toLowerCase(response))
        {
            case 'd' :
                Decision decision = new Decision();
                tree.insert(decision.create());
                break;

            case 'r' :
                Random random = new Random();
                tree.insert(random.create());
                break;

            case 'e' :
                End end = new End();
                tree.insert(end.create());
                break;

            case 'p' :
                Puzzle puzzle = new Puzzle();
                tree.insert(puzzle.create());
                break;
        }
    }
}
