package minds.technited.shaadiassignment.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import minds.technited.shaadiassignment.data.local.dao.ProfilesDao
import minds.technited.shaadiassignment.data.remote.RemoteDataSource
import minds.technited.shaadiassignment.data.repoitory.MainRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: ProfilesDao
    ) = MainRepository(remoteDataSource, localDataSource)


}
