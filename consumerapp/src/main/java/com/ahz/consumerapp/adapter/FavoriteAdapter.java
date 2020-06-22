package com.ahz.proyekakhirsubmissiongithub.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahz.proyekakhirsubmissiongithub.R;
import com.ahz.proyekakhirsubmissiongithub.model.DetailUser;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {
    private ArrayList<DetailUser> data = new ArrayList<>();
    private FavoriteAdapter.OnItemClickCallback onItemClickCallback;

    public void setData(ArrayList<DetailUser> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void setOnItemClickCallback(FavoriteAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DetailUser item = data.get(position);

        Picasso.get()
                .load(item.getAvatar_url())
                .resize(55, 55)
                .into(holder.imageView);

        holder.nama.setText(item.getLogin());
        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(data.get(holder.getAdapterPosition())));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nama;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.tv_item_name);
            imageView = itemView.findViewById(R.id.img_item_photo);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(DetailUser detailUser);
    }
}
