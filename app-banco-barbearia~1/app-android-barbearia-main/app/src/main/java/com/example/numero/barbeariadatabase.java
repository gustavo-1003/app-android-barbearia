package com.example.numero;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.numero.Barbearia;

import com.example.numero.Agenda;
import com.example.numero.Cliente;

@Database(entities = {Cliente.class, Agenda.class}, version = 1)
public abstract class barbeariadatabase extends RoomDatabase {

    public abstract Barbearia dao();

    private static barbeariadatabase INSTANCE;

    public static barbeariadatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    barbeariadatabase.class,
                    "barbearia_db"
            ).allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}