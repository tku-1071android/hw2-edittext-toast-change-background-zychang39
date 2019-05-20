package com.example.homework2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtH, edtW;
    TextView txvR, txvBMI;
    Button button;
    ImageView imageView;
    RadioGroup sex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtH = findViewById(R.id.edtH);
        edtW = findViewById(R.id.edtW);
        imageView = findViewById(R.id.imageView);
        sex = findViewById(R.id.sex);
        txvR = findViewById(R.id.txvR);
        txvBMI = findViewById(R.id.txvBMI);

    }

    public void calculate(View v) {
        if (edtH.getText().toString().length()!=0 && edtW.getText().toString().length()!= 0) {
            double h,h1,h2, w, bmi;
            h = Double.parseDouble(edtH.getText().toString());
            w = Double.parseDouble(edtW.getText().toString());
            h1 =h/100;
            h2 =h1*h1;
            bmi = w/h2;
            txvBMI.setText(String.format("%.1f",bmi));

            if (sex.getCheckedRadioButtonId() == R.id.rdbM) {
                if (bmi < 18.5) {
                    imageView.setImageResource(R.drawable.sad);
                    txvR.setText("男性，體重過輕");
                }
                else if (bmi >= 18.5 && bmi < 25) {
                    imageView.setImageResource(R.drawable.happy);
                    txvR.setText("男性，體重正常");
                }
                else if (bmi >= 25 && bmi < 30) {
                    imageView.setImageResource(R.drawable.sad);
                    txvR.setText("男性，體重過重");
                }
                else if (bmi >= 30 && bmi < 35) {
                    imageView.setImageResource(R.drawable.sad);
                    txvR.setText("男性，肥胖");
                }
                else if (bmi >= 35) {
                    imageView.setImageResource(R.drawable.sad);
                    txvR.setText("男性，極度肥胖");
                }
            } else {
                if (bmi < 18.5) {
                    imageView.setImageResource(R.drawable.sad);
                    txvR.setText("女性，體重過輕");
                }
                else if (bmi >= 18.5 && bmi < 25) {
                    imageView.setImageResource(R.drawable.happy);
                    txvR.setText("女性，體重正常");
                }
                else if (bmi >= 25 && bmi < 30) {
                    imageView.setImageResource(R.drawable.sad);
                    txvR.setText("女性，體重過重");
                }
                else if (bmi >= 30 && bmi < 35) {
                    imageView.setImageResource(R.drawable.sad);
                    txvR.setText("女性，肥胖");
                }
                else if (bmi>=35){
                    imageView.setImageResource(R.drawable.sad);
                    txvR.setText("女性，極度肥胖");
                }
            }
        } else {
            Toast toast = Toast.makeText(MainActivity.this, "身高體重不得空白!!", Toast.LENGTH_LONG);
            toast.show();


        }
    }
    public void finish (View v){
        AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
        adb.setTitle("確認視窗");
        adb.setIcon(R.mipmap.ic_launcher);
        adb.setMessage("確定要結束應用程式嗎?");
        adb.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        adb.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        adb.show();
    }
}