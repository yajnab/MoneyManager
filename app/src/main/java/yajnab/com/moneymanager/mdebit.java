package yajnab.com.moneymanager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.database.Cursor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        final dbHandler db = new dbHandler(container.getContext());
        final Button btnDebit = (Button) v.findViewById(R.id.btnDebit);
        btnDebit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();String dates=null;
                if (!txtDebitDate.getText().toString().equals("")) {dates=txtDebitDate.getText().toString();} else {dates=dateFormat.format(date);}
                float fbalance = db.getLastRecord().getBalance();
                float nbalance = fbalance + Float.parseFloat(String.valueOf(txtDebitAmt.getText()));
                db.addMoney(new Money(txtPayee.getText().toString(),"DB", Float.parseFloat(String.valueOf(txtDebitAmt.getText())), dates, nbalance));
                List<Money> moneyList = db.getRecords();
                for(Money money : moneyList) {
                    String log = money.getID() + "\t" + money.getPurpose() + "\t" + money.getType() + "\t" + money.getAmount() + "\t" + money.getDate() + "\t" + money.getBalance();
                    Log.d("MoneyManagerReader", log);
                }
        }});
        return v;
    }
}
