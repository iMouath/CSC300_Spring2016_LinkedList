package com.example.awesomefat.linkedlist;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by awesomefat on 1/28/16.
 */
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




        if(this.head == null)
        {
           //System.out.println("***** Empty List *****");

            View v;
            v = ListCore.inflater.inflate(R.layout.node, null);
            TextView tf = (TextView) v.findViewById(R.id.theValueTF);
            tf.setText("Empty List");
            this.layout.addView(v);
        }
        else
        {
            //display the list in a reasonable format
            this.head.display(this.layout);
        }

    }

    public void addFront(String value)
    {
        //this adds a new Node to the front of the list with payload == value
        Node newHead = new Node(value);
        newHead.setNextNode(this.head);
        this.head = newHead;
    }

    public Node removeFront()
    {
        //this removes and returns the Node that is currently sitting at the
        //front of the list.  The new front of the list, should be the old
        //second node or null in the event it was a 1-list
        Node nodeToRemove = this.head;

        if(this.head.getNextNode() == null)
            this.head = null;
        else
            this.head = this.head.getNextNode();


        return nodeToRemove;
    }
}
