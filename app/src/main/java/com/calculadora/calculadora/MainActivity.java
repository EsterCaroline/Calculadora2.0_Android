package com.calculadora.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro,
            numeroCinco, numeroSeis, numeroSete, numeroOito, numeroNove, ponto,
            soma, subtracao, multiplicacao, divisao, igual, botao_limpar;
    private TextView txvExpressao,txvResultado;
    private ImageView backspace;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IniciarComponentes();
        getSupportActionBar().hide();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);

        botao_limpar.setOnClickListener(view -> {
            txvExpressao.setText("");
            txvResultado.setText("");
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                TextView expressao =findViewById(R.id.txvExpressao);
                String string = expressao.getText().toString();
                if(!string.isEmpty()){
                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txvExpressao = string.substring(var0,var1);
                    expressao.setText(txvExpressao);
                }
                txvResultado.setText("");
            }
        });
            igual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View view) {
                    try {


                    Expression expressao = new ExpressionBuilder(txvExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if (resultado== (double) longResult){
                        txvResultado.setText((CharSequence) String.valueOf(longResult));
                    }else{
                        txvResultado.setText((CharSequence) String.valueOf(resultado));
                    }
                    }catch (Exception e){  }
                }

            });


    }
    private void IniciarComponentes(){
        numeroZero=findViewById(R.id.numero_zero);
        numeroUm=findViewById(R.id.numero_um);
        numeroDois=findViewById(R.id.numero_dois);
        numeroTres=findViewById(R.id.numero_tres);
        numeroQuatro=findViewById(R.id.numero_quatro);
        numeroCinco=findViewById(R.id.numero_cinco);
        numeroSeis=findViewById(R.id.numero_seis);
        numeroSete=findViewById(R.id.numero_sete);
        numeroOito=findViewById(R.id.numero_oito);
        numeroNove=findViewById(R.id.numero_nove);
        ponto=findViewById(R.id.ponto);
        soma=findViewById(R.id.soma);
        subtracao=findViewById(R.id.subtracao);
        multiplicacao=findViewById(R.id.multplicacao);
        divisao=findViewById(R.id.divisao);
        igual=findViewById(R.id.igual);
        botao_limpar=findViewById(R.id.limpar);
        txvExpressao=findViewById(R.id.txvExpressao);
        txvResultado=findViewById(R.id.txvResultado);
        backspace=findViewById(R.id.backspace);


    }
    public void AcrescentarUmaExpressao(String string ,boolean limpar_dados){
        if (txvResultado.getText().equals("")){
            txvExpressao.setText(" ");
    }
    if(limpar_dados){
        txvResultado.setText(" ");
        txvExpressao.append(string);

    }else{

        txvExpressao.append(txvResultado.getText());
        txvExpressao.append(string);
        txvResultado.setText(" ");
    }

  }

    @Override
    public void onClick (View view) {
        switch (view.getId()){
            case R.id.numero_zero:
                AcrescentarUmaExpressao("0",true);
                break;
            case R.id.numero_um:
                AcrescentarUmaExpressao("1",true);
                break;
            case R.id.numero_dois:
                AcrescentarUmaExpressao("2",true);
                break;
            case R.id.numero_tres:
                AcrescentarUmaExpressao("3",true);
                break;
            case R.id.numero_quatro:
                AcrescentarUmaExpressao("4",true);
                break;
            case R.id.numero_cinco:
                AcrescentarUmaExpressao("5",true);
                break;
            case R.id.numero_seis:
                AcrescentarUmaExpressao("6",true);
                break;
            case R.id.numero_sete:
                AcrescentarUmaExpressao("7",true);
                break;
            case R.id.numero_oito:
                AcrescentarUmaExpressao("8",true);
                break;
            case R.id.numero_nove:
                AcrescentarUmaExpressao("9",true);
                break;
            case R.id.ponto:
                AcrescentarUmaExpressao(".",true);
                break;
            case R.id.soma:
                AcrescentarUmaExpressao("+",false);
                break;
            case R.id.subtracao:
                AcrescentarUmaExpressao("-",false);
                break;
            case R.id.multplicacao:
                AcrescentarUmaExpressao("*",false);
                break;
            case R.id.divisao:
                AcrescentarUmaExpressao("/",false);
                break;
        }
    }
}