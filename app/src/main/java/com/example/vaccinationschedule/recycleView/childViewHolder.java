package com.example.vaccinationschedule.recycleView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.vaccinationschedule.R;

public class childViewHolder extends RecyclerView.ViewHolder {
    public TextView name,surname,dataOfBirth;
    public childViewHolder(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.tvName);
        surname=itemView.findViewById(R.id.tvSurname);
        dataOfBirth=itemView.findViewById(R.id.tvData);
    }
}
