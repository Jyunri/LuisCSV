package br.com.cdf.luiscsv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Result extends AppCompatActivity {

    ListView lvresult;
    ArrayList<String> resultados;
    Button btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Segmento sresult = getIntent().getParcelableExtra("RESULTADO");

        lvresult = (ListView)findViewById(R.id.lvResult);
        btVoltar = (Button)findViewById(R.id.btVoltar);
        resultados = new ArrayList<>();

        ArrayList<String> campos = new ArrayList<>();

        campos.add("CNAE buscado:\n" + sresult.cnae);
        campos.add("Descricao buscada:\n" + sresult.descricao);
        campos.add("Macrosegmento:\n" + sresult.macrosegmento);
        campos.add("Nome:\n" + sresult.nome);
        campos.add("MCC:\n" + sresult.mcc);
        campos.add("Nome_MCC:\n"+sresult.nome_mcc);
        campos.add("Credito a vista:\n"+sresult.credito_a_vista);
        campos.add("PSJ_Menor:\n"+sresult.psj_menor);
        campos.add("PSJ_Maior:\n"+sresult.psj_maior);
        campos.add("Débito:\n"+sresult.debito);
        campos.add("Elegivel?\n"+sresult.elegivel);
        campos.add("Carencia:\n"+sresult.carencia);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.listview_results,campos);

        lvresult.setAdapter(adapter);

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setMessage(result)
//                .setTitle("Resultado");
//        AlertDialog dialog = builder.create();
//        dialog.show();
    }
}
