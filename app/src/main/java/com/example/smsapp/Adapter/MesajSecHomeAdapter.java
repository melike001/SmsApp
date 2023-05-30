package com.example.smsapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smsapp.Modals.MesajSecHomeModals;
import com.example.smsapp.R;

import java.util.ArrayList;

public class MesajSecHomeAdapter extends RecyclerView.Adapter<MesajSecHomeAdapter.ViewHolder> {

    private ArrayList<MesajSecHomeModals> mesaj_sec_home_item;
    private Context context;

    public MesajSecHomeAdapter(ArrayList<MesajSecHomeModals> mesaj_sec_home_item, Context context) {
        this.mesaj_sec_home_item = mesaj_sec_home_item;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mesaj_sec_home_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(mesaj_sec_home_item.get(position).getName());
        holder.description.setText(mesaj_sec_home_item.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mesaj_sec_home_item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.mesajName);
            description = itemView.findViewById(R.id.mesajDescription);
        }
    }
}
