package com.example.rohit.myapplication;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    Secondclass db;
    EditText name, coun;
    Button add, view,update,delete,Quite;
    TextView tv1;
    public String valu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editText);
        coun = findViewById(R.id.editText2);
        add = findViewById(R.id.button);
        view = findViewById(R.id.button2);
        tv1 = findViewById(R.id.textView);
        db = new Secondclass(this);
        update = findViewById(R.id.update);
        delete=findViewById(R.id.delete);
        Quite=findViewById(R.id.Exit);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                boolean b = db.add(name.getText().toString(), coun.getText().toString());

                if (b == true) {

                    Toast.makeText(MainActivity.this, "Data saved!!!! ", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(MainActivity.this, "Data not saved!!! please  retry!!!!", Toast.LENGTH_LONG).show();

                }

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor ce = db.viewdata();
                if (ce.getCount() == 0) {

                    // showdata("Error","nothing data ");
                    tv1.setText("error no data !!!!");

                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (ce.moveToNext()) {
                    buffer.append("name:" + ce.getString(0) + "\n");
                    buffer.append("country:" + ce.getString(1) + "\n");

                }
                valu = buffer.toString();
                tv1.setText(valu);

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                boolean update = db.update(name.getText().toString(), coun.getText().toString());
                if (update == true) {
                    Toast.makeText(MainActivity.this, "Data   updated !!!", Toast.LENGTH_LONG).show();


                } else {
                    Toast.makeText(MainActivity.this, " not  updated!! ", Toast.LENGTH_LONG).show();

                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer delete =db.delete(name.getText().toString(), coun.getText().toString());
                if(delete!=0){
                    Toast.makeText(MainActivity.this, "Data has  been   deleted !!!", Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(MainActivity.this, "Data  not deleted !!", Toast.LENGTH_LONG).show();

                }
            }
        });
        Quite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

    }


//       }
}
