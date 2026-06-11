package com.example.numero;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.numero.Agenda;
import com.example.numero.Cliente;


import java.util.List;

@Dao
public interface Barbearia {

    @Insert
    void inserirCliente(Cliente cliente);

    @Insert
    void inserirAgendamento(Agenda agenda);

    @Query("SELECT * FROM clientes WHERE nome = :usuario AND senha = :senha")
    Cliente login(String usuario, String senha);

    @Query("SELECT * FROM agenda WHERE id_clientes = :idCliente")
    List<Agenda> agendamentosPorCliente(int idCliente);
}