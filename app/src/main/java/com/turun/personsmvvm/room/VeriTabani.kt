package com.turun.personsmvvm.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.turun.personsmvvm.data.entity.Kisiler

@Database(entities = [Kisiler::class], version = 1)
abstract class VeriTabani:RoomDatabase() {

    abstract fun getKisilerDao():KisilerDao
}