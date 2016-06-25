package yajnab.com.moneymanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yajnab on 25/6/16.
 */
public class dbHandler extends SQLiteOpenHelper {
    private static final int DATABSE_VERSION=1;
    private static final String dbName= "moneymanagerdb";
    private static final String TableName="moneyinventory";
    private static final String KEY_ID="id";
    private static final String KEY_PURPOSE="prps";
    private static final String KEY_TYPE="type";
    private static final String KEY_AMT="amt";
    private static final String KEY_DATE="date";

    public dbHandler(Context context){
        super(context,dbName, null, DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createquery = "CREATE TABLE "+ TableName +"("+KEY_ID+" INTEGER PRIMARY KEY,"+ KEY_PURPOSE+ " TEXT, "+ KEY_TYPE+" TEXT, "+KEY_AMT+" FLOAT,"+ KEY_DATE+ " DATETIME)";
        sqLiteDatabase.execSQL(createquery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF TABLE EXISTS "+TableName);
    }

    public void addMoney(Money money){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(KEY_PURPOSE, money.getPurpose());
        values.put(KEY_TYPE, money.getType());
        values.put(KEY_AMT, money.getAmount());
        values.put(KEY_DATE, money.getDate());

        //Insertion
        db.insert(TableName, null, values);
        db.close();


    }
}