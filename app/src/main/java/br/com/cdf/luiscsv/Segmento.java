package br.com.cdf.luiscsv;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jimy on 6/14/16.
 */
public class Segmento implements Parcelable{
    String cnae, descricao, macrosegmento, nome, mcc, nome_mcc, credito_a_vista, psj_menor, psj_maior, debito, elegivel, carencia;

    public Segmento(){}

    public Segmento(String cnae,String macrosegmento, String nome, String mcc, String nome_mcc, String credito_a_vista, String psj_menor, String psj_maior, String debito, String elegivel, String carencia) {
        this.cnae = cnae;
        this.descricao = descricao;
        this.macrosegmento = macrosegmento;
        this.nome = nome;
        this.mcc = mcc;
        this.nome_mcc = nome_mcc;
        this.credito_a_vista = credito_a_vista;
        this.psj_menor = psj_menor;
        this.psj_maior = psj_maior;
        this.debito = debito;
        this.elegivel = elegivel;
        this.carencia = carencia;
    }


    @Override
    public String toString() {
        return  "cnae: '" + cnae + '\'' + '\n' +
                "descricao: '" + descricao + '\'' + '\n' +
                "macrosegmento: '" + macrosegmento + '\'' + '\n' +
                "nome: '" + nome + '\'' + '\n' +
                "mcc: '" + mcc + '\'' + '\n' +
                "nome_mcc: '" + nome_mcc + '\'' + '\n' +
                "credito_a_vista: '" + credito_a_vista + '\'' + '\n' +
                "psj_menor: '" + psj_menor + '\'' + '\n' +
                "psj_maior: '" + psj_maior + '\'' + '\n' +
                "debito: '" + debito + '\'' + '\n' +
                "elegivel: '" + elegivel + '\'' + '\n' +
                "carencia: '" + carencia + '\'' ;
    }


    protected Segmento(Parcel in) {
        cnae = in.readString();
        descricao = in.readString();
        macrosegmento = in.readString();
        nome = in.readString();
        mcc = in.readString();
        nome_mcc = in.readString();
        credito_a_vista = in.readString();
        psj_menor = in.readString();
        psj_maior = in.readString();
        debito = in.readString();
        elegivel = in.readString();
        carencia = in.readString();
    }

    public static final Creator<Segmento> CREATOR = new Creator<Segmento>() {
        @Override
        public Segmento createFromParcel(Parcel in) {
            return new Segmento(in);
        }

        @Override
        public Segmento[] newArray(int size) {
            return new Segmento[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cnae);
        dest.writeString(descricao);
        dest.writeString(macrosegmento);
        dest.writeString(nome);
        dest.writeString(mcc);
        dest.writeString(nome_mcc);
        dest.writeString(credito_a_vista);
        dest.writeString(psj_menor);
        dest.writeString(psj_maior);
        dest.writeString(debito);
        dest.writeString(elegivel);
        dest.writeString(carencia);
    }
}

