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
    private List<PerfilModel> perfilList;

    public PerfilAdapter(List<PerfilModel> perfilList) {
        this.perfilList = perfilList;
    }

    @NonNull
    @Override
    public PerfilAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_perfil, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        PerfilModel model = perfilList.get(position);
        holder.tVnameUser.setText(model.getUsername());
        holder.tVcorreo.setText(model.getEmail());
        holder.tVFullName.setText(model.getFullName());
    }

    @Override
    public int getItemCount() {
        return perfilList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tVnameUser, tVcorreo, tVFullName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Referencia
            tVnameUser = itemView.findViewById(R.id.tVnameUser);
            tVcorreo = itemView.findViewById(R.id.tVmail);
            tVFullName = itemView.findViewById(R.id.tVFullName);
        }
    }
    public void add(ArrayList<PerfilModel> perfilList) {
        perfilList.addAll( perfilList);
        notifyDataSetChanged();
    }
}