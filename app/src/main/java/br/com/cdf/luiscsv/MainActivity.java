package br.com.cdf.luiscsv;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btBuscar;
    Button btLimpar;
    AutoCompleteTextView acSearchValue;
    RadioGroup radioGroup;
    RadioButton radioButton;
    int selectedFilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recebe lista de nomes a serem utilizados para a funcao autocompletar
        String[] autocomplete = getResources().getStringArray(R.array.Descricoes);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,autocomplete);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        acSearchValue = (AutoCompleteTextView)findViewById(R.id.acSearchValue);

        acSearchValue.setAdapter(adapter);
        acSearchValue.setWidth(300);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectedFilter = checkedId;
                switch (checkedId) {
                    case (R.id.rbCNAE):
                        acSearchValue.setThreshold(Integer.MAX_VALUE);    //gambs para nao aparecer o autocomplete
                        acSearchValue.setHint("CODIGO CNAE");
                        break;
                    case (R.id.rbDescricao):
                        acSearchValue.setThreshold(3);
                        acSearchValue.setHint("DESCRIÇÃO");
                        break;
                }
            }
        });
        radioButton = (RadioButton)findViewById(R.id.rbCNAE);
        radioButton.setChecked(true);   //iniciar o default como CNAE

        btBuscar = (Button) findViewById(R.id.btBuscar);
        btBuscar.setOnClickListener(this);
        btLimpar = (Button) findViewById(R.id.btLimpar);
        btLimpar.setOnClickListener(this);


        acSearchValue.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    btBuscar.performClick();
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case (R.id.btBuscar):
                //Oculta o softKeyboard apos sair do EditText
                // Check if no view has focus:
                View view = this.getCurrentFocus();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }

                //Verifica qual filtro esta utilizando
                String stFilter = "";

                InputStream is = getResources().openRawResource(R.raw.cnaes);
                CSVParser csvFile = new CSVParser(is);
                String SV = acSearchValue.getText().toString();
                String MCC = "";

                switch (selectedFilter)
                {
                    case(R.id.rbCNAE)   :  MCC = csvFile.getValue(SV, 0, 2); stFilter = "CNAE "; break;
                    case(R.id.rbDescricao)   :  MCC = csvFile.getValue(SV, 1, 2); break;
                }

                InputStream is2 = getResources().openRawResource(R.raw.valores);
                CSVParser csvFile2 = new CSVParser(is2);

                //String CV = csvFile2.getValue(MCC,2,4);
                Segmento s = new Segmento();
                String result;
                if(csvFile2.getLine(MCC, 2, s)) result =  s.toString();
                else result = "Sem correspondencia para "+stFilter+SV;

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(result)
                        .setTitle("Resultado");
                AlertDialog dialog = builder.create();
                dialog.show();
                break;

            case (R.id.btLimpar):
                acSearchValue.setText("");
                break;

        }
    }
}
