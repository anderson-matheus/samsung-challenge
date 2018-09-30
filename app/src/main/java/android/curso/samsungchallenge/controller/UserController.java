package android.curso.samsungchallenge.controller;

import android.content.ContentValues;
import android.content.Context;
import android.curso.samsungchallenge.datamodel.UserDataModel;
import android.curso.samsungchallenge.datasource.DataSource;
import android.curso.samsungchallenge.model.User;

public class UserController extends DataSource {
    ContentValues data;

    public UserController(Context context) {
        super(context);
    }

    public boolean store(User obj) {
        boolean success = true;
        data = new ContentValues();
        data.put(UserDataModel.getName(), obj.getName());
        data.put(UserDataModel.getEmail(), obj.getEmail());
        data.put(UserDataModel.getPassword(), obj.getPassword());

        success = insert(UserDataModel.getTable(), data);
        return success;
    }

    public int userExists(User obj) {
        return countUserExists(obj);
    }
}
