package com.example.android.pets.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by User on 7/19/2017.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = PetDbHelper.class.getSimpleName();
    //If you change the database schema, you must increment the database version

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="shelter.db";
    private static final String TEXT_TYPE="TEXT";
    private static final String INTEGER_TYPE="INTEGER";
    private static final String NOT_NULL = "NOT NULL";
    private static final String COMMA_SEP =",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE" + PetsContract.PetEntry.TABLE_NAME + " (" +
                    PetsContract.PetEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    PetsContract.PetEntry.COLUMN_PET_NAME + TEXT_TYPE + NOT_NULL+COMMA_SEP +
                    PetsContract.PetEntry.COLUMN_PET_BREED + TEXT_TYPE +COMMA_SEP +
                    PetsContract.PetEntry.COLUMN_PET_GENDER + INTEGER_TYPE + NOT_NULL+COMMA_SEP+
                    PetsContract.PetEntry.COLUMN_PET_WEIGHT + INTEGER_TYPE +NOT_NULL+"DEFAULT 0"+
                    " )";

    private static final String SQL_DELETE_ENTRIES=
            "DROP TABLE IF EXISTS " + PetsContract.PetEntry.TABLE_NAME;

    public PetDbHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
