package com.curso.clickerv3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void vai(View view){
        TextView edtPergunta = findViewById(R.id.edtPergunta);
        TextView txtResposta = findViewById(R.id.txtResposta);
        TextView txtQuack = findViewById(R.id.txtQuack);
        TextView txtDica = findViewById(R.id.txtDica);
        ImageView imgPato = findViewById(R.id.imgPato);
        Random gerador = new Random();

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

        String nome = "";
        System.out.println(pergunta);

        switch(pergunta) {
            case "oi":
                txtResposta.setText("Olhamasmaks");
                break;

            // case que horas são

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

            // case amogus
            case "nome seu qual é?":
                txtResposta.setText("Que?");
                break;

            case "qual é o seu nome?":
                txtResposta.setText("O Grande Pato Paro se recusa a responder essa pergunta.");
                break;

            case "qual é o meu nome?":
                if(nome == ""){
                    txtResposta.setText("Qual é o seu nome?");
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
                txtResposta.setText("Não são todas as perguntas que o grande Pato Paro pode responder.");
        }
    }


}