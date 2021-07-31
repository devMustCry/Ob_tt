package com.ismael.ob_tt.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ismael.ob_tt.data.model.Champ

@Dao
interface ChampDao {

    @Query("SELECT * FROM champs")
    fun getAllChamps() : LiveData<List<Champ>>

    @Query("SELECT * FROM champs WHERE id = :id")
    fun getChamp(id: String): LiveData<Champ>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(Champs: List<Champ>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(Champ: Champ)

}