package id.ac.umn.week09al_25471;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MahasiswaDAO {
    @Query("SELECT * FROM tblMahasiswa")
    LiveData<List<Mahasiswa>> getAllMahasiswa();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Mahasiswa mhs);
    @Delete
    void delete(Mahasiswa mhs);
    @Update
    void update(Mahasiswa mhs);
    @Query("DELETE FROM tblMahasiswa")
    void deleteAll();
}