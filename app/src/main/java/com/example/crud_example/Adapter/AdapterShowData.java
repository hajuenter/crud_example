package com.example.crud_example.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crud_example.Model.ModelData;
import com.example.crud_example.R;

import java.util.List;

public class AdapterShowData extends RecyclerView.Adapter<AdapterShowData.HolderData> {
    private Context c;
    private List<ModelData> lsData;

    //buat construktor
    public AdapterShowData(Context c, List<ModelData> lsData) {
        this.c = c;
        this.lsData = lsData;
    }

    //implements method
    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_data, parent, false);
        HolderData hd = new HolderData(layout);
        return hd;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        ModelData md = lsData.get(position);

        holder.tvid.setText(String.valueOf(md.getId_karakter())); //type int
        holder.tvvaluenama.setText(md.getNama());
        holder.tvvaluejk.setText(md.getJenis_kelamin());
    }

    @Override
    public int getItemCount() {
        return lsData.size();
    }

    //buat holder
    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvid, tvvaluenama, tvvaluejk;

        //buat construktor
        public HolderData(@NonNull View itemView) {
            super(itemView);

            //set data
            tvid = itemView.findViewById(R.id.tvidkarakter);
            tvvaluenama = itemView.findViewById(R.id.tvvaluenama);
            tvvaluejk = itemView.findViewById(R.id.tvvaluejk);
        }
    }
}
