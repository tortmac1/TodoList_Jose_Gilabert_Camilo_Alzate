package com.example.todolist_jose_gilabert_camilo_alzate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //ArrayList<String> list = new ArrayList<String>();
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.app_basica);
        // ADD HERE
        lvItems = (ListView) findViewById(R.id.lvItems);
        items = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);
        items.add("Sacar a perro");
        items.add("Comprar el pan");
        items.add("Revisar el correo de la salle");
        items.add("Preparar reuniones del día");
        items.add("Hacer ejercicio");






        /*

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
        */

    }

    public void addTarea(View v) {
        EditText nuevaTarea = (EditText) findViewById(R.id.texto_tarea);
        String itemText = nuevaTarea.getText().toString();
        itemsAdapter.add(itemText);
        nuevaTarea.setText("");
    }

    protected void AddToList(String cadena) {
       // list.add(cadena);
    }
}
