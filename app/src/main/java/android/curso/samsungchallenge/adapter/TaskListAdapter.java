package android.curso.samsungchallenge.adapter;

import android.content.Context;
import android.curso.samsungchallenge.R;
import android.curso.samsungchallenge.model.Task;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskListAdapter extends ArrayAdapter<Task> implements View.OnClickListener {
    Context context;

    private int lastPosition = -1;

    private static class ViewHolder {
        TextView textViewTaskName;
    }

    public TaskListAdapter(ArrayList<Task> dataSet, Context context) {
        super(context, R.layout.listview_taks, dataSet);
        ArrayList<Task> data = dataSet;
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        int position = (Integer) view.getTag();
        Object object = getItem(position);
        Task task = (Task) object;

        switch (view.getId()) {
            case R.id.textViewtaskName:
                Snackbar.make(view, "Snackbar " + task.getName(), Snackbar.LENGTH_LONG)
                        .setAction("No Action", null).show();
                break;
        }
    }

    @NonNull
    @Override
    public View getView(int position, View dataSet, @NonNull ViewGroup parent) {
        Task task = getItem(position);
        ViewHolder line;
        if (dataSet == null) {
            line = new ViewHolder();
            LayoutInflater listViewTaks = LayoutInflater.from(getContext());
            dataSet = listViewTaks.inflate(R.layout.listview_taks, parent, false);
            line.textViewTaskName = dataSet.findViewById(R.id.textViewtaskName);
            dataSet.setTag(line);
        } else {
            line = (ViewHolder) dataSet.getTag();
        }

        line.textViewTaskName.setText(task.getName());
        line.textViewTaskName.setOnClickListener(this);
        line.textViewTaskName.setTag(position);
        return dataSet;
    }
}
