package com.theironyard.contactsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener, View.OnClickListener {

    ArrayAdapter<String> items;

    ListView contactList;
    EditText phone;
    EditText name;
    Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactList = (ListView) findViewById(R.id.contactList);
        phone = (EditText) findViewById(R.id.phone);
        name = (EditText) findViewById(R.id.name);
        addButton = (Button) findViewById(R.id.addButton);


        contactList.setAdapter(items);

        addButton.setOnClickListener(this);
        contactList.setOnItemLongClickListener(this);

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String item = items.getItem(position);
        items.remove(item);
        return true;
    }

    @Override
    public void onClick(View v) {
        String itemN = name.getText().toString();
        String itemP = phone.getText().toString();
        name.setText("");
        phone.setText("");
    }
}
