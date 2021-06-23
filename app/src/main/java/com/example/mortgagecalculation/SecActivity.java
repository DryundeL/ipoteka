package com.example.mortgagecalculation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecActivity extends Activity {
    double everymonth_bet;
    double total;
    double everymonth_pay;
    double overpayenments;
    double all_money;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        EditText ed = (EditText)findViewById(R.id.editTextNumber);
        EditText ed1 = (EditText)findViewById(R.id.editTextNumber2);

        String procent = getIntent().getStringExtra("bank");

        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText("Процентная ставка: "+procent+"%");

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double percent = Double.parseDouble(procent);
                    double sum = Double.parseDouble(String.valueOf(ed.getText()));
                    double years = Double.parseDouble(String.valueOf(ed1.getText()));

                    everymonth_bet = percent / 12 / 100;
                    total = Math.pow((1 + everymonth_bet), years * 12);
                    everymonth_pay = sum * everymonth_bet * total / (total - 1);
                    String ev_pay = String.format("%.3f", everymonth_pay);
                    overpayenments = everymonth_pay * (years * 12) - sum;
                    String ovpay = String.format("%.3f", overpayenments);
                    all_money = everymonth_pay * (years * 12);
                    String all = String.format("%.3f", all_money);

                    System.out.println(everymonth_bet + "\n" + total + "\n" + everymonth_pay + "\n" + overpayenments + "\n" + all_money);

                    Intent intent = new Intent(SecActivity.this, ThirdActivity.class);
                    intent.putExtra("Sum", String.valueOf(Math.round(sum)));
                    intent.putExtra("All", all);
                    intent.putExtra("Pay", ev_pay);
                    intent.putExtra("Overpay", ovpay);
                    intent.putExtra("years", String.valueOf(Math.round(years)));
                    startActivity(intent);

                }
                catch (Exception e){
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Введите данные", Toast.LENGTH_SHORT);
                        toast.show();

                }
            }
        });
    }
}
