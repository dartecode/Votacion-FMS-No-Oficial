package com.dartcode.votacion_fms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorFMS
        extends RecyclerView.Adapter<AdaptadorFMS.FMSViewHolder>
            implements View.OnClickListener{


    ArrayList<PaisesFMS> listaPaisesFMS;
    private View.OnClickListener listener;

    public AdaptadorFMS(ArrayList<PaisesFMS> listaPaisesFMS) {
        this.listaPaisesFMS = listaPaisesFMS;
    }

    @Override
    public FMSViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_paises,null,false);
        view.setOnClickListener(this);
        return new FMSViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FMSViewHolder holder, int position) {
        holder.logoFMS.setImageResource(listaPaisesFMS.get(position).getFoto());
        holder.lblPais.setText("FMS " + listaPaisesFMS.get(position).getPais());
        holder.lblDescripcion.setText(listaPaisesFMS.get(position).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return listaPaisesFMS.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class FMSViewHolder extends RecyclerView.ViewHolder {

        ImageView logoFMS;
        TextView lblPais, lblDescripcion;

        public FMSViewHolder(View itemView) {
            super(itemView);

            logoFMS = (ImageView) itemView.findViewById(R.id.iv_logoFMS);
            lblPais = (TextView) itemView.findViewById(R.id.lblNombreFMS);
            lblDescripcion = (TextView) itemView.findViewById(R.id.lblDescripcionFMS);

        }
    }
}
