package com.ismael.ob_tt.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ismael.ob_tt.data.model.Champ

@Dao
interface ComicsDao {

    @Query("SELECT * FROM comics")
    fun getAllChamps() : LiveData<List<Comics>>

    @Query("SELECT * FROM champs WHERE id = :id")
    fun getChamp(id: String): LiveData<Comics>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(Comics: List<Comics>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(Comic: Comics)

}