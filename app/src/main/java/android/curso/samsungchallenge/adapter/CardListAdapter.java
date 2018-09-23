package android.curso.samsungchallenge.adapter;

import android.content.Context;
import android.curso.samsungchallenge.R;
import android.curso.samsungchallenge.model.Card;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CardListAdapter extends ArrayAdapter<Card> implements View.OnClickListener{
    Context context;
    private int lastPosition = -1;

    private static class ViewHolder {
        TextView textViewCardName;
        TextView textViewCardCreateAt;
        CardView cardView;
    }

    public CardListAdapter(ArrayList<Card> dataSet, Context context) {
        super(context, R.layout.listview_cards, dataSet);
        ArrayList<Card> data = dataSet;
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        int position = (Integer) view.getTag();
        Object object = getItem(position);
        Card card = (Card) object;

        switch (view.getId()) {
            case R.id.cardView:
                Snackbar.make(view, card.getContent(), Snackbar.LENGTH_LONG)
                        .setAction("No Action", null).show();
                break;
        }
    }

    @NonNull
    @Override
    public View getView(int position, View dataSet, @NonNull ViewGroup parent) {
        Card card = getItem(position);
        ViewHolder line;
        if (dataSet == null) {
            line = new ViewHolder();
            LayoutInflater listViewCards = LayoutInflater.from(getContext());
            dataSet = listViewCards.inflate(R.layout.listview_cards, parent, false);
            line.textViewCardName = dataSet.findViewById(R.id.textViewCardName);
            line.textViewCardCreateAt = dataSet.findViewById(R.id.textViewCardCreateAt);
            line.cardView = dataSet.findViewById(R.id.cardView);
            dataSet.setTag(line);
        } else {
            line = (ViewHolder) dataSet.getTag();
        }
        line.textViewCardName.setText(card.getName());
        line.textViewCardCreateAt.setText(card.getCreatedAt());
        line.cardView.setOnClickListener(this);
        line.cardView.setTag(position);
        return dataSet;
    }
}
