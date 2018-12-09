package com.example.usuario.video18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private EditText et1, et2;
    private Spinner spinner1;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        tv1 = (TextView)findViewById(R.id.tv1);

        String [] opciones = {"Sumar","Restar","Multiplicar","Dividir"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_item_formato, opciones);
        spinner1.setAdapter(adapter);
    }

    //METODO DEL BOTON

       public  void  calcular(View view)
       {
           // MENSAJE PARA QUE NO SE CIERRE LA APP
           if(et1.getText().toString().trim().length() == 0 || et2.getText().toString().trim().length() == 0 )
           {

               Toast.makeText(this, "DEVES DE INGRESAR LOS VALORES Y QUE OPERACION QUIERES REALIZAR", Toast.LENGTH_LONG).show();
           }
           else
           {

              String valor1_string = et1.getText().toString();
              String valor2_string = et2.getText().toString();

              int valor1_int = Integer.parseInt(valor1_string);
              int valor2_int = Integer.parseInt(valor2_string);

              String seleccion = spinner1.getSelectedItem().toString();

             if (seleccion.equals("Sumar"))
              {
                 int suma = valor1_int + valor2_int;
                 String resultado = String.valueOf(suma);
                 tv1.setText(resultado);
              }
                else if (seleccion.equals("Restar"))
                {
                   int resta = valor1_int - valor2_int;
                   String resultado = String.valueOf(resta);
                   tv1.setText(resultado);
                }
                else if (seleccion.equals("Multiplicar"))
                {
                    int multiplicar = valor1_int * valor2_int;
                    String resultado = String.valueOf(multiplicar);
                    tv1.setText(resultado);
                }
                else if (seleccion.equals("Dividir"))
                {
                   if (valor2_int != 0)
                   {
                     int dividir = valor1_int / valor2_int;
                     String resultado = String.valueOf(dividir);
                     tv1.setText(resultado);
                   }
                       else
                       {
                         Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_LONG).show();
                       }

                }

           }
       }
}
//subido a GIF