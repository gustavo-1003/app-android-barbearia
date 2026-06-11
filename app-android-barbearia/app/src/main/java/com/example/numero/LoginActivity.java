package com.example.numero;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etUsuario, etSenha;
    Button btnLogin, btnCadastrar;
    barbeariadatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = barbeariadatabase.getInstance(this);

        etUsuario    = findViewById(R.id.etUsuario);
        etSenha      = findViewById(R.id.etSenha);
        btnLogin     = findViewById(R.id.btnLogin);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnLogin.setOnClickListener(v -> {
            String usuario = etUsuario.getText().toString().trim();
            String senha   = etSenha.getText().toString().trim();

            if (usuario.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                return;
            }

            Cliente cliente = db.dao().login(usuario, senha);

            if (cliente != null) {
                Toast.makeText(this, "Bem-vindo, " + cliente.nome + "!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, AgendamentoActivity.class);
                intent.putExtra("id_clientes", cliente.id_clientes);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos!", Toast.LENGTH_SHORT).show();
            }
        });

        btnCadastrar.setOnClickListener(v -> {
            startActivity(new Intent(this, CadastroActivity.class));
        });
    }
}