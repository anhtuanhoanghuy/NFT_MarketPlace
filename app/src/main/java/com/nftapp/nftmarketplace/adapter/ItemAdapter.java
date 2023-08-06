package com.nftapp.nftmarketplace.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.nftapp.nftmarketplace.ItemInfo;
import com.nftapp.nftmarketplace.R;
import com.nftapp.nftmarketplace.UserProfile;
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
        holder.itemPrice.setText(String.valueOf(item.getItem_price()));
        holder.itemUserName.setText(item.getItem_username());
        holder.itemStatus.setText(item.getItem_status());
//        holder.itemDateEnd.setText(item.getItem_date_end());

        holder.layout_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(item);
            }
        });

    }

    private void onClickGoToDetail(Item item){
        Intent intent = new Intent(mContext, ItemInfo.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_item",item);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    public void release() {
        mContext = null;
    }

    @Override
    public int getItemCount() {
        if(mListItem != null) {
            return mListItem.size();
        }
        return 0;
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private CardView layout_item;
        private ImageView itemImg;
        private TextView itemName;
        private TextView itemPrice;
        private TextView itemUserName;

        private TextView itemStatus;
        private TextView itemDateEnd;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            layout_item = itemView.findViewById(R.id.layout_item);
            itemImg = itemView.findViewById(R.id.item_image);
            itemName = itemView.findViewById(R.id.item_name);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemUserName = itemView.findViewById(R.id.item_username);
            itemStatus = itemView.findViewById(R.id.item_status);
            itemDateEnd = itemView.findViewById(R.id.item_date_end);
        }
    }
}
