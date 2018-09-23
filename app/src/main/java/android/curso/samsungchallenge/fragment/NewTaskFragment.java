package android.curso.samsungchallenge.fragment;

import android.curso.samsungchallenge.R;
import android.curso.samsungchallenge.controller.TaskController;
import android.curso.samsungchallenge.model.Task;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewTaskFragment extends Fragment {

    View view;
    EditText editTextNameTask;
    Button btnNewTask;

    public NewTaskFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Nova tarefa");
    }

    private boolean validateNameTask(){
        String nameTask = editTextNameTask.getText().toString().trim();
        if (nameTask.isEmpty()) {
            editTextNameTask.setError("Informe um nome para a tarefa");
            return false;
        }
        editTextNameTask.setError(null);
        return true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_new_task, container, false);
        editTextNameTask = (EditText) view.findViewById(R.id.editTextNameTask);


        btnNewTask = (Button) view.findViewById(R.id.buttonNewTask);
        btnNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateNameTask() == true) {
                    Task obj = new Task();
                    obj.setName(editTextNameTask.getText().toString().trim());
                    obj.setUserId(1);
                    TaskController taskController = new TaskController(getContext());
                    if (taskController.store(obj) == true) {
                        Toast.makeText(getContext(), "Tarefa criada com sucesso" , Toast.LENGTH_SHORT ).show();
                        editTextNameTask.setText("");
                    } else {
                        Toast.makeText(getContext(), "Não foi possível criar tarefa" , Toast.LENGTH_SHORT ).show();
                    }
                }
            }
        });
        return view;
    }
}
