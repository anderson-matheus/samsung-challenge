package android.curso.samsungchallenge.adapter;

import android.content.Context;
import android.curso.samsungchallenge.R;
import android.curso.samsungchallenge.fragment.TimerFragment;
import android.curso.samsungchallenge.model.Task;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskListAdapter extends ArrayAdapter<Task> implements View.OnClickListener {
    Context context;

    private int lastPosition = -1;

    private static class ViewHolder {
        TextView textViewTaskName;
        Button buttonStartTimer;
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
            case R.id.buttonStartTimer:
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                TimerFragment timerFragment = new TimerFragment();
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_fragment, timerFragment, timerFragment.getTag()).commit();
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
            LayoutInflater listViewTasks = LayoutInflater.from(getContext());
            dataSet = listViewTasks.inflate(R.layout.listview_taks, parent, false);
            line.textViewTaskName = dataSet.findViewById(R.id.textViewtaskName);
            line.buttonStartTimer = dataSet.findViewById(R.id.buttonStartTimer);
            dataSet.setTag(line);
        } else {
            line = (ViewHolder) dataSet.getTag();
        }

        line.textViewTaskName.setText(task.getName());
        line.buttonStartTimer.setOnClickListener(this);
        line.buttonStartTimer.setTag(position);
        return dataSet;
    }
}
