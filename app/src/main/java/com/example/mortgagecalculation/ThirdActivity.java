package com.example.mortgagecalculation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        String sum = getIntent().getStringExtra("Sum");
        String all = getIntent().getStringExtra("All");
        String pay = getIntent().getStringExtra("Pay");
        String overpay = getIntent().getStringExtra("Overpay");
        String years = getIntent().getStringExtra("years");

//        System.out.println(sum+ " " + all+ " "+ pay+ " "+ overpay + " " + years);
        TextView tv = (TextView) findViewById(R.id.grab);
        tv.setText("Вы взяли в ипотеку " + sum + " грошей"+"\n\nНа " + years + " лет" + "\n\nВаш ежемесячный платеж: "+ pay + " грошей"+"\n\nПереплата составляет: " + overpay +
                " грошей"+"\n\nОбщая сумма которую придется отдать: " + all + " грошей");
        Button cong = (Button) findViewById(R.id.cong);
        cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Это программу сделали Дмитриев А.Д. и Погорелов Е.А.", Toast.LENGTH_LONG);
                toast.show();
                Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
