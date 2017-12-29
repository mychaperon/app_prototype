package com.example.clement.app_prototype;

import android.arch.persistence.room.Dao;
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
    List< Contact > GetContacts();

    @Query("DELETE FROM Contact")
    void deleteAllContacts();

}
