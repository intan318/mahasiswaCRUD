package com.example.crud.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crud.Model.DatanyaItem;
import com.example.crud.R;

import org.w3c.dom.Text;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder> {
    Context context;
    List<DatanyaItem> datanyaItems;

    public MahasiswaAdapter(Context context, List<DatanyaItem> datanyaItems){
        this.context = context;
        this.datanyaItems = datanyaItems;
    }


    @NonNull
    @Override
    public MahasiswaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_mahasiswa, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaAdapter.ViewHolder holder, final int i) {

        holder.nama.setText(datanyaItems.get(i).getName());
        holder.nim.setText(datanyaItems.get(i).getNim());
        holder.jurusan.setText(datanyaItems.get(i).getJurusan());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return datanyaItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nama;
        TextView nim;
        TextView jurusan;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            nama = itemView.findViewById(R.id.txtNamaMhs);
            nim = itemView.findViewById(R.id.txtNimMhs);
            jurusan = itemView.findViewById(R.id.txtJurusanMhs);

        }
    }
}
