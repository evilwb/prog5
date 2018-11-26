package edu.pdx.wibecker;

import java.util.Scanner;

public class Main
{
    private Scanner input = new Scanner(System.in);
    private Event[] tree = new Event[4];

    public static void main(String[] args)
    {
        Main program = new Main();
        program.run();
    }

    private void run()
    {
        add_event();

        for(Event i: tree)
        {
            System.out.println(i.encounter());
        }
    }

    private void add_event()
    {
        for(int i = 0; i < tree.length; i++)
        {
            char response;

            System.out.println("(d) Decision\n(r) Random\n(e) End\n(p) Puzzle");
            System.out.print("Choose an event type: ");
            response = input.next().charAt(0);
            input.nextLine();

            switch(Character.toLowerCase(response))
            {
                case 'd' :
                    tree[i] = new Decision();
                    break;

                case 'r' :
                    tree[i] = new Random();
                    break;

                case 'e' :
                    tree[i] = new End();
                    break;

                case 'p' :
                    tree[i] = new Puzzle();
                    break;
            }
            tree[i].create();
        }
    }
}
