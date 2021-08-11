package com.example.testplayground.data

/*@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var instance: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, UserDatabase::class.java, "users")
                .fallbackToDestructiveMigration()
                .build()
    }

}

/*@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            val tempIntanse = INSTANCE
            if (tempIntanse != null) {
                return tempIntanse
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_data"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}*/