package android.curso.samsungchallenge.fragment;

import android.curso.samsungchallenge.R;
import android.curso.samsungchallenge.controller.CardController;
import android.curso.samsungchallenge.controller.TaskController;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BaseFragment extends Fragment {

    CardController cardController;
    TaskController taskController;
    View view;

    public BaseFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_base, container, false);
        cardController = new CardController(getContext());
        Integer countCards = cardController.countCards();
        TextView cards = (TextView)view.findViewById(R.id.statisticCards);
        cards.setText("Você tem " + countCards + " criados");

        taskController = new TaskController(getContext());
        Integer countTasks = taskController.countTasks();
        TextView tasks = (TextView)view.findViewById(R.id.statisticTasks);
        tasks.setText("Você tem " + countTasks + " criados");
        return view;
    }
}
