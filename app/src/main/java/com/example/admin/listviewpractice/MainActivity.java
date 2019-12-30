package com.example.admin.listviewpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText editText1,editText2;
    Button button;
    ArrayList<Student> arrayList;
    MyAdapter myAdapter;
    ListView listView;
    int counter=0;

    public class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Student student = arrayList.get(position);
            View view = getLayoutInflater().inflate(R.layout.row,parent,false);
            TextView tv1 = (TextView)view.findViewById(R.id.tv1);
            TextView tv2 = (TextView)view.findViewById(R.id.tv2);
            TextView tv3 = (TextView)view.findViewById(R.id.tv3);
            tv1.setText(student.getSno());
            tv2.setText(student.getName());
            tv3.setText(student.getSubject());
            return view;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.et1);
        editText2 = (EditText) findViewById(R.id.et2);
        button = (Button) findViewById(R.id.b1);
        arrayList = new ArrayList<>();
        myAdapter = new MyAdapter();
        listView = (ListView) findViewById(R.id.lv);
        listView.setAdapter(myAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                String name  = editText1.getText().toString();
                String subject = editText2.getText().toString();
                Student student = new Student(""+counter,name,subject);
                arrayList.add(student);
                editText1.setText("");
                editText2.setText("");
                myAdapter.notifyDataSetChanged();
                editText1.requestFocus();
            }
        });
    }
}
