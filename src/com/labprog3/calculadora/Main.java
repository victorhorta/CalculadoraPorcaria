package com.labprog3.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {

    Button button1, button2, button3, button4, button5;
    EditText campoDeEntrada;
    TextView display;
    Double valorSalvo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Instanciando elementos do layout
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        campoDeEntrada = (EditText)findViewById(R.id.editText1);
        display = (TextView)findViewById(R.id.textView1);
        
        // Zerando os displays
        zeraConta();
        
        // Setando os listeners de cada botão
        button1.setOnClickListener(new OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                String textoInicial = campoDeEntrada.getText().toString();
                try {
                    valorSalvo += Double.parseDouble(textoInicial);
                    mostraValor(valorSalvo);
                } catch(Exception e) {
                    Toast.makeText(Main.this, "Operação Inválida", Toast.LENGTH_SHORT).show();
                    campoDeEntrada.setText("");
                }
            }
        });
        
        button2.setOnClickListener(new OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                String textoInicial = campoDeEntrada.getText().toString();
                try {
                    valorSalvo -= Double.parseDouble(textoInicial);
                    mostraValor(valorSalvo);
                } catch(Exception e) {
                    Toast.makeText(Main.this, "Operação Inválida", Toast.LENGTH_SHORT).show();
                    campoDeEntrada.setText("");
                }
            }
        });
        
        button3.setOnClickListener(new OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                String textoInicial = campoDeEntrada.getText().toString();
                try {
                    valorSalvo *= Double.parseDouble(textoInicial);
                    mostraValor(valorSalvo);
                } catch(Exception e) {
                    Toast.makeText(Main.this, "Operação Inválida", Toast.LENGTH_SHORT).show();
                    campoDeEntrada.setText("");
                }
            }
        });
        
        button4.setOnClickListener(new OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                String textoInicial = campoDeEntrada.getText().toString();
                try {
                    valorSalvo /= Double.parseDouble(textoInicial);
                    mostraValor(valorSalvo);
                } catch(Exception e) {
                    Toast.makeText(Main.this, "Operação Inválida", Toast.LENGTH_SHORT).show();
                    campoDeEntrada.setText("");
                }
            }
        });
        
        button5.setOnClickListener(new OnClickListener() { 
            @Override
            public void onClick(View arg0) {
                zeraConta();
            }
        });
    }
    
    // Helper methods
    public void zeraConta() {
        valorSalvo = 0.0;
        campoDeEntrada.setText("");
        display.setText("0.0");
    }
    
    public void mostraValor(double valor) {
        valorSalvo = valor;
        campoDeEntrada.setText("");
        display.setText(Double.toString(valor));
    }
}
