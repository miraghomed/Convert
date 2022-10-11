package com.example.convert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etValue;
    private TextView tvRes;
    private Button btnConv;
    private Spinner Spin1, Spin2;
    private RadioButton b1,b2;

    private ImageView ivCurrency1, ivCurrency2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectComponents();
    }

    private void connectComponents() {
        etValue = findViewById(R.id.etValueMain);
        tvRes = findViewById(R.id.tvResMain);
        btnConv = findViewById(R.id.btnConvMain);
        Spin1 = findViewById(R.id.Spin1Main);
        Spin2 = findViewById(R.id.Spin2Main);

        ivCurrency1 = findViewById(R.id.ivCurrency1Main);
        ivCurrency2 = findViewById(R.id.ivCurrency2Main);
    }

    public void convert(View view) {
        String s1, s2, c;
        c = etValue.getText().toString();
        double sum;
        double curr = Double.parseDouble(c);
        s1 = Spin1.getSelectedItem().toString();
        s2 = Spin2.getSelectedItem().toString();
        if (s1 == s2) {
            tvRes.setText("" + curr);
        } else if (s1.equals("dollar")) {
            ivCurrency1.setImageResource(R.drawable.dollar);
            if (s2.equals("shekel")) {
                sum = curr * 3.56;
                tvRes.setText("ILS" + sum);
                return;
            }
            ivCurrency2.setImageResource(R.drawable.euro);
        } else if (s1.equals("shekel")) {
            ivCurrency2.setImageResource(R.drawable.euro);
            if (s2.equals("dollar")) {
                sum = curr * 0.28;
                tvRes.setText("$" + sum);

                return;
            }
            ivCurrency1.setImageResource(R.drawable.dollar);
        } else {
            if (s2.equals("shekel")) {
                sum = curr * 3.48;
                tvRes.setText("ILS" + sum);
            }
            return;
        }

    }

    public void click(View view) {
        boolean checked = ((RadioButton) view).isChecked();

    }
