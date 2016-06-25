package yajnab.com.moneymanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AutoCompleteTextView txtPurpose = (AutoCompleteTextView) findViewById(R.id.autoTxtPurpose);
        final EditText txtAmt = (EditText) findViewById(R.id.txtAmt);
        final EditText txtDate = (EditText) findViewById(R.id.txtDate);
        final Button addbtn = (Button) findViewById(R.id.addBtn);
        final TextView chk = (TextView) findViewById(R.id.chk);

        final dbHandler db = new dbHandler(this);

        addbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                String s = txtAmt.getText()+" " + txtDate.getText()+" "+ txtPurpose.getText();
                chk.setText(s);
                db.addMoney(new Money(txtPurpose.getText().toString(),"expd", Float.parseFloat(String.valueOf(txtAmt.getText())), "2015-06-06"));
                Log.d("MoneyManagerReader","Reading all MoneyInventory");
                List<Money> moneyList = db.getRecords();
                for(Money money : moneyList){
                    String log =  money.getID()+"\t"+money.getPurpose()+"\t"+money.getType()+"\t"+money.getAmount()+"\t"+money.getDate();
                    Log.d("MoneyManagerReader",log);
                }

            }         });
    }



}
