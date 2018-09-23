package android.curso.samsungchallenge.fragment;

import android.curso.samsungchallenge.R;
import android.curso.samsungchallenge.adapter.TaskListAdapter;
import android.curso.samsungchallenge.controller.TaskController;
import android.curso.samsungchallenge.model.Task;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class TaskFragment extends Fragment {

    View view;
    FloatingActionButton btnNewTask;
    ArrayList<Task> data;
    ListView listView;
    TaskController taskController;

    public TaskFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_task, container, false);
        taskController = new TaskController(getContext());
        listView = view.findViewById(R.id.listTasks);
        data = taskController.all();
        TaskListAdapter adapter = new TaskListAdapter(data, getContext());
        listView.setAdapter(adapter);

        btnNewTask = (FloatingActionButton) view.findViewById(R.id.buttonNewTask);
        btnNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewTaskFragment newTaskFragment = new NewTaskFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.content_fragment, newTaskFragment, newTaskFragment.getTag()).commit();
            }
        });
        return view;
    }
}
