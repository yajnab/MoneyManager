package yajnab.com.moneymanager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import yajnab.com.moneymanager.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class mdebit extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_mdebit, container, false);
        final EditText txtPayee = (EditText) v.findViewById(R.id.txtPayee);
        final EditText txtDebitAmt = (EditText) v.findViewById(R.id.txtDebitAmt);
        final EditText txtDebitDate = (EditText) v.findViewById(R.id.txtDebitAmt);
        return v;
    }
}
