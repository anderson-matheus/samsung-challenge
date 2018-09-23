package android.curso.samsungchallenge.controller;

import android.content.ContentValues;
import android.content.Context;
import android.curso.samsungchallenge.datamodel.CardDataModel;
import android.curso.samsungchallenge.datasource.DataSource;
import android.curso.samsungchallenge.model.Card;

public class CardController extends DataSource{
    ContentValues data;

    public CardController(Context context) {
        super(context);
    }

    public boolean store(Card obj) {
        boolean success = true;
        data = new ContentValues();
        data.put(CardDataModel.getName(), obj.getName());
        data.put(CardDataModel.getContent(), obj.getContent());
        data.put(CardDataModel.getUserId(), obj.getUserId());

        success = insert(CardDataModel.getTable(), data);
        return success;
    }
}
