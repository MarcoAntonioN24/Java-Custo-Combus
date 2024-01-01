package com.example.custocombustivel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculo = findViewById(R.id.cal);
        Button cln = findViewById(R.id.limp);
        EditText l = findViewById(R.id.combu);
        EditText kml = findViewById(R.id.km);
        EditText d = findViewById(R.id.distan);
        TextView resultado = findViewById(R.id.result);

        cln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l.setText("");
                kml.setText("");
                d.setText("");
                resultado.setText("");

            }
        });

        calculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((l.getText().toString().trim().isEmpty())){

                    Toast.makeText(getApplicationContext(),"Insira o valor do litro",Toast.LENGTH_SHORT).show();
                    l.requestFocus();
                }
                if((kml.getText().toString().trim().isEmpty())){

                    Toast.makeText(getApplicationContext(),"Insira a quantidade de KM/L",Toast.LENGTH_SHORT).show();
                    kml.requestFocus();
                }
                else if((d.getText().toString().trim().isEmpty())){

                    Toast.makeText(getApplicationContext(),"Insira a distância",Toast.LENGTH_SHORT).show();
                    d.requestFocus();
                }
                else{
                    double litro = Double.parseDouble(l.getText().toString());
                    double kmpl = Double.parseDouble(kml.getText().toString());
                    double distancia = Double.parseDouble(d.getText().toString());
                    double calculofim = (litro/kmpl)*distancia;

                    resultado.setText("Você irá gastar em média R$ "+calculofim);

                }
            }
        });
    }
}