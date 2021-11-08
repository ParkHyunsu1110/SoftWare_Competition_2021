package com.example.software;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface GraphInfoDAO {
    @Query("SELECT * FROM GraphInfo")
    List<GraphInfo> getAll();

    @Insert
    void insert(GraphInfo graphInfo);

    @Update
    void update(GraphInfo graphInfo);

    @Delete
    void delete(GraphInfo graphInfo);

}
