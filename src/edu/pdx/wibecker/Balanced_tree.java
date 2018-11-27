package edu.pdx.wibecker;

public class Balanced_tree
{
    protected Node root;

    Balanced_tree()
    {
        root = null;
    }

    public Balanced_tree insert(Event to_add)
    {
        if (this.root == null)
        {
            this.root = new Node(to_add);
        }
        else
        {
            if(this.root.size == 3)
            {
                Node new_root = this.root.split(this.root);
                this.root = new_root;
            }
            this.root = insert(this.root, to_add);
        }
        return this;
    }

    private Node insert(Node root, Event to_add)
    {
        if (root.children[0] == null)
        {
            root.add_node(new Node(to_add));
            return root;
        }
        else
        {
            int i;
            for (i = 0; i < root.size; i++)
            {
                if (to_add.less_than(root.data[i]))
                    break;
            }

            if(root.children[i].size == 3)
            {
                Node move_up = root.split(root.children[i]);
                root.add_node(move_up);
                insert(to_add);
            }
            else
            {
                root.children[i] = insert(root.children[i], to_add);
            }
        }
        return root;
    }

    public void display()
    {
        display(this.root);
    }

    private void display(Node root)
    {
        if(root != null)
        {
            if(root.size == 1)
            {
                display(root.children[0]);
                root.data[0].display();
                display(root.children[1]);
            }
            else if(root.size == 2)
            {
                display(root.children[0]);
                root.data[0].display();
                display(root.children[1]);
                root.data[1].display();
                display(root.children[2]);
            }
            else
            {
                display(root.children[0]);
                root.data[0].display();
                display(root.children[1]);
                root.data[1].display();
                display(root.children[2]);
                root.data[2].display();
                display(root.children[3]);
            }
        }
    }

    public Balanced_tree remove_all()
    {
        root = null;
        return this;
    }

    private static class Node
    {
        private Node[] children;
        private Event[] data;
        private int size;

        public Node(Event data)
        {
            this.children = new Node[4];
            this.data = new Event[3];
            this.data[0] = data;
            this.size = 1;
        }

        public Node split(Node to_split)
        {
            Node new_node = new Node(to_split.data[1]);

            new_node.children[0] = new Node(to_split.data[0]);
            new_node.children[0].children[0] = to_split.children[0];
            new_node.children[0].children[1] = to_split.children[1];

            new_node.children[1] = new Node(to_split.data[2]);
            new_node.children[1].children[0] = to_split.children[2];
            new_node.children[1].children[1] = to_split.children[3];

            return new_node;
        }

        public Node add_node(Node to_add)
        {
            if(this.size == 0)
            {
                this.data[0] = to_add.data[0];
                this.children[1] = to_add.children[1];
                this.children[0] = to_add.children[0];
                ++size;
            }
            else if(this.size == 1)
            {
                if(to_add.data[0].less_than(this.data[0]))
                {
                    this.data[1] = this.data[0];
                    this.data[0] = to_add.data[0];
                    this.children[2] = this.children[1];
                    this.children[1] = to_add.children[1];
                    this.children[0] = to_add.children[0];
                }
                else
                {
                    this.data[1] = to_add.data[0];
                    this.children[2] = to_add.children[1];
                    this.children[1] = to_add.children[0];
                }
                ++size;
            }
            else if(this.size == 2)
            {
                if(to_add.data[0].less_than(this.data[0]))
                {
                    this.data[2] = this.data[1];
                    this.data[1] = this.data[0];
                    this.data[0] = to_add.data[0];
                    this.children[3] = this.children[2];
                    this.children[2] = this.children[1];
                    this.children[1] = to_add.children[1];
                    this.children[0] = to_add.children[0];
                }
                else if(to_add.data[0].less_than(this.data[1]))
                {
                    this.data[2] = this.data[1];
                    this.data[1] = to_add.data[0];
                    this.children[3] = this.children[2];
                    this.children[2] = to_add.children[1];
                    this.children[1] = to_add.children[0];
                }
                else
                {
                    this.data[2] = to_add.data[0];
                    this.children[3] = to_add.children[1];
                    this.children[2] = to_add.children[0];
                }
                ++size;
            }
            return this;
        }
    }
}
