package android.curso.samsungchallenge.fragment;

import android.curso.samsungchallenge.R;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CardFragment extends Fragment {

    View view;
    FloatingActionButton btnNewCard;

    public CardFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.card_fragment, container, false);
        btnNewCard = (FloatingActionButton) view.findViewById(R.id.buttonNewCard);
        btnNewCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewCardFragment newCardFragment = new NewCardFragment();
                FragmentManager  manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.content_fragment, newCardFragment, newCardFragment.getTag()).commit();
            }
        });
        return view;
    }
}
