package com.example.smsapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.contentcapture.ContentCaptureContext;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smsapp.Modals.GrubaUyeEkleModals;
import com.example.smsapp.R;

import java.util.ArrayList;

public class GrubaUyeEkleAdapter extends RecyclerView.Adapter<GrubaUyeEkleAdapter.ViewHolder> {

    private ArrayList<GrubaUyeEkleModals> grup_sec_uye_ekle_item;
    private Context context;

    public GrubaUyeEkleAdapter(ArrayList<GrubaUyeEkleModals> grup_sec_uye_ekle_item, Context context) {
        this.grup_sec_uye_ekle_item = grup_sec_uye_ekle_item;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.grup_sec_uye_ekle_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(grup_sec_uye_ekle_item.get(position).getImg()).into(holder.grupimg);
        holder.name.setText(grup_sec_uye_ekle_item.get(position).getName());
        holder.description.setText(grup_sec_uye_ekle_item.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return grup_sec_uye_ekle_item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView grupimg;
        TextView name, description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            grupimg = itemView.findViewById(R.id.grup_sec_img);
            name = itemView.findViewById(R.id.grup_sec_name);
            description = itemView.findViewById(R.id.grup_sec_description);
        }
    }
}
