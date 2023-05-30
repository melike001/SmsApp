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
import com.example.smsapp.Modals.GrupSecModals;
import com.example.smsapp.Modals.KisilerModals;
import com.example.smsapp.R;

import java.util.ArrayList;

public class KisilerAdapter extends RecyclerView.Adapter<KisilerAdapter.ViewHolder> {

    private ArrayList<KisilerModals> kisiler_item;
    private Context context;

    public KisilerAdapter(ArrayList<KisilerModals> kisiler_item, Context context) {
        this.kisiler_item = kisiler_item;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.kisiler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(kisiler_item.get(position).getImg()).into(holder.grupimg);
        holder.name.setText(kisiler_item.get(position).getName());
        holder.no.setText(kisiler_item.get(position).getNo());

    }

    @Override
    public int getItemCount() {
        return kisiler_item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView grupimg;
        TextView name, no;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            grupimg = itemView.findViewById(R.id.kisi_img);
            name = itemView.findViewById(R.id.kisi_name);
            no = itemView.findViewById(R.id.kisi_no);
        }
    }
}
