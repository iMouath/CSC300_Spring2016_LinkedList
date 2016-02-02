package com.example.awesomefat.linkedlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        ListCore.inflater = this.getLayoutInflater();

        LinearLayout svLL = (LinearLayout)this.findViewById(R.id.scrollViewLL);
        LinkedList ll = new LinkedList(svLL);

        ll.addFront("Mouath");
        ll.addFront("Android");
        ll.addFront("TEST");
        ll.removeFront();

        ll.display();



        /* View v;
        for(int i = 0; i < 100; i++)
        {
            v = this.getLayoutInflater().inflate(R.layout.node, null);
            TextView tf = (TextView) v.findViewById(R.id.theValueTF);
            tf.setText(""+i);
            svLL.addView(v);
        }
        */
    }

    public void theButtonClicked(View sender)
    {
        //I want to change the text on my label
    }
}
