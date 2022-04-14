package klt.mdy.contactspicker.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import klt.mdy.contactspicker.repo.ContactsRepository
import klt.mdy.contactspicker.repo.ContactsRepositoryImpl
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppRepo {
    @Provides
    @Singleton
    fun provideContactsRepository(
        @ApplicationContext context: Context,
        @Qualifier.Io io: CoroutineDispatcher
    ): ContactsRepository {
        return ContactsRepositoryImpl(
            context = context,
            io = io
        )
    }
}