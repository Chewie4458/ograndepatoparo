package com.curso.clickerv3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Calendar;
import java.util.Formatter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String nome = "";

    public Formatter hora() {
        Formatter fmt = new Formatter();
        Calendar cal = Calendar.getInstance();
        fmt = new Formatter();
        fmt.format("%tl:%tM", cal, cal);
        System.out.println(fmt);
        return fmt;
    }

    public void vai(View view){
        TextView edtPergunta = findViewById(R.id.edtPergunta);
        TextView txtResposta = findViewById(R.id.txtResposta);
        TextView txtQuack = findViewById(R.id.txtQuack);
        TextView txtDica = findViewById(R.id.txtDica);

        ImageView imgPato = findViewById(R.id.imgPato);
        ImageView imgAmogus = findViewById(R.id.imgAmogus);
        ImageView imgPengo = findViewById(R.id.imgPengo);

        Random gerador = new Random();

        txtQuack.setText("QUACK");

        // gera um número de 0 a 10 se o número for divisivel por 3 o pato fala quack
        int num = gerador.nextInt(10);
        if(num % 3 == 0) {
            txtQuack.setVisibility(View.VISIBLE);
        }
        else {
            txtQuack.setVisibility(View.GONE);
        }

        String pergunta = edtPergunta.getText().toString();
        edtPergunta.setText("");

        System.out.println(pergunta);

        num = gerador.nextInt(10);
        if(num % 5 == 0) {
            imgPato.setVisibility(View.INVISIBLE);
            imgPengo.setVisibility(View.VISIBLE);
            txtResposta.setText("O PEQUENO GRANDE PENGUIM PENGO pede \nque você adivinhe o número secreto");
        }

        // else inutil
        else {
            imgPato.setVisibility(View.VISIBLE);
            imgPengo.setVisibility(View.GONE);
        }

        switch(pergunta) {
            case "oi":
                txtResposta.setText("Olhamasmaks");
                break;

            case "que horas são?":
                Calendar now = Calendar.getInstance();
                txtResposta.setText(now.get(Calendar.HOUR_OF_DAY) + ":" + now.get(Calendar.MINUTE));
                if(now.get(Calendar.HOUR_OF_DAY) == now.get(Calendar.MINUTE)) {
                    txtQuack.setText("Hummm...");
                    txtQuack.setVisibility(View.VISIBLE);
                }
                if(6 >= now.get(Calendar.HOUR_OF_DAY) || now.get(Calendar.HOUR_OF_DAY) >= 23) {
                    txtResposta.setText("O Grande Pato Paro pede para todos irem dormir.");
                    imgPato.setVisibility(View.GONE);
                    txtDica.setVisibility(View.GONE);
                }
                break;

            case "quantos anos você tem?":
                txtResposta.setText("MIL MILHÕES DE ANOS!!!!");
                break;

            case "whatsapp":
                txtResposta.setText("Muito soft");
                break;

            case "vetor":
                txtResposta.setText("AÉÉÉ");
                break;

            case "você gosta de gatos?":
                txtResposta.setText("Patos? Obvio!");
                break;

            case "você gosta de patos?":
                txtResposta.setText("Prefiro gatos.");
                break;

            case "amogus":
                imgAmogus.setVisibility(View.VISIBLE);
                txtDica.setText("sus");
                imgPato.setVisibility(View.GONE);

            case "nome seu qual é?":
                txtResposta.setText("Que?");
                break;

            case "qual é o seu nome?":
                txtResposta.setText("O Grande Pato Paro se recusa \na responder essa pergunta.");
                break;

            // não funcionando get text pega vazio pq tem q apertar o pato e o pato volta aaa
            case "qual é o meu nome?":
                if(nome == ""){
                    txtResposta.setText("Qual é o seu nome?");
                    nome = edtPergunta.getText().toString();
                }
                else {
                    txtResposta.setText("Humm... " + nome + "?");
                }
                break;

            case "ok":
                txtResposta.setText("Eu não falei nada.");
                break;

            case "meu deus":
                txtResposta.setText("meu senhor");
                break;

            // case penguim

            case "tchau":
                txtResposta.setText("O Grande Pato Paro se dispede de todos vocês!");
                imgPato.setVisibility(View.GONE);
                txtDica.setVisibility(View.GONE);
                break;

            default:
                txtResposta.setText("Não são todas as perguntas que o \ngrande Pato Paro pode responder.");
        }
    }


}