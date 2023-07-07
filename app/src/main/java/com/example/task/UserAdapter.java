package com.example.task;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.userHolder> {
    MainActivity mainActivity;
    List<ModelClass> alluserList;

    public UserAdapter(MainActivity mainActivity, List<ModelClass> alluserList) {
        this.mainActivity = mainActivity;
        this.alluserList = alluserList;
    }

    @NonNull
    @Override
    public userHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new userHolder(LayoutInflater.from(mainActivity).inflate(R.layout.cardlayout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull userHolder holder, int position) {
        holder.name.setText(alluserList.get(position).getName());
        holder.realname.setText(alluserList.get(position).getRealname());
        holder.team.setText(alluserList.get(position).getTeam());
        holder.firstappearance.setText(alluserList.get(position).getFirstappearance());
        holder.createdby.setText(alluserList.get(position).getCreatedby());
        holder.publisher.setText(alluserList.get(position).getPublisher());
        holder.bio.setText(alluserList.get(position).getBio());

        Picasso.get().load(alluserList.get(position)
                .getImageurl())
                .placeholder(R.drawable.ic_launcher_background).fit().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return alluserList.size();
    }

    class userHolder extends RecyclerView.ViewHolder {
        TextView name,realname,team,firstappearance,createdby,publisher,bio;
        ImageView imageView;

        public userHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            realname = itemView.findViewById(R.id.realname);
            team = itemView.findViewById(R.id.team);
            firstappearance = itemView.findViewById(R.id.firstappearance);
            createdby = itemView.findViewById(R.id.createdby);
            publisher = itemView.findViewById(R.id.publisher);
            bio = itemView.findViewById(R.id.bio);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
