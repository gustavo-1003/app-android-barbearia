package com.example.numero;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.numero.Cliente;

@Entity(
        tableName = "agenda",
        foreignKeys = @ForeignKey(
                entity = Cliente.class,
                parentColumns = "id_clientes",
                childColumns = "id_clientes",
                onDelete = ForeignKey.CASCADE
        )
)
public class Agenda {

    @PrimaryKey(autoGenerate = true)
    public int id_agenda;
    public int id_clientes;
    public String data;
    public String horario;
}