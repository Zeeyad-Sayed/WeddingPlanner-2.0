package com.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weddingplanner20.R;

import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.OfferViewHolder> {

    private List<Offer> offers;
    private Context context;

    public OfferAdapter(List<Offer> offers, Context context) {
        this.offers = offers;
        this.context = context;
    }

    @NonNull
    @Override
    public OfferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_offer, parent, false);
        return new OfferViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferViewHolder holder, int position) {
        Offer offer = offers.get(position);
        holder.offerNameTextView.setText(offer.getPlace());
        holder.offerDetailsTextView.setText(offer.getDetails());
    }

    @Override
    public int getItemCount() {
        return offers.size();
    }

    public static class OfferViewHolder extends RecyclerView.ViewHolder {
        public TextView offerNameTextView;
        public TextView offerDetailsTextView;

        public OfferViewHolder(View itemView) {
            super(itemView);
            offerNameTextView = itemView.findViewById(R.id.offer_name_text_view);
            offerDetailsTextView = itemView.findViewById(R.id.offer_details_text_view);
        }
    }
}
