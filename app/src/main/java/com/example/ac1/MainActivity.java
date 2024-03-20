package com.example.ac1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int quantidadeLanche = 0;
    private int quantidadeAcompanhamento = 0;
    private int quantidadeBebida = 0;

    private TextView quantidadeTextViewLanche;
    private TextView quantidadeTextViewAcompanhamento;
    private TextView quantidadeTextViewBebida;
    private TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialização dos elementos de UI
        quantidadeTextViewLanche = findViewById(R.id.quantidadeTextViewLanche);
        quantidadeTextViewAcompanhamento = findViewById(R.id.quantidadeTextViewAcompanhamento);
        quantidadeTextViewBebida = findViewById(R.id.quantidadeTextViewBebida);
        totalTextView = findViewById(R.id.btnCalcularTotal);

        // Definição dos listeners para os botões de cada categoria
        Button btnMenosLanche = findViewById(R.id.btnMenosLanche);
        Button btnMaisLanche = findViewById(R.id.btnMaisLanche);
        Button btnMenosAcompanhamento = findViewById(R.id.btnMenosAcompanhamento);
        Button btnMaisAcompanhamento = findViewById(R.id.btnMaisAcompanhamento);
        Button btnMenosBebida = findViewById(R.id.btnMenosBebida);
        Button btnMaisBebida = findViewById(R.id.btnMaisBebida);
        Button btnCalcularTotal = findViewById(R.id.btnCalcularTotal);
        Button btnLimparPedido = findViewById(R.id.btnLimparPedido);

        // Definição dos listeners
        btnMenosLanche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removerDoCarrinhoLanche();
            }
        });

        btnMaisLanche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarAoCarrinhoLanche();
            }
        });

        btnMenosAcompanhamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removerDoCarrinhoAcompanhamento();
            }
        });

        btnMaisAcompanhamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarAoCarrinhoAcompanhamento();
            }
        });

        btnMenosBebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removerDoCarrinhoBebida();
            }
        });

        btnMaisBebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarAoCarrinhoBebida();
            }
        });

        btnCalcularTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularTotal();
            }
        });

        btnLimparPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparPedido();
            }
        });
    }

    private void adicionarAoCarrinhoLanche() {
        quantidadeLanche++;
        quantidadeTextViewLanche.setText(String.valueOf(quantidadeLanche));
    }

    private void removerDoCarrinhoLanche() {
        if (quantidadeLanche > 0) {
            quantidadeLanche--;
            quantidadeTextViewLanche.setText(String.valueOf(quantidadeLanche));
        }
    }

    private void adicionarAoCarrinhoAcompanhamento() {
        quantidadeAcompanhamento++;
        quantidadeTextViewAcompanhamento.setText(String.valueOf(quantidadeAcompanhamento));
    }

    private void removerDoCarrinhoAcompanhamento() {
        if (quantidadeAcompanhamento > 0) {
            quantidadeAcompanhamento--;
            quantidadeTextViewAcompanhamento.setText(String.valueOf(quantidadeAcompanhamento));
        }
    }

    private void adicionarAoCarrinhoBebida() {
        quantidadeBebida++;
        quantidadeTextViewBebida.setText(String.valueOf(quantidadeBebida));
    }

    private void removerDoCarrinhoBebida() {
        if (quantidadeBebida > 0) {
            quantidadeBebida--;
            quantidadeTextViewBebida.setText(String.valueOf(quantidadeBebida));
        }
    }

    private void calcularTotal() {
        double total = (quantidadeLanche * 13) + (quantidadeAcompanhamento * 10) + (quantidadeBebida * 9);
        totalTextView.setText("Total: R$ " + total);
    }

    private void limparPedido() {
        quantidadeLanche = 0;
        quantidadeAcompanhamento = 0;
        quantidadeBebida = 0;
        quantidadeTextViewLanche.setText("0");
        quantidadeTextViewAcompanhamento.setText("0");
        quantidadeTextViewBebida.setText("0");
        totalTextView.setText("Total: R$ 0.00");
    }
}
