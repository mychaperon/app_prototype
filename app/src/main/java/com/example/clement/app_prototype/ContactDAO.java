package com.example.clement.app_prototype;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by Clement on 27/12/2017.
 */

@Dao
public interface ContactDAO {
    @Insert( onConflict = OnConflictStrategy.REPLACE )
    void insertContact (Contact contact);

    @Query("SELECT * FROM Contact")
    LiveData<List<Contact>> getAllContacts();

    @Query( "SELECT * FROM Contact WHERE id = :id")
    Contact getContactById( String id );

    @Query("DELETE FROM Contact")
    void deleteAllContacts();

    @Delete
    void deleteContact( Contact contact );

}
