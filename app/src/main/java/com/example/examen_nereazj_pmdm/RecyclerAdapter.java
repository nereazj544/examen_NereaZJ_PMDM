package com.example.examen_nereazj_pmdm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    List<Segundos> segundos;

    public RecyclerAdapter (List<Segundos> modelList){
        segundos = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listasegundos, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(segundos.get(position));
    }

    @Override
    public int getItemCount() {
        return segundos.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView marcas;

        ViewHolder(View  v){
            super(v);
            marcas = v.findViewById(R.id.timemarc);
                    }

        public void bind(Segundos segundos) {
            marcas.setText(segundos.getMarcas());

        }
    }

}
