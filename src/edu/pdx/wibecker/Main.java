package edu.pdx.wibecker;

import java.util.Scanner;

public class Main
{
    private Scanner input = new Scanner(System.in);
    private Balanced_tree tree = new Balanced_tree();

    public static void main(String[] args)
    {
        Main program = new Main();
        program.run();
    }

    private void run()
    {
        Event event1 = new Decision("tunnel", "There is a split with one tunnel going left and one going right.", "left", "right", "left", "right");
        Event event2 = new Random("teleport", "You find a teleporter.", "left", "right");
        Event event3 = new Puzzle("math", "What is 2+5?", "left", "right", "7");
        Event event4 = new End("exit", "You have found the exit.");
        Event event5 = new End("spike", "You ran into a spike trap.\nGame Over");
        Event event6 = new End("crusher", "You ran into a spike trap.\nGame Over");
        Event event7 = new End("dart", "You ran into a spike trap.\nGame Over");

        for(char i = 'a'; i <= 'h'; ++i)
        {
            Event temp = new End(String.valueOf(i), "test");
            tree.insert(temp);
        }

        tree.insert(event1);
        tree.insert(event2);
        tree.insert(event3);
        tree.insert(event4);
        tree.insert(event5);
       // tree.insert(event6);
       // tree.insert(event7);

        tree.display();
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
