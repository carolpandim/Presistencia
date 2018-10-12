package com.example.logonrmlocal.presistencia.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.logonrmlocal.presistencia.model.Game

@Database(entities = arrayOf(Game::class), version = 1)
abstract class BancoDeDados : RoomDatabase() {

    abstract fun GameDAO(): GameDAO

    companion object {
        var INSTANCE: BancoDeDados? = null


        fun getDataBase(context: Context): BancoDeDados? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                        BancoDeDados::class.java,
                        "gamesdbs").build()
            }
            return INSTANCE
        }
    }
}