package com.theannguyen.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.myListView);
        arrayList = new ArrayList<>();
        addDataArray();

        arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ConfirmDelete(position);
            }
        });

    }
    private void ConfirmDelete(final int index){
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Confirm Delete Item");
        alert.setIcon(R.mipmap.ic_launcher);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                arrayList.remove(index);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.create().show();
    }
    private void addDataArray() {
        arrayList.add("IOS");
        arrayList.add("Android");
        arrayList.add("Unity");
        arrayList.add("IOS");
        arrayList.add("Android");
        arrayList.add("Unity");
        arrayList.add("IOS");
        arrayList.add("Android");
        arrayList.add("Unity");
    }
}
