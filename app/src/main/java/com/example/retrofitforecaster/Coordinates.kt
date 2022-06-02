package com.example.retrofitforecaster

import androidx.room.*


@Dao
interface CordDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
   // suspend fun insertAll(cord: List<Coordinate>)
    suspend fun insertAll(cord: Coordinate)
   // fun insert(cord: List<String>)

    @Query("SELECT * FROM Coordinate_data")
    fun getAll(): List<Coordinate>

    @Query("SELECT x FROM Coordinate_data")
    fun getX(): String

    @Query("SELECT y FROM Coordinate_data")
    fun getY(): String

}
/*
@Dao
internal abstract class CordDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(entity: T)
    @Update
    abstract fun update(entity: T)
    @Delete
    abstract fun delete(entity: T)
}

*/



