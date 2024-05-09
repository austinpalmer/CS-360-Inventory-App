package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/* WIP: Unable to update recyclerview
public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {
    private Context context;
    private ArrayList nameID, quantityID;

    public ItemListAdapter(Context context, ArrayList nameID, ArrayList quantityID) {
        this.context = context;
        this.nameID = nameID;
        this.quantityID = quantityID;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_item_inventory, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameID.setText(String.valueOf(nameID.get(position)));
        holder.nameID.setText(String.valueOf(quantityID.get(position)));
    }

    @Override
    public int getItemCount() {
        return nameID.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameID, quantityID;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameID = itemView.findViewById(R.id.nameInput);
            quantityID = itemView.findViewById(R.id.qntInput);
        }
    }
}
 */
