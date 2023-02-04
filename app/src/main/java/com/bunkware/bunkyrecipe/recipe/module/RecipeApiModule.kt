package com.bunkware.bunkyrecipe.module


import com.bunkware.bunkyrecipe.api.RecipeApi
import com.bunkware.bunkyrecipe.utils.Constants.Companion.RECIPE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CharacterApiModule {

    @Provides
    @Singleton
    fun provideApi(builder: Retrofit.Builder): RecipeApi {
        return builder
            .build()
            .create(RecipeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(RECIPE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }
}



