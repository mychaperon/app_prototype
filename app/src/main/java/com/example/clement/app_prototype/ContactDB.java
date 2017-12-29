package com.example.clement.app_prototype;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

/**
 * Created by Clement on 27/12/2017.
 */

@Database(entities = {Contact.class},version = 1)

@TypeConverters({Converters.class})
public abstract class ContactDB extends RoomDatabase {

    public abstract ContactDAO contactDAO();

}