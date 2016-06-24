package yajnab.com.moneymanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        addbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                String s = txtAmt.getText()+" " + txtDate.getText()+" "+ txtPurpose.getText();
                chk.setText(s);

            }         });
    }


}
