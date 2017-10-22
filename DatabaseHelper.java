package com.example.pallavi.reelreview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pallavi on 08-10-2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
private static  final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "project.db";
    private static final String TABLE_NAME = "contacts";
    private static final String TABLE_NAME_MOVIES = "movies";
    private static final String TABLE_NAME_REVIEWS = "reviews";

    //contacts table column names
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";

    //movies table column names
    private  static  final  String MNAME = "mname";
    private  static  final  String MYEAR = "myear";
    private  static  final  String MRATE = "mrate";
    private  static  final  String MTIME = "mtime";
    private  static  final  String MGENRE = "mgenre";
    private  static  final  String MDESCRIPTION = "mdescription";
    private  static  final  String MCAST = "mcast";

    //reviews table columns
    private static final String EMAIL = "email";
    private static final String MOVIENAME = "mname";
    private static final String REVIEW1 = "review1";
    private static final String REVIEW2 = "review21";
    private static final String REVIEW3 = "review3";
    private static final String REVIEW4 = "review4";
    private static final String REVIEW5 = "review5";
    SQLiteDatabase db;

    //creation of tables
    private static  final String TABLE_CREATE = "create table contacts (name text not null , email text not null primary key , password text not null);";
    private static String CREATE_MOVIES = "create table movies (mname text primary key , myear text not null , mrate text not null , mtime text not null , mgenre text not null , mdescription text not null , mcast text not null); ";
   private static String CREATE_REVIEWS = "create table reviews (email text , mname text , review1 text , review2 text , review3 text , review4 text , review5 text , foreign key (email) references contacts (email) , foreign key (mname) references movies (mname);";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(CREATE_MOVIES);
        db.execSQL(CREATE_REVIEWS);
        this.db = db;

    }

    public void insertContact(Contact c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select email,password from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();


        values.put(COLUMN_NAME,c.getName());
        values.put(COLUMN_EMAIL,c.getEmail());
        values.put(COLUMN_PASSWORD,c.getPassword());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public void insertMovies(){
        db = this.getWritableDatabase();
        String sql = "insert into movies values(mname, myear, mrate, mtime, mgenre, mdescription, mcast) values ('Drive','2011','7.8/1.','100mins','action film','A mysterious Hollywood stuntman and mechanic moonlights as a getaway driver and finds himself in trouble when he helps out his neighbor.','Stars: Ryan Gosling, Carey Mulligan, Bryan Cranston, Albert Brooks'), " +
                "('Inception' , '2010' , '8.8/10','148mins','action film','A thief, who steals corporate secrets through use of dream-sharing technology, is given the inverse task of planting an idea into the mind of a CEO.','Stars: Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page, Ken Watanabe'),('It' , '2017', '7.9/10', '165min','horror','A group of bullied kids band together when a shapeshifting demon, taking the appearance of a clown, begins hunting children.',' Bill Skarsgård, Jaeden Lieberher, Finn Wolfhard');";
    }

public String searchPass(String email){

    db = this.getReadableDatabase();
    String query = "select * from "+TABLE_NAME;
    Cursor cursor = db.rawQuery(query,null);
    String a,b;
    b = "not found";
    if(cursor.moveToFirst()){
        do {
            a= cursor.getString(1);


            if(a.equals(email)){
                b = cursor.getString(2);
                break;
            }
        }while(cursor.moveToNext());
    }
    return b;
}
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        db.execSQL(query);
        String query2 = "DROP TABLE IF EXISTS "+TABLE_NAME_MOVIES;
        String query3 = "DROP TABLE IF EXISTS "+TABLE_NAME_REVIEWS;
        db.execSQL(query2);
        db.execSQL(query3);
        this.onCreate(db);

    }
}
