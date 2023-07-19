package com.nftapp.nftmarketplace.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nftapp.nftmarketplace.R;
import com.nftapp.nftmarketplace.model.Item;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{
    private Context mContext;
    private List<Item> mListItem;

    public ItemAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Item> list) {
        this.mListItem = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nft,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = mListItem.get(position);
        if (item == null) {
            return;
        }
        holder.itemImg.setImageResource(item.getResourceImage());
        holder.itemName.setText(item.getItem_name());
        holder.itemPrice.setText(item.getItem_price());

    }

    @Override
    public int getItemCount() {
        if(mListItem != null) {
            return mListItem.size();
        }
        return 0;
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView itemImg;
        private TextView itemName;
        private TextView itemPrice;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImg = itemView.findViewById(R.id.item_image);
            itemName = itemView.findViewById(R.id.item_name);
            itemPrice = itemView.findViewById(R.id.item_price);
        }
    }
}
