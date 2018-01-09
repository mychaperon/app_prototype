package com.example.clement.app_prototype;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by Clement on 08/01/2018.
 */

public class AddContactViewModel extends AndroidViewModel {

    private ContactDB appDatabase;

    public AddContactViewModel(Application application) {
        super(application);
        appDatabase = ContactDB.getDatabase(this.getApplication());
    }

    public void addBorrow(final Contact contact) {
        new addAsyncTask(appDatabase).execute(contact);
    }

    private static class addAsyncTask extends AsyncTask<Contact, Void, Void> {

        private ContactDB db;

        addAsyncTask(ContactDB appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(Contact... contacts) {
            db.contactDAO().deleteContact( contacts[0] );
            return null;
        }
    }
}
