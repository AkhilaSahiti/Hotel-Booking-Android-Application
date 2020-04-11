package com.example.miniproject.storage;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;

import com.example.miniproject.models.Customer;

import java.util.List;

public class Database extends SQLiteOpenHelper {

    private static final int dbVersion = 2;
    private static final String dbName = "customerDb";
    private static final String custTable = "CustomerTable";
    private static final String column_name = "name";
    private static final String column_phone = "phone";
    private static final String column_email = "email";
    private static final String column_room_type = "room_type";
    private static final String column_stay_days = "stay_days";
    private static final String column_pin = "pin";

    public Database(Context context) {
        super(context, dbName, null,dbVersion);
    }
    public interface DatabaseCallback {
        void onCompletion(boolean success);
        void onCustomersRetrieved(List<Customer> employees);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + custTable + " (" + column_name + " TEXT, " + column_phone + " LONG, " + column_email + " TEXT, " + column_room_type + " TEXT, " + column_pin + " INT, "+ column_stay_days + " INT" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + custTable);
        onCreate(db);
    }
    public void addCustomer(final Context context, final Customer customer, final DatabaseCallback listener) {
        AsyncTask.execute(new Runnable() {  //The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread
            @Override
            public void run() {
                SQLiteDatabase db = Database.this.getWritableDatabase();
                ContentValues contentValues = new ContentValues();

                contentValues.put(column_name, customer.getName());
                contentValues.put(column_phone, customer.getPhone());
                contentValues.put(column_email, customer.getEmail());
                contentValues.put(column_room_type, customer.getRoom_type());
                contentValues.put(column_stay_days, customer.getStay_days());
                contentValues.put(column_pin, customer.getPin());

                boolean result = false;
                Cursor cursor = db.query(custTable, new String[]{column_phone}, column_phone + "=?", new String[]{String.valueOf(customer.getPhone())}, null, null, null);
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        if (db.update(custTable, contentValues, column_phone + "=?", new String[]{String.valueOf(customer.getPhone())}) > 0) {
                            result = true;
                        }
                    } else {
                        if (db.insert(custTable, null, contentValues) > 0) { //nullColumnHac is whenever we want to generate null values
                            result = true;
                        }
                    }
                    cursor.close();
                }
                db.close();
                final boolean res = result;
                ((Activity) context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        listener.onCompletion(res);
                    }
                });
            }
        });

    }

    public String checkLoginDetails(final String user_email ) {
        String check_id, check_pin;
        SQLiteDatabase db = Database.this.getReadableDatabase();
        String query1 = "select name, phone, email, room_type, stay_days, pin from "+custTable;
        Cursor cursor1 = db.rawQuery(query1, null);
        check_pin = "not found";
        if(cursor1.moveToFirst()){
            do{
                check_id = cursor1.getString(2);
                if(check_id.equals(user_email)){
                    check_pin = cursor1.getString(5);
                    break;
                }
            }while (cursor1.moveToNext());
            cursor1.close();
        }
        return check_pin;
    }
    public Customer getCustomerDetails(final String check_pin){
        Customer customer = null;
        SQLiteDatabase db = Database.this.getReadableDatabase();
        String query2 = "select * from " + custTable + " where pin = " + check_pin;
        Cursor cursor2 = db.rawQuery(query2, null);
        if(cursor2.moveToFirst()){
            customer = new Customer();
            customer.setName(cursor2.getString(cursor2.getColumnIndex(column_name)));
            customer.setEmail(cursor2.getString(cursor2.getColumnIndex(column_email)));
            customer.setRoom_type(cursor2.getString(cursor2.getColumnIndex(column_room_type)));
            customer.setPhone(cursor2.getLong(cursor2.getColumnIndex(column_phone)));
            customer.setStay_days(cursor2.getInt(cursor2.getColumnIndex(column_stay_days)));
        }
        cursor2.close();
        return customer;
    }
}
