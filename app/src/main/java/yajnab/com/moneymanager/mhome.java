package yajnab.com.moneymanager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class mhome extends Fragment {


    public mhome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mhome, container, false);
        final TextView txtHomeBal = (TextView) v.findViewById(R.id.txtHomeBal);
        final TextView txtHomeTrans = (TextView) v.findViewById(R.id.txtHomeTrans);
        final dbHandler db = new dbHandler(container.getContext());
        String balance = String.valueOf(db.getLastRecord().getBalance());
        String lTrans= db.getLastRecord().getPurpose() + "\t" + db.getLastRecord().getType() + "\t" + db.getLastRecord().getAmount() + "\t" + db.getLastRecord().getDate();
        txtHomeBal.setText(balance);
        txtHomeTrans.setText(lTrans);
        return v;
                
    }

}
