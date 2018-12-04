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
    File in = new File("./tree");
    Scanner file;

    public static void main(String[] args)
    {
        Main program = new Main();
        program.run();
    }

    private void run()
    {
        try
        {
            Scanner file = new Scanner(in);
        }
        catch(IOException error)
        {
            System.out.println(error);
        }

        boolean running = true;
        char response;

        while(file.hasNextLine())
        {
            add_event(file);
        }

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

    private void add_event(Scanner file)
    {
        switch(file.next("#"))
        {
            case "decision" :
                Decision decision = new Decision(file.next("#"), file.next("#"), file.next("#"),
                                                file.next("#"), file.next("#"), file.nextLine());
                tree.insert(decision);
                break;

            case "random" :
                Random random = new Random(file.next("#"), file.next("#"), file.next("#"), file.nextLine());
                tree.insert(random);
                break;

            case "end" :
                End end = new End(file.next("#"), file.nextLine());
                tree.insert(end);
                break;

            case "puzzle" :
                Puzzle puzzle = new Puzzle(file.next("#"), file.next("#"), file.next("#"),
                                            file.next("#"), file.nextLine());
                tree.insert(puzzle);
                break;
        }
    }
}
