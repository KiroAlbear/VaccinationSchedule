package com.example.vaccinationschedule.recycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.vaccinationschedule.Model.ChildEntity;
import com.example.vaccinationschedule.R;

import java.util.List;

public class childAdapter extends RecyclerView.Adapter<childViewHolder> {
    private Context context;
    private List<ChildEntity> childList;

    public childAdapter(Context context, List<ChildEntity> childList) {
        this.context = context;
        this.childList = childList;
    }

    @NonNull
    @Override
    public childViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.child_rom,parent,false);
        childViewHolder viewHolder = new childViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull childViewHolder holder, int position) {
        holder.name.setText(childList.get(position).getChild_name());
        holder.surname.setText(childList.get(position).getChild_surname());
        holder.dataOfBirth.setText(childList.get(position).getDate_of_birth()+"");
    }

    @Override
    public int getItemCount() {
        return childList.size();
    }
}
