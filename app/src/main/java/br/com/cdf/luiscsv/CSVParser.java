package br.com.cdf.luiscsv;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jimy on 6/11/16.
 */
public class CSVParser {
    InputStream inputStream;
    BufferedReader reader;

    public CSVParser(InputStream inputStream) {
        this.inputStream = inputStream;
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public List<String> read()
    {
        List result = new ArrayList();
        int count = 1;
        try
        {
            String csvLine;
            while((csvLine = reader.readLine()) != null)
            {
                String[] row = csvLine.split(",");
                System.out.print("L" + count + ": ");
                for(String s:row)    System.out.print(s +" # ");
                if(row[2].equals("Cao"))    System.out.println(" auau");
                else System.out.println(" miau");
                count ++;
                result.add(row);
            }

        }catch(Exception e)
        {
            e.toString();
        }

        return result;
    }

    public String getValue(String key, int inputcolumn, int outputcolumn)
    {
        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null)
            {
                String[] row = csvLine.split(",");
                if(row[inputcolumn].toUpperCase().equals(key.toUpperCase()))    return row[outputcolumn];
            }
        }
        catch (Exception e)
        {
            e.toString();
        }
        return "Sem correspondencia";
    }

    public String getLineCSV1(String key, int inputcolumn, int outputcolumn, Segmento s)
    {
        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null)
            {
                String[] row = csvLine.split(",");
                if(row[inputcolumn].toUpperCase().equals(key.toUpperCase()))
                {
                    s.cnae = row[0];
                    s.descricao = row[1];
                    return row[outputcolumn];
                }
            }
        }
        catch (Exception e)
        {
            e.toString();
        }
        return "Sem correspondencia";
    }

    public boolean getLineCSV2(String key, int inputcolumn, Segmento s)
    {
        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null)
            {
                String[] row = csvLine.split(",");
                if(row[inputcolumn].toUpperCase().equals(key.toUpperCase()))
                {
                    s.macrosegmento = row[0];
                    s.nome = row[1];
                    s.mcc = row[2];
                    s.nome_mcc = row[3];
                    s.credito_a_vista = row[4];
                    s.psj_menor = row[5];
                    s.psj_maior = row[6];
                    s.debito = row[7];
                    s.elegivel = row[8];
                    s.carencia = row[9];
                    return true;
                }
            }
        }
        catch (Exception e)
        {
            e.toString();
        }
        return false;
    }
}
