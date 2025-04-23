package com.rebanta.moosic.adapters;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.gson.Gson;
import com.rebanta.moosic.R;
import com.rebanta.moosic.activities.ListActivity;
import com.rebanta.moosic.model.AlbumItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ActivityMainAlbumItemAdapter extends RecyclerView.Adapter<ActivityMainAlbumItemAdapter.ActivityMainAlbumItemAdapterViewHolder> {

    private final List<AlbumItem> data;

    public ActivityMainAlbumItemAdapter(List<AlbumItem> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ActivityMainAlbumItemAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View _v = View.inflate(parent.getContext(), viewType == 0 ? R.layout.activity_main_songs_item : R.layout.songs_item_shimmer, null);
        _v.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new ActivityMainAlbumItemAdapterViewHolder(_v);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityMainAlbumItemAdapterViewHolder holder, int position) {
        if (getItemViewType(position) == 1) {
            ((ShimmerFrameLayout) holder.itemView.findViewById(R.id.shimmer)).startShimmer();
            return;
        }

        ((TextView) holder.itemView.findViewById(R.id.albumTitle)).setText(data.get(position).albumTitle());
        ((TextView) holder.itemView.findViewById(R.id.albumSubTitle)).setText(data.get(position).albumSubTitle());

        holder.itemView.findViewById(R.id.albumTitle).setSelected(true);
        holder.itemView.findViewById(R.id.albumSubTitle).setSelected(true);

        ImageView coverImage = holder.itemView.findViewById(R.id.coverImage);
        Picasso.get().load(Uri.parse(data.get(position).albumCover())).into(coverImage);

        holder.itemView.setOnClickListener(v -> {
            v.getContext().startActivity(new Intent(v.getContext(), ListActivity.class)
                    .putExtra("data", new Gson().toJson(data.get(position)))
                    .putExtra("type", "album")
                    .putExtra("id", data.get(position).id())
            );
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (data.get(position).albumTitle().equals("<shimmer>")) return 1;
        else return 0;
    }

    public static class ActivityMainAlbumItemAdapterViewHolder extends RecyclerView.ViewHolder {
        public ActivityMainAlbumItemAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
