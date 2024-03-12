package com.politecnicomalaga.NasdaqOilPrices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

public class JornadaAdapter extends RecyclerView.Adapter<JornadaViewHolder> {

    private final List<Price> mList;
    private LayoutInflater mInflater;

    public JornadaAdapter(Context context,
                          List<Price> list) {
        mInflater = LayoutInflater.from(context);
        this.mList = list;
    }


    @NonNull
    @Override
    public JornadaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.day_list_item,
                parent, false);
        return new JornadaViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull JornadaViewHolder holder, int position) {
        //TODO: fill data
       holder.setDay(this.mList.get(position).getDay());
       holder.setPrice(this.mList.get(position).getPrice());


    }



    @Override
    public int getItemCount() {
        return mList.size();
    }

}
