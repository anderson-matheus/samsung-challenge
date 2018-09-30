package android.curso.samsungchallenge.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.curso.samsungchallenge.datamodel.CardDataModel;
import android.curso.samsungchallenge.datamodel.TaskDataModel;
import android.curso.samsungchallenge.datamodel.UserDataModel;
import android.curso.samsungchallenge.model.Card;
import android.curso.samsungchallenge.model.Task;
import android.curso.samsungchallenge.model.User;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DataSource extends SQLiteOpenHelper {
    private static final String DB_NAME = "samsung_challenge.sqlite";
    private static final int DB_VERSION = 1;

    Cursor cursor;
    SQLiteDatabase db;

    public DataSource(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
        try {
            db.execSQL(UserDataModel.getQueryCreateTable());
            db.execSQL(TaskDataModel.getQueryCreateTable());
            db.execSQL(CardDataModel.getQueryCreateTable());
        } catch (Exception e) {
            Log.e("User table", "DB----> ERRO:" + e.getMessage());
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        try {
//            db.execSQL(UserDataModel.getQueryCreateTable());
//        } catch (Exception e) {
//            Log.e("User table", "DB----> ERRO:" + e.getMessage());
//        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insert(String table, ContentValues data) {
        boolean success = true;
        try {
            success = db.insert(table, null, data) > 0;
        } catch(Exception e) {
            success = false;
        }
        return success;
    }

    public ArrayList<Task> getAllTaks() {
        Task obj;
        ArrayList<Task> list = new ArrayList<>();
        String sql = "SELECT * FROM " + TaskDataModel.getTable() + " ORDER BY created_at DESC";
        cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                obj = new Task();
                obj.setId(cursor.getInt(cursor.getColumnIndex(TaskDataModel.getId())));
                obj.setName(cursor.getString(cursor.getColumnIndex(TaskDataModel.getName())));
                obj.setUserId(cursor.getInt(cursor.getColumnIndex(TaskDataModel.getUserId())));
                list.add(obj);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public ArrayList<Card> getAllCards() {
        Card obj;
        ArrayList<Card> list = new ArrayList<>();
        String sql = "SELECT * FROM " + CardDataModel.getTable() + " ORDER BY created_at DESC";
        cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                obj = new Card();
                obj.setId(cursor.getInt(cursor.getColumnIndex(CardDataModel.getId())));
                obj.setName(cursor.getString(cursor.getColumnIndex(CardDataModel.getName())));
                obj.setContent(cursor.getString(cursor.getColumnIndex(CardDataModel.getContent())));
                obj.setUserId(cursor.getInt(cursor.getColumnIndex(CardDataModel.getContent())));
                obj.setCreatedAt(cursor.getString(cursor.getColumnIndex(CardDataModel.getCreatedAt())));
                list.add(obj);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public int getCardsCount() {
        String countQuery = "SELECT  * FROM " + CardDataModel.getTable();
        Cursor cursor = db.rawQuery(countQuery, null);
        Integer count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int getTaksCount() {
        String countQuery = "SELECT  * FROM " + TaskDataModel.getTable();
        Cursor cursor = db.rawQuery(countQuery, null);
        Integer count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int countUserExists(User user) {
        String countQuery = "SELECT  * FROM " + UserDataModel.getTable() + " WHERE " + UserDataModel.getEmail() + " = '" + user.getEmail() + "' AND " + UserDataModel.getPassword() + " = '" + user.getPassword() + "'";
        Cursor cursor = db.rawQuery(countQuery, null);
        Integer count = cursor.getCount();
        cursor.close();
        return count;
    }
}
