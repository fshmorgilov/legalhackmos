package com.themaker.fshmo.legalhackmos.data;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.themaker.fshmo.klassikaplus.data.persistence.dao.ItemDao;
import com.themaker.fshmo.klassikaplus.data.persistence.dao.PhotoDao;
import com.themaker.fshmo.klassikaplus.data.persistence.model.DbItem;
import com.themaker.fshmo.klassikaplus.data.persistence.model.DbPhoto;

@Database(entities = {
        DbItem.class,
        DbPhoto.class
}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ItemDao itemDao();
    public abstract PhotoDao photoDao();

    private static final String DATABASE_NAME = "klassikaplus.db";

    public static AppDatabase provideRoomDatabase(@NonNull final Application application) {
        return Room.databaseBuilder(application,
                AppDatabase.class,
                DATABASE_NAME)
                .build();
    }
}