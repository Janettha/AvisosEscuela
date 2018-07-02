package com.tecnoanca.anca.avisosescuela;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.tecnoanca.anca.avisosescuela.Docentes.DocentesVO;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {

    Button button;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       FirebaseMessaging.getInstance().subscribeToTopic("test");
       FirebaseInstanceId.getInstance().getToken();

       button = findViewById(R.id.button);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, DocentesVO.class);
               startActivity(intent);
           }
       });

    }

}
