package com.example.numero;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    EditText etNome, etEmail, etSenha;
    Button btnCadastrar;
    barbeariadatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        db = barbeariadatabase.getInstance(this);

        etNome       = findViewById(R.id.etNome);
        etEmail      = findViewById(R.id.etEmail);
        etSenha      = findViewById(R.id.etSenhaCadastro);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(v -> {
            String nome  = etNome.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String senha = etSenha.getText().toString().trim();

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                return;
            }

            Cliente cliente = new Cliente();
            cliente.nome  = nome;
            cliente.email = email;
            cliente.senha = senha;

            db.dao().inserirCliente(cliente);

            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}