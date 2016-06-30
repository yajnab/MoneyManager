package yajnab.com.moneymanager;

import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private ViewPager viewpager;
    //private TabsPagerAdapter mAdapter;
    //private ActionBar actionBar;
    private String[] tabs= {"Credit", "Debit"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        for(String tab_name : tabs) {
            tabLayout.addTab(tabLayout.newTab().setText(tab_name));
        }
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        /*final AutoCompleteTextView txtPurpose = (AutoCompleteTextView) findViewById(R.id.autoTxtPurpose);
        final EditText txtAmt = (EditText) findViewById(R.id.txtAmt);
        final EditText txtDate = (EditText) findViewById(R.id.txtDate);
        final Button addbtn = (Button) findViewById(R.id.addBtn);
        final TextView chk = (TextView) findViewById(R.id.chk);

        final dbHandler db = new dbHandler(this);

        addbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();String dates=null;
                if (!txtDate.getText().toString().equals("")) {dates=txtDate.getText().toString();} else {dates=dateFormat.format(date);}
                String s = txtAmt.getText()+" " + dates+" "+ txtPurpose.getText();
                chk.setText(dates);


                db.addMoney(new Money(txtPurpose.getText().toString(),"mcredit", Float.parseFloat(String.valueOf(txtAmt.getText())), dates));
                Log.d("MoneyManagerReader","Reading all MoneyInventory");
                List<Money> moneyList = db.getRecords();
                for(Money money : moneyList){
                    String log =  money.getID()+"\t"+money.getPurpose()+"\t"+money.getType()+"\t"+money.getAmount()+"\t"+money.getDate();
                    Log.d("MoneyManagerReader",log);
                }

            }         });*/
    }
}
