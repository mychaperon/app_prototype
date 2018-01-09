package com.example.clement.app_prototype;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

/**
 * Created by Clement on 27/12/2017.
 */

@Database(entities = {Contact.class}, version = 1)

@TypeConverters({Converters.class})
public abstract class ContactDB extends RoomDatabase {

    public static ContactDB getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), ContactDB.class, "contacts_db")
                            .build();
        }
        return INSTANCE;
    }
    private static ContactDB INSTANCE;
    public abstract ContactDAO contactDAO();

}