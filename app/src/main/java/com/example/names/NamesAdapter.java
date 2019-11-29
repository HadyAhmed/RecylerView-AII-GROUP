package com.example.names;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.NamesViewHolder> {
    private List<Name> nameList;
    private LayoutInflater layoutInflater;

    private OnNameClickListener onNameClickListener;

    public NamesAdapter(OnNameClickListener onNameClickListener, List<Name> nameList) {
        this.nameList = nameList;
        this.onNameClickListener = onNameClickListener;
    }

    @NonNull
    @Override
    public NamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        return new NamesViewHolder(layoutInflater.inflate(R.layout.name_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NamesViewHolder holder, int position) {
        holder.setAdapterData(nameList.get(position), onNameClickListener);
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    class NamesViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView phoneNumberTextView;
        private LinearLayout itemContainer;

        public NamesViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name_tv);
            phoneNumberTextView = itemView.findViewById(R.id.number_tv);
            itemContainer = itemView.findViewById(R.id.item_container);
        }

        void setAdapterData(final Name data, final OnNameClickListener onNameClickListener) {
            nameTextView.setText(data.getName());
            phoneNumberTextView.setText(data.getPhoneNumber());

            itemContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNameClickListener.sendName(data);
                }
            });
        }
    }
}
