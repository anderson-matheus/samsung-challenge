package android.curso.samsungchallenge.controller;

import android.content.ContentValues;
import android.content.Context;
import android.curso.samsungchallenge.datamodel.TaskDataModel;
import android.curso.samsungchallenge.datasource.DataSource;
import android.curso.samsungchallenge.model.Task;

import java.util.ArrayList;

public class TaskController extends DataSource {
    ContentValues data;

    public TaskController(Context context) {
        super(context);
    }

    public ArrayList<Task> all() {
        return getAllTaks();
    }

    public boolean store(Task obj) {
        boolean success = true;
        data = new ContentValues();
        data.put(TaskDataModel.getName(), obj.getName());
        data.put(TaskDataModel.getUserId(), obj.getUserId());

        success = insert(TaskDataModel.getTable(), data);
        return success;
    }
}
