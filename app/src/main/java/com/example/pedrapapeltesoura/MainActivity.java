package com.example.pedrapapeltesoura;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selecionarPedra(View view){

        verificarGanhador("pedra");


    }
    public void selecionarPapel(View view){

        verificarGanhador("papel");


    }
    public void selecionarTesoura(View view){

        verificarGanhador("tesoura");


    }

    private String gerarEscolhaAleatoria() {

        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numeroAleatorio = new Random().nextInt(3);

        ImageView imagemApp = findViewById(R.id.imagem_app);
        String escolhaApp = opcoes[numeroAleatorio];
        switch (escolhaApp){
            case "pedra" :
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }

         return escolhaApp;


    }
    private void verificarGanhador(String escolhaUsuario){
        String escolhaApp = gerarEscolhaAleatoria();

        TextView textResultado = findViewById(R.id.text_resultado);

        if(
            (escolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
            (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
            (escolhaApp == "tesoura" && escolhaUsuario == "papel")

        ){
            textResultado.setText("DERROTA! :(");
            textResultado.setTextColor(Color.RED);
            textResultado.setTextSize(34);
            textResultado.setShadowLayer(5, 2, 2, Color.BLACK);

        }else if(

                (escolhaUsuario == "pedra" && escolhaApp == "tesoura") ||
                (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                (escolhaUsuario == "tesoura" && escolhaApp == "papel")
        ){

            textResultado.setText("VITÓRIA! :D");
            textResultado.setTextColor(Color.parseColor("#006600"));
            textResultado.setTextSize(34);
            textResultado.setShadowLayer(5, 2, 2, Color.BLACK);

        }else{
            textResultado.setText("EMPATE! :|");
            textResultado.setTextColor(Color.parseColor("#FFD700"));
            textResultado.setTextSize(34);
            textResultado.setShadowLayer(5, 2, 2, Color.BLACK);

        }

    }



}