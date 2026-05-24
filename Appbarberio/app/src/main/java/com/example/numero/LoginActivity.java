package com.example.numero;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private DatePicker data;
    private Button btData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendario);

        data = findViewById(R.id.data);
        btData = findViewById(R.id.btData);


        if (btData != null) {
            btData.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if (data == null) return;

        int dia = data.getDayOfMonth();
        int mes = data.getMonth() + 1;
        int ano = data.getYear();

        mostrarMensagem("Data selecionada: " + dia + "/" + mes + "/" + ano);
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();


    }

    private void mostrarMensagem(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Barbearia");
        builder.setMessage(msg);
        builder.setPositiveButton("OK", null);
        builder.show();
    }
}