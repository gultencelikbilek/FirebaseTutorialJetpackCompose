package com.example.firebasetutorialjetpackcompose.di

import com.example.firebasetutorialjetpackcompose.firebase.auth.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun providesFirebaseFireStore() = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun providesRepository(
        firebaseAuth: FirebaseAuth
    ) :AuthRepository{
        return AuthRepositoryImpl(firebaseAuth)
    }
}