package id.ac.umn.week09al_25471;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

@Database(entities = {Mahasiswa.class}, version = 1,
        exportSchema = false)
public abstract class MahasiswaRoomDatabase extends RoomDatabase {
    public abstract MahasiswaDAO daoMahasiswa();
    private static MahasiswaRoomDatabase INSTANCE;
    static MahasiswaRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MahasiswaRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            MahasiswaRoomDatabase.class, "dbMahasiswa")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                }
            };
}
