package com.n3twork.encriptarlenguaje;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTexto;
    private Button btnOk, btnClear;
    private TextView textViewResultado;
    private RadioButton rbEncriptar, rbDesencriptar;
    String cadena = "", cadena2 = "";
    char vocales[] = new char[]{'a', 'e', 'i', 'o', 'u'};
    char consonantes[] = new char[]{
            'b', 'c', 'd',
            'f', 'g', 'j',
            'k', 'l', 'm',
            'n', 'p', 'q',
            'r', 's', 't',
            'v', 'w', 'x',
            'y', 'z'
    };

    char consonantes2[] = new char[]{
            'B', 'C', 'D',
            'F', 'G', 'J',
            'K', 'L', 'M',
            'N', 'P', 'Q',
            'R', 'S', 'T',
            'V', 'W', 'X',
            'Y', 'Z'
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTexto = findViewById(R.id.editTextTexto);
        btnOk = findViewById(R.id.btnOk);
        textViewResultado = findViewById(R.id.textViewResultado);
        rbEncriptar = findViewById(R.id.rbEncriptar);
        rbDesencriptar = findViewById(R.id.rbDesenciptar);
        btnClear = findViewById(R.id.btnClear);

        rbEncriptar.setChecked(true);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textViewResultado.setText(capturarDatos());

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    textViewResultado.setText("");
                    editTextTexto.setText("");
                    rbEncriptar.setChecked(true);

                    Toast.makeText(getApplicationContext(),"Borrado!", Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    Log.e("Error", "Error: " +e.getMessage());
                }
            }
        });

    }

    private String capturarDatos() {

        cadena = editTextTexto.getText().toString();

        if (!cadena.isEmpty() && rbEncriptar.isChecked()) {

            encriptar();
        } else if (cadena.isEmpty() && rbEncriptar.isChecked()) {

            Toast.makeText(getApplicationContext(), "Escriba un texto", Toast.LENGTH_SHORT).show();

        } else if (!cadena.isEmpty() && rbDesencriptar.isChecked()) {

            desencriptar();
//            desencriptarUpercase();


        } else if (cadena.isEmpty() && rbDesencriptar.isChecked()) {

            Toast.makeText(getApplicationContext(), "Escriba un texto", Toast.LENGTH_SHORT).show();

        }

        return cadena2;


    }

    public void encriptar() {

        char array[] = cadena.toCharArray();

        for (int i = 0; i <= array.length; i++) {
            int contador = 0;
            boolean control = false;

            try {

                if (array[i] == 'u') {
                    array[i] = 'a';
                } else if(array[i] == 'ü') {
                    array[i] = 'ä';
                } else if(array[i] == 'U'){
                    array[i] = 'A';
                } else if(array[i] == 'Ü') {
                    array[i] = 'Ä';
                } else if(array[i] == 'ú'){
                    array[i] = 'á';
                } else if(array[i] == 'Ú'){
                    array[i] = 'Á';
                } else if(array[i] == 'á') {
                    array[i] = 'é';
                } else if(array[i] == 'A'){
                    array[i] = 'E';
                } else if(array[i] == 'Á'){
                    array[i] = 'É';
                } else if(array[i] == 'é') {
                    array[i] = 'í';
                } else if(array[i] == 'E'){
                    array[i] = 'I';
                } else if(array[i] == 'É'){
                    array[i] = 'Í';
                } else if(array[i] == 'I'){
                    array[i] = 'O';
                } else if(array[i] == 'í'){
                    array[i] = 'ó';
                } else if(array[i] == 'Í'){
                    array[i] = 'Ó';
                } else if(array[i] == 'ó'){
                    array[i] = 'ú';
                } else if(array[i] == 'O'){
                    array[i] = 'U';
                } else if(array[i] == 'Ó'){
                    array[i] = 'Ú';

                } else {

                    do {

                        if (array[i] == vocales[contador]) {
                            char aux = vocales[contador + 1];
                            array[i] = aux;
                            control = true;

                        } else {

                            contador++;

                        }

                    } while (contador < vocales.length && !control);

                }

            } catch (Exception e) {
                Log.e("Error", "Error: " + e.getMessage());
            }

            contador = 0;
            control = false;

            try {

                if (array[i] == 'z') {
                    array[i] = 'b';
                } else if(array[i] == 'Z'){
                    array[i] = 'B';
                } else {

                    do {

                        if (array[i] == consonantes[contador]) {
                            char aux = consonantes[contador + 1];
                            array[i] = aux;
                            control = true;

                        } else {

                            contador++;

                        }

                    } while (contador < consonantes.length && !control);

                    contador = 0;
                    control = false;

                    do {

                        if (array[i] == consonantes2[contador]) {
                            char aux = consonantes2[contador + 1];
                            array[i] = aux;
                            control = true;

                        } else {

                            contador++;

                        }

                    } while (contador < consonantes2.length && !control);
                }

            } catch (Exception e) {
                Log.e("Error", "Error: " + e.getMessage());

            }

        }

        cadena2 = String.valueOf(array);

    }

    public void desencriptar() {

        char array[] = cadena.toCharArray();

        for (int i = 0; i <= array.length; i++) {
            int contador = vocales.length - 1;
            boolean control = false;

            try {

                if (array[i] == 'a') {
                    array[i] = 'u';
                }else if(array[i] == 'á') {
                    array[i] = 'ú';
                } else if(array[i] == 'ä'){
                    array[i] = 'ü';
                } else if(array[i] == 'A') {
                    array[i] = 'U';
                } else if(array[i] == 'Á'){
                    array[i] = 'Ú';
                } else if(array[i] == 'Ä'){
                    array[i] = 'Ü';
                } else if(array[i] == 'é'){
                    array[i] = 'á';
                } else if(array[i] == 'E'){
                    array[i] = 'A';
                } else if(array[i] == 'É'){
                    array[i] = 'Á';
                } else if(array[i] == 'í'){
                    array[i] = 'é';
                } else if(array[i] == 'I'){
                    array[i] = 'E';
                } else if(array[i] == 'Í'){
                    array[i] = 'É';
                } else if(array[i] == 'ó'){
                    array[i] = 'í';
                } else if(array[i] == 'O'){
                    array[i] = 'I';
                } else if(array[i] == 'Ó'){
                    array[i] = 'Í';
                } else if(array[i] == 'ú'){
                    array[i] = 'ó';
                } else if(array[i] == 'U'){
                    array[i] = 'O';
                } else if(array[i] == 'Ú'){
                    array[i] = 'Ó';


                } else {

                    do {

                        if (array[i] == vocales[contador]) {
                            char aux = vocales[contador - 1];
                            array[i] = aux;
                            control = true;

                        } else {

                            contador--;

                        }

                    } while (contador > -1 && !control);

                }

            } catch (Exception e) {
                Log.e("Error", "Error: " + e.getMessage());
            }

            contador = consonantes.length - 1;
            control = false;

            try {

                if (array[i] == 'b') {
                    array[i] = 'z';
                } else if (array[i] == 'B'){
                    array[i] = 'Z';

                } else {

                    do {

                        if (array[i] == consonantes[contador]) {
                            char aux = consonantes[contador - 1];
                            array[i] = aux;
                            control = true;

                        } else {

                            contador--;

                        }

                    } while (contador > -1 && !control);

                    contador = consonantes.length - 1;
                    control = false;

                    do {

                        if (array[i] == consonantes2[contador]) {
                            char aux = consonantes2[contador - 1];
                            array[i] = aux;
                            control = true;

                        } else {

                            contador--;

                        }

                    } while (contador > -1 && !control);
                }

            } catch (Exception e) {
                Log.e("Error", "Error: " + e.getMessage());

            }

        }

        cadena2 = String.valueOf(array);

    }

//    public void desencriptarUpercase() {
//
//        char array[] = cadena.toCharArray();
//
//        for (int i = 0; i <= array.length; i++) {
//            int contador = vocales2.length - 1;
//            boolean control = false;
//
//            try {
//
//                if (array[i] == 'A') {
//                    array[i] = 'U';
//
//                } else {
//
//                    do {
//
//                        if (array[i] == vocales2[contador]) {
//                            char aux = vocales2[contador - 1];
//                            array[i] = aux;
//                            control = true;
//
//                        } else {
//
//                            contador--;
//
//                        }
//
//                    } while (contador > -1 && !control);
//                }
//
//            } catch (Exception e) {
//                Log.e("Error", "Error: " + e.getMessage());
//            }
//
//            contador = consonantes2.length - 1;
//            control = false;
//
//            try {
//
//                if (array[i] == 'B') {
//                    array[i] = 'Z';
//
//                } else {
//
//                    do {
//
//                        if (array[i] == consonantes2[contador]) {
//                            char aux = consonantes2[contador - 1];
//                            array[i] = aux;
//                            control = true;
//
//                        } else {
//
//                            contador--;
//
//                        }
//
//                    } while (contador > -1 && !control);
//                }
//
//            } catch (Exception e) {
//                Log.e("Error", "Error: " + e.getMessage());
//
//            }
//
//        }
//
//        cadena2 = String.valueOf(array);
//    }
}