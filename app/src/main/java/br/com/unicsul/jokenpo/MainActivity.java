package br.com.unicsul.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnReiniciar;
    private TextView txtVencedor;
    private TextView txtValuePlayer;
    private TextView txtValueRobo;
    private int pontosPlayer;
    private int pontosRobo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValuePlayer = findViewById(R.id.txtValuePlayer);
        txtValueRobo = findViewById(R.id.txtValueRobo);

        pontosPlayer = 0;
        pontosRobo = 0;
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {
        if (pontosPlayer == 3 || pontosRobo == 3) {
            return;
        }
        ImageView imagemResultado = findViewById(R.id.imagemResultado);
        ImageView imagemResultado2 = findViewById(R.id.imagemResultado2);
        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp) {
            case "pedra":
                imagemResultado.setImageResource(R.drawable.img_pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.img_papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.img_tesoura);
                break;

        }

        if (
                (opcaoApp.equals("tesoura") && opcaoSelecionada.equals("papel")) ||
                        (opcaoApp.equals("papel") && opcaoSelecionada.equals("pedra")) ||
                        (opcaoApp.equals("pedra") && opcaoSelecionada.equals("tesoura"))
        ){
            imagemResultado2.setImageResource(R.drawable.perdeu);
            pontosRobo++;
        }
        else if (
                (opcaoSelecionada.equals("tesoura") && opcaoApp.equals("papel")) ||
                        (opcaoSelecionada.equals("papel") && opcaoApp.equals("pedra")) ||
                        (opcaoSelecionada.equals("pedra") && opcaoApp.equals("tesoura"))
        ){
            imagemResultado2.setImageResource(R.drawable.felicidade);
            pontosPlayer++;
        }
        else {
            imagemResultado2.setImageResource(R.drawable.empate);
        }

        txtValuePlayer.setText(String.valueOf(pontosPlayer));
        txtValueRobo.setText(String.valueOf(pontosRobo));
        txtValuePlayer.setText(String.valueOf(pontosPlayer));
        txtValueRobo.setText(String.valueOf(pontosRobo));

        if (pontosPlayer == 3 || pontosRobo == 3) {

            if (pontosPlayer == 3) {
                exibirVencedor("Casa");
            } else {
                exibirVencedor("Visitante");
            }
        }
    }
    private void exibirVencedor(String vencedor) {
        txtVencedor = findViewById(R.id.txtVencedor);
        txtVencedor.setText(vencedor + " Fez um ótimo jogo!");
        txtVencedor.setVisibility(View.VISIBLE);
        btnReiniciar = findViewById((R.id.btnReiniciar));
        btnReiniciar.setVisibility(View.VISIBLE);

    }
    public void resetarJogo(View view) {
        pontosPlayer = 0;
        pontosRobo = 0;
        txtValuePlayer.setText("0");
        txtValueRobo.setText("0");
        txtVencedor.setVisibility(View.GONE);
        btnReiniciar.setVisibility(View.GONE);
    }
}

