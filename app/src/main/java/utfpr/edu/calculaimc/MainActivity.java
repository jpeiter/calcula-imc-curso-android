package utfpr.edu.calculaimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etPeso;
    private EditText etAltura;
    private TextView tvResultado;
    private Button btCalcular;
    private Button btLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        * Atribuir valores
        * dos elementos
        * vindos do XML
        * */
        etPeso = findViewById(R.id.etPeso); // recebe valor do etPeso do XML
        etAltura = findViewById(R.id.etAltura); // recebe valor do etAltura do XML
        tvResultado = findViewById(R.id.tvResultado); // recebe valor do tvResultado do XML
        btCalcular = findViewById(R.id.btCalcular);
        btLimpar = findViewById(R.id.btLimpar);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        if (etPeso.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Informe o peso", Toast.LENGTH_LONG).show();
            etPeso.requestFocus();
            return;
        }
        if(etAltura.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Informe a altura", Toast.LENGTH_LONG).show();
            etAltura.requestFocus();
            return;
        }

        double peso = Double.parseDouble( etPeso.getText().toString() );
        double altura = Double.parseDouble( etAltura.getText().toString() );

        double resultado = peso / Math.pow(altura, 2);

        if(resultado < 18.5){
            Toast.makeText(this, "Nível: Magreza", Toast.LENGTH_SHORT).show();
        }else if(resultado >= 18.5 && resultado <= 24.9){
            Toast.makeText(this, "Nível: Saudável", Toast.LENGTH_SHORT).show();
        }else if(resultado >= 25 && resultado <= 29.9){
            Toast.makeText(this, "Nível: Sobrepeso", Toast.LENGTH_SHORT).show();
        }else if(resultado >= 30 && resultado <= 34.9){
            Toast.makeText(this, "Nível: Obesidade Grau 1", Toast.LENGTH_SHORT).show();
        }else if(resultado >= 35 && resultado <= 39.9){
            Toast.makeText(this, "Nível: Obesidade Grau 2", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Nível: Obesidade Grau 3", Toast.LENGTH_SHORT).show();
        }

        tvResultado.setText(new DecimalFormat("0.00").format(resultado));
    }


}
