package com.example.todolist_jose_gilabert_camilo_alzate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class AdaptadorTareas extends RecyclerView.Adapter<AdaptadorTareas.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox task_checkbox;



        ViewHolder(View view) {
            super(view);
            task_checkbox = view.findViewById(R.id.check_tarea);
        }


        public void bind(int pos) {
            ArrayList<Tarea> list = ManagerTareas.getInstance().getTareas();
            task_checkbox.setText(list.get(pos).getTitle());
            task_checkbox.setChecked(list.get(pos).isCompleted());

            task_checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                        list.get(pos).setCompleted(isChecked);
                        ManagerTareas.getInstance().saveTasks();
                    }
            );

        }


    }




    public AdaptadorTareas( ) {
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_tareas, parent, false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }



    @Override
    public int getItemCount() {
        return ManagerTareas.getInstance().getTareas().size();
    }


}
