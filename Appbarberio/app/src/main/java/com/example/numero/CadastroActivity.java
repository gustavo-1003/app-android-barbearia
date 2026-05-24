package com.example.numero;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etNome, etEmail, etSenha;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        etNome = findViewById(R.id.etNome);
        etEmail = findViewById(R.id.etEmail);
        etSenha = findViewById(R.id.etSenhaCadastro);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String nome = etNome.getText().toString();
        String email = etEmail.getText().toString();
        String senha = etSenha.getText().toString();

        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            mostrarMensagem("Preencha todos os campos!");
        } else {
            mostrarMensagem("Cadastro realizado com sucesso!");
            Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void mostrarMensagem(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Barbearia");
        builder.setMessage(msg);
        builder.setPositiveButton("OK", null);
        builder.show();
    }
}