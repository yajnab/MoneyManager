package yajnab.com.moneymanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.app.ActionBar;
import android.app.ActionBar.TabListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    private ViewPager viewpager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    private String[] tabs= {"Credit", "Debit"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Fragmentation
        viewpager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

        viewpager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //Adding the Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });




        final AutoCompleteTextView txtPurpose = (AutoCompleteTextView) findViewById(R.id.autoTxtPurpose);
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

            }         });
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, android.app.FragmentTransaction fragmentTransaction) {
            viewpager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.app.FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.app.FragmentTransaction fragmentTransaction) {

    }
}
