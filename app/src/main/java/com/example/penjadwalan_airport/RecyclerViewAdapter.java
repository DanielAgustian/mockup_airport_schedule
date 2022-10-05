package com.example.penjadwalan_airport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    //ListData ld;
    public ArrayList<ListData> listAirport;
    private Context mContext;

    public RecyclerViewAdapter( ArrayList<ListData> listAirport, Context mContext) {
        this.listAirport = listAirport;
        this.mContext = mContext;

    }


    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recyclerview, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d(TAG, "OnBindViewHolder: Called");
        final ListData data = listAirport.get(i);
        viewHolder.txt_no.setText(data.getAirport());

    }

    @Override
    public int getItemCount() {
        return listAirport.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_no;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_no = itemView.findViewById(R.id.txt_nomor);

        }
    }
}
