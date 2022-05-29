package com.example.calculatordanick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button button0;
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;
    public Button button7;
    public Button button8;
    public Button button9;
    public Button buttonPlus;
    public Button buttonMoins;
    public Button buttonDiv;
    public Button buttonMul;
    public Button buttonC;
    public Button buttonPoint;
    public Button buttonEgal;
    TextView ecran;

    private double chiffre1;
    private boolean clicOperateur = false;
    private boolean update = false;
    private String operateur = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonPoint = (Button) findViewById(R.id.buttonPoint);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMoins = (Button) findViewById(R.id.buttonMoins);
        buttonDiv = (Button) findViewById(R.id.buttonDivision);
        buttonMul = (Button) findViewById(R.id.buttonMultiplier);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonEgal = (Button) findViewById(R.id.buttonEgal);
        ecran = (TextView) findViewById(R.id.EditText01);


        buttonPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                plusClick();
            }

            private void plusClick() {
                if(clicOperateur){
                    calcul();
                    ecran.setText(String.valueOf(chiffre1));
                }else{
                    chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
                    clicOperateur = true;
                }
                operateur = "+";
                update = true;
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                divClick();
            }

            private void divClick() {
                if(clicOperateur){
                    calcul();
                    ecran.setText(String.valueOf(chiffre1));
                }else{
                    chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
                    clicOperateur = true;
                }
                operateur = "/";
                update = true;
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mulClick();
            }

            private void mulClick() {
                if(clicOperateur){
                    calcul();
                    ecran.setText(String.valueOf(chiffre1));
                }else{
                    chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
                    clicOperateur = true;
                }
                operateur = "*";
                update = true;
            }
        });

        buttonMoins.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moinsClick();
            }

            private void moinsClick() {
                if(clicOperateur){
                    calcul();
                    ecran.setText(String.valueOf(chiffre1));
                }else{
                    chiffre1 = Double.valueOf(ecran.getText().toString()).doubleValue();
                    clicOperateur = true;
                }
                operateur = "-";
                update = true;
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetClick();
            }

            private void resetClick() {
                clicOperateur = false;
                update = true;
                chiffre1 = 0;operateur = "";
                ecran.setText("");
            }
        });
        buttonEgal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egalClick();
            }

            private void egalClick() {
                calcul();
                update = true;
                clicOperateur = false;
            }
        });
        buttonPoint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick(".");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("9");
            }
        });
    }

    private void chiffreClick(String s) {
        if(update){
            update = false;
        }else{
            if(!ecran.getText().equals("0"))
                s = ecran.getText() + s;
        }
        ecran.setText(s);
    }

    private void calcul() {
            if(operateur.equals("+")){
                chiffre1 = chiffre1 +
                        Double.valueOf(ecran.getText().toString()).doubleValue();
                ecran.setText(String.valueOf(chiffre1));
            }
            if(operateur.equals("-")){
                chiffre1 = chiffre1 -
                        Double.valueOf(ecran.getText().toString()).doubleValue();
                ecran.setText(String.valueOf(chiffre1));
            }
            if(operateur.equals("*")){
                chiffre1 = chiffre1 *
                        Double.valueOf(ecran.getText().toString()).doubleValue();
                ecran.setText(String.valueOf(chiffre1));
            }
            if(operateur.equals("/")){
                try{
                    chiffre1 = chiffre1 /
                            Double.valueOf(ecran.getText().toString()).doubleValue();
                    ecran.setText(String.valueOf(chiffre1));
                }catch(ArithmeticException e){
                    ecran.setText("0");
                }
            }
        }
    }
