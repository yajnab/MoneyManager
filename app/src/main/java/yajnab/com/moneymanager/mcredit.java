package yajnab.com.moneymanager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class mcredit extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_mcredit, container, false);
        final AutoCompleteTextView txtPurpose = (AutoCompleteTextView) v.findViewById(R.id.autoTxtPurpose);
        final EditText txtAmt = (EditText) v.findViewById(R.id.txtAmt);
        final EditText txtDate = (EditText) v.findViewById(R.id.txtDate);
        final Button addbtn = (Button) v.findViewById(R.id.addBtn);
        final TextView chk = (TextView) v.findViewById(R.id.chk);
        Context thiscontext = container.getContext();
        final dbHandler db = new dbHandler(thiscontext);

        addbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();String dates=null;
                if (!txtDate.getText().toString().equals("")) {dates=txtDate.getText().toString();} else {dates=dateFormat.format(date);}
                String s = txtAmt.getText()+" " + dates+" "+ txtPurpose.getText();
                chk.setText(dates);


                db.addMoney(new Money(txtPurpose.getText().toString(),"CR", Float.parseFloat(String.valueOf(txtAmt.getText())), dates, ));
                Log.d("MoneyManagerReader","Reading all MoneyInventory");
                List<Money> moneyList = db.getRecords();
                for(Money money : moneyList){
                    String log =  money.getID()+"\t"+money.getPurpose()+"\t"+money.getType()+"\t"+money.getAmount()+"\t"+money.getDate();
                    Log.d("MoneyManagerReader",log);
                }

            }         });
        return v;
    }
}
