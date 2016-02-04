package com.example.awesomefat.linkedlist;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class LinkedList
{
    private Node head;
    private LinearLayout layout;

    public LinkedList(LinearLayout layout)
    {
        this.head = null;
        this.layout = layout;
    }

    public void display()
    {
        //this.layout.removeAllViews();
        if(this.head == null)
        {
            View v = ListCore.inflater.inflate(R.layout.node, null);
            TextView tf = (TextView) v.findViewById(R.id.theValueTF);
            tf.setText("Empty List");
            this.layout.addView(v);
        }
        else
        {
            //display the list in a reasonable format
            this.head.display(this.layout);
        }
        View v = ListCore.inflater.inflate(R.layout.node, null);
        TextView tf = (TextView) v.findViewById(R.id.theValueTF);
        tf.setText("_____________");
        this.layout.addView(v);
    }

    public void addFront(String value)
    {
        //this adds a new Node to the front of the list with payload == value
        Node n = new Node(value);
        n.setNextNode(this.head);
        this.head = n;
    }

    public Node removeFront()
    {
        //this removes and returns the Node that is currently sitting at the
        //front of the list.  The new front of the list, should be the old
        //second node or null in the event it was a 1-list
        Node nodeToReturn = this.head;
        if(this.head != null)
        {
            this.head = this.head.getNextNode();
        }
        nodeToReturn.setNextNode(null);
        return nodeToReturn;
    }

    public void addEnd(String value)
    {
        Node n = new Node(value);
        //if head is empty
        if (this.head == null)
            this.head = n;
        else
        {
            // search for the the end by checking if there's next or not
            Node temp = this.head; // starts with the first node.
            while (temp.getNextNode() != null) //loop till last node
                temp = temp.getNextNode();
            temp.setNextNode(n); //set last node to value
        }
    }
    public Node removeEnd()
    {
        if (this.head == null) //nothing to remove
        {
            return null;
        }
        else {
            if (this.head.getNextNode() == null) { //2 element list remove last
                Node node = this.head;
                this.head = null;
                return node;
            } else { // find end and set it to null
                Node current = this.head;
                Node returnedNode = current.getNextNode();
                while (current.getNextNode() != null && returnedNode.getNextNode() != null) {
                    current = current.getNextNode();
                    returnedNode = current.getNextNode();
                }
                current.setNextNode(null);
                return returnedNode;
            }
        }


    }
}