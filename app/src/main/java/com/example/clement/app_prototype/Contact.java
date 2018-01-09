package com.example.clement.app_prototype;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Clement on 27/12/2017.
 */

@Entity

public class Contact {
    @PrimaryKey( autoGenerate =  true )
    private int id;
    private String name;

    public Contact() {}

    public Contact( int id, String name )
    {
        this.id = id;
        this.name = name;
    };


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
