package pt.isec.a21220683.minesweeper.DataBase;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


public class DBHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "DB_Minesweeper.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }


}
