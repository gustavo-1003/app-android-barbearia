package com.example.numero;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AgendamentoActivity extends AppCompatActivity {

    DatePicker datePicker;
    Button btData;
    barbeariadatabase db;
    int idCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendario);

        db = barbeariadatabase.getInstance(this);
        idCliente = getIntent().getIntExtra("id_clientes", 0);

        datePicker = findViewById(R.id.data);
        btData     = findViewById(R.id.btData);

        btData.setOnClickListener(v -> {
            int dia = datePicker.getDayOfMonth();
            int mes = datePicker.getMonth() + 1;
            int ano = datePicker.getYear();

            String data = ano + "-" + mes + "-" + dia;
            Agenda agenda = new Agenda();
            agenda.id_clientes = idCliente;
            agenda.data        = data;
            agenda.horario     = "00:00";

            db.dao().inserirAgendamento(agenda);

            Toast.makeText(this, "Agendado para " + dia + "/" + mes + "/" + ano, Toast.LENGTH_SHORT).show();
        });
    }
}