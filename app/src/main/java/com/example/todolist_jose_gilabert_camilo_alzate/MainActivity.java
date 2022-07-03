package com.example.todolist_jose_gilabert_camilo_alzate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.PlantillaFragment, new Tareas());
        fragmentTransaction.commit();

        Button add;
        add = findViewById(R.id.btn_tarea);
        add.setOnClickListener(view1 -> {
            startActivity(new Intent(this, CrearTarea.class));


        });

    }

    protected void AddToList (String cadena){
        list.add(cadena);
    }
}
