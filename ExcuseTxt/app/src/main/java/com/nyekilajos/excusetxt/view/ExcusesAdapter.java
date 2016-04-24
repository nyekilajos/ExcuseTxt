package com.nyekilajos.excusetxt.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nyekilajos.excusetxt.R;
import com.nyekilajos.excusetxt.model.Excuse;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by nyeki on 2016. 04. 02..
 */
public class ExcusesAdapter extends RecyclerView.Adapter<ExcusesAdapter.ExcusesViewHolder> {

    private final Context context;

    private List<Excuse> excuses;

    public ExcusesAdapter(Context context) {
        this.context = context;
    }

    public void setExcuses(List<Excuse> excuses) {
        this.excuses = excuses;
        notifyDataSetChanged();
    }

    @Override
    public ExcusesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_excuse, parent, false);
        ExcusesViewHolder holder = new ExcusesViewHolder(view);
        ButterKnife.bind(holder, view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ExcusesViewHolder holder, int position) {
        holder.excuseDescription.setText(excuses.get(position).getExcuseDesc());
    }

    @Override
    public int getItemCount() {
        return excuses.size();
    }

    public class ExcusesViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.excuse_description)
        TextView excuseDescription;

        public ExcusesViewHolder(View itemView) {
            super(itemView);
        }
    }
}
