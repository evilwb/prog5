package edu.pdx.wibecker;

public class Array_list
{
    Node head;

    private static class Node
    {
        private Event[] data;
        private Node next;

        public Node()
        {
            data = new Event[4];
            next = null;
        }
    }

    public Array_list()
    {
        head = null;
    }

    public void insert(Event new_event)
    {
        int index = 0;
        if(head == null)
        {
            head = new Node();
        }
        insert(new_event, head, index);
    }

    private void insert(Event new_event, Node head, int index)
    {
        if(head.data[index] == null)
        {
            head.data[index] = new_event;
        }
        else if(index + 1 < head.data.length)
        {
            insert(new_event, head, index + 1);
        }
        else
        {
            if (head.next == null)
            {
                head.next = new Node();
            }
            insert(new_event, head.next, index + 1 - head.data.length);
        }
    }

    public void display()
    {
        System.out.format("%-24s%-24s%-24s", "Event", "Your Path", "Other Path");
        System.out.println("\n------------------------------------------------------------------------");
        display(head, 0);
    }

    private void display(Node head, int index)
    {
        if(head == null)
        {
            return;
        }
        else if(head.data[index] == null)
        {
            return;
        }

        head.data[index].display();
        if(index + 1 < head.data.length)
        {
            display(head, index + 1);
        }
        else
        {
            display(head.next, index + 1 - head.data.length);
        }
    }
}
