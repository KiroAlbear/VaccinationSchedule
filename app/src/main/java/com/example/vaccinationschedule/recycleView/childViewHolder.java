package com.example.vaccinationschedule.recycleView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.vaccinationschedule.R;

public class childViewHolder extends RecyclerView.ViewHolder {
    public TextView name,surname,dataOfBirth,letterTextView;
    public childViewHolder(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.Name);
        surname=itemView.findViewById(R.id.Surname);
        dataOfBirth=itemView.findViewById(R.id.Data);
        letterTextView= itemView.findViewById(R.id.letterTextView);
    }
}
