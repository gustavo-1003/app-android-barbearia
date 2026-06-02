package com.example.numero;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "clientes")
public class Cliente {

    @PrimaryKey(autoGenerate = true)
    public int id_clientes;
    public String nome;
    public String email;
    public String senha;
}