package android.curso.samsungchallenge.fragment;

import android.curso.samsungchallenge.R;
import android.curso.samsungchallenge.controller.CardController;
import android.curso.samsungchallenge.model.Card;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NewCardFragment extends Fragment {
    View view;
    EditText editTextCardName, editTextCardContent;
    Button btnNewCard;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Novo card");
    }

    private boolean validateCardName() {
        String cardName = editTextCardName.getText().toString().trim();
        if (cardName.isEmpty()) {
            editTextCardName.setError("Informe um nome para o card");
            return false;
        }
        editTextCardName.setError(null);
        return true;
    }

    private boolean validateContentCard() {
        String cardContent = editTextCardContent.getText().toString().trim();
        if (cardContent.isEmpty()) {
            editTextCardContent.setError("Informe o conteúdo do card");
            return false;
        }
        editTextCardContent.setError(null);
        return true;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_new_card, container, false);
        editTextCardName = (EditText) view.findViewById(R.id.editTextCardName);
        editTextCardContent = (EditText) view.findViewById(R.id.editTextCardContent);

        btnNewCard = (Button) view.findViewById(R.id.buttonNewCard);
        btnNewCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateCardName() == true && validateContentCard() == true) {
                    Card obj = new Card();
                    obj.setName(editTextCardName.getText().toString().trim());
                    obj.setContent(editTextCardContent.getText().toString().trim());
                    obj.setUserId(1);
                    CardController cardController = new CardController(getContext());
                    if (cardController.store(obj) == true) {
                        editTextCardName.setText("");
                        editTextCardContent.setText("");
                        Toast.makeText(getContext(), "Card cadastrado com sucesso", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "Não foi possível cadastrar seu card", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
        return view;
    }
}
