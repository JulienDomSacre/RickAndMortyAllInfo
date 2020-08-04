package com.choala.local.di

import androidx.room.Room
import com.choala.local.db.DataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            DataBase::class.java,
            "product_database"
        )
            .build()
    }

    factory { get<DataBase>().characterDao() }
    factory { get<DataBase>().locationDao() }
    factory { get<DataBase>().episodeDao() }
}