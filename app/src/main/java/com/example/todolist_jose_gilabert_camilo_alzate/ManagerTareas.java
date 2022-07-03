package com.example.todolist_jose_gilabert_camilo_alzate;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManagerTareas {
    private static ManagerTareas single_instance = null;
    ArrayList<Tarea> tareas;
    Context context;


    private ManagerTareas(Context context) {
        this.tareas = new ArrayList<>();
        this.context = context;

        SharedPreferences guardador = context.getSharedPreferences("tarea", Context.MODE_PRIVATE);
        String objectJSON = guardador.getString("tarea", null);
        if (objectJSON != null) {
            Type type = new TypeToken<ArrayList<Tarea>>() {
            }.getType();
            tareas = new Gson().fromJson(objectJSON, type);
        } else {

        }
    }




    public static ManagerTareas getInstance(Context context) {
        if (single_instance == null) single_instance = new ManagerTareas(context);
        return single_instance;
    }


    public static ManagerTareas getInstance() {
        return single_instance;
    }


    public void saveTasks() {
        Gson gson = new Gson();
        String json = gson.toJson(tareas);

        SharedPreferences guardador = context.getSharedPreferences("tarea", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = guardador.edit();

        editor.putString("tarea", json);
        editor.apply();
    }


    public ArrayList<Tarea> getTareas() {
        return tareas;
    }


    public void addTask(Tarea task) {
        tareas.add(task);
        //saveTasks();
    }


    public void removeTask(int idTask) {
        tareas.remove(idTask);
    }

}