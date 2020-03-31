package com.example.gocorona;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class GetTracedUser extends AppCompatActivity {

    DatabaseConnectivity db;
    TextView tdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_traced_user);

        db=new DatabaseConnectivity(getApplicationContext());

        tdata=findViewById(R.id.data);

        Cursor c=db.getTracedUser();
        if(c.getCount()>0){
            String x="";
            while(c.moveToNext()){
                x=x+"\n"+c.getString(0)+" "+c.getString(1)+" "+c.getString(2);
            }
            tdata.setText(x);
        }
        else{
            tdata.setText("NULL");
        }

    }
}
