package com.example.mortgagecalculation;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        double sberProc = 10.6;
        double otkProc = 7.8;
        double vtbProc = 8.6;
        double alphaProc = 5.3;
        double mailProc = 2;


        Intent second = new Intent(MainActivity.this, SecActivity.class);
        Button sber =(Button) findViewById(R.id.Sber);
        Button otk =(Button) findViewById(R.id.Otk);
        Button alpha =(Button) findViewById(R.id.Alpha);
        Button vtb =(Button) findViewById(R.id.VTB);
        Button mail =(Button) findViewById(R.id.Mail);
        sber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                second.putExtra("bank", String.valueOf(sberProc));
                startActivity(second);
            }
        });
        otk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                second.putExtra("bank", String.valueOf(otkProc));
                startActivity(second);
            }
        });
       alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                second.putExtra("bank", String.valueOf(alphaProc));
                startActivity(second);
            }
        });
        vtb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                second.putExtra("bank", String.valueOf(vtbProc));
                startActivity(second);
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                second.putExtra("bank", String.valueOf(mailProc));
                startActivity(second);
            }
        });

    }


}