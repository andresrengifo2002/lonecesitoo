package com.example.myapplication.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.PerfilModel;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.ViewHolder> {
    private RecyclerView  recyclerView;
    private List<PerfilModel> perfil;
    private Context context;

    public PerfilAdapter(Context context){
        perfil = new ArrayList<>();
        this.context = context;
    }


    @NonNull
    @Override
    public PerfilAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_perfil, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PerfilAdapter.ViewHolder holder, int position) {

        PerfilModel model = perfil.get(position);
        holder.tVnameUser.setText(model.getUsername());
        holder.edTcorreo.setText(model.getEmail());
    }

    @Override
    public int getItemCount() {
        return perfil.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tVnameUser;
        EditText edTcorreo, edTficha;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Referencia
            tVnameUser = itemView.findViewById(R.id.tVnameUser);
            edTcorreo = itemView.findViewById(R.id.tVmailUdser);
            edTficha = itemView.findViewById(R.id.tVficha);
        }
    }

    public void add(ArrayList<PerfilModel> perfil){
        perfil.addAll(perfil);
        notifyDataSetChanged();
    }
}