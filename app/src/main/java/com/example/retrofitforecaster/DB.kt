package com.example.retrofitforecaster

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Database(entities = [Coordinate::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cordDao(): CordDao
}

