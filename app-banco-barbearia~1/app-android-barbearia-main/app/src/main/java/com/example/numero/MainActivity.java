package com.example.numero;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUsuario, etSenha;
    private Button btnLogin, btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = findViewById(R.id.etUsuario);
        etSenha = findViewById(R.id.etSenha);
        btnLogin = findViewById(R.id.btnLogin);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnLogin.setOnClickListener(this);
        btnCadastrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String usuario = etUsuario.getText().toString().trim();
        String senha = etSenha.getText().toString();

        if (v.getId() == R.id.btnLogin) {
            if (usuario.equals("admin") && senha.equals("1234")) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            } else {
                mostrarMensagem("Usuário ou senha incorretos.");
            }
        }
        if (v.getId() == R.id.btnCadastrar){
            Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
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