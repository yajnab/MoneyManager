package yajnab.com.moneymanager;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.content.Intent.getIntent;


/**
 * A simple {@link Fragment} subclass.
 */
public class mhome extends Fragment {
    private String myJSONString;
    private JSONArray users = null;
    private final String JSON_ARRAY = "moneymanager";

    private int TRACK = 0;
    private static final String KEY_PURPOSE="prps";
    private static final String KEY_TYPE="type";
    private static final String KEY_AMT="amt";
    private static final String KEY_DATE="date";
    private static final String KEY_BALANCE="balance";


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
        //Get the JSONString
        //String JSONstr = getJSON("http://192.168.1.209/dbjson.php");
        String JSONstr = "{\"moneymanager\":[{\"id\":\"1\",\"prps\":\"Initial\",\"type\":\"INIT\",\"amt\":\"5000.000\",\"date\":\"2016-06-06\",\"balance\":\"5000.000\"},{\"id\":\"5\",\"prps\":\"Bus Fare\",\"type\":\"CR\",\"amt\":\"25.000\",\"date\":\"2016-06-15\",\"balance\":\"4975.000\"},{\"id\":\"6\",\"prps\":\"Bus Fare\",\"type\":\"CR\",\"amt\":\"25.000\",\"date\":\"2016-07-16\",\"balance\":\"4950.000\"},{\"id\":\"7\",\"prps\":\"Bus Fare\",\"type\":\"CR\",\"amt\":\"500.000\",\"date\":\"2016-06-07\",\"balance\":\"4450.000\"},{\"id\":\"8\",\"prps\":\"Bus Fare\",\"type\":\"CR\",\"amt\":\"220.000\",\"date\":\"2016-07-14\",\"balance\":\"4230.000\"},{\"id\":\"9\",\"prps\":\"Biriyani\",\"type\":\"CR\",\"amt\":\"60.000\",\"date\":\"2016-07-20\",\"balance\":\"4170.000\"},{\"id\":\"10\",\"prps\":\"Chicken Roll\",\"type\":\"CR\",\"amt\":\"30.000\",\"date\":\"2016-07-11\",\"balance\":\"4140.000\"},{\"id\":\"11\",\"prps\":\"Chicken Roll\",\"type\":\"CR\",\"amt\":\"30.000\",\"date\":\"2016-07-21\",\"balance\":\"4110.000\"}]}";
        //Update the Database
        try {
            JSONObject  jsonRootObject = new JSONObject(JSONstr);

            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jsonRootObject.optJSONArray("moneymanager");

            //Iterate the jsonArray and print the info of JSONObjects
            for(int i=0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
              db.addMoney(new Money(
                    jsonObject.getString(KEY_PURPOSE),
                    jsonObject.getString(KEY_TYPE),
                    (float) jsonObject.getDouble(KEY_AMT),
                    jsonObject.getString(KEY_DATE),
                    (float) jsonObject.getDouble(KEY_BALANCE)
            ));
        }}
        catch(Exception e){
            e.printStackTrace();
        }

        String balance = String.valueOf(db.getLastRecord().getBalance());
        String lTrans = db.getLastRecord().getPurpose() + "\t" + db.getLastRecord().getType() + "\t" + db.getLastRecord().getAmount() + "\t" + db.getLastRecord().getDate();
        txtHomeBal.setText(balance);
        txtHomeTrans.setText(lTrans);
        return v;

    }
    public String getJSON(String uri){
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(uri);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            StringBuilder sb = new StringBuilder();

            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String json;
            while((json = bufferedReader.readLine())!= null){
                sb.append(json+"\n");
            }

            return sb.toString().trim();

        }catch(Exception e){
            return null;
        }
    }

}
