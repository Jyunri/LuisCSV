package br.com.cdf.luiscsv;

/**
 * Created by Jimy on 6/14/16.
 */
public class Segmento {
    String macrosegmento, nome, mcc, nome_mcc, credito_a_vista, psj_menor, psj_maior, debito, elegivel, carencia;

    public Segmento(){}

    public Segmento(String macrosegmento, String nome, String mcc, String nome_mcc, String credito_a_vista, String psj_menor, String psj_maior, String debito, String elegivel, String carencia) {
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
        return  "macrosegmento: '" + macrosegmento + '\'' + '\n' +
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
}

