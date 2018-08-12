package com.blink22.android.todoapp.di.modules;

import android.app.Application;
import android.content.Context;

import com.blink22.android.todoapp.data.AppDataManager;
import com.blink22.android.todoapp.data.DataManager;
import com.blink22.android.todoapp.data.firestore.AppFirestoreHelper;
import com.blink22.android.todoapp.data.firestore.FirestoreHelper;
import com.blink22.android.todoapp.data.prefrences.AppPreferencesHelper;
import com.blink22.android.todoapp.data.prefrences.PreferencesHelper;
import com.google.firebase.firestore.FirebaseFirestore;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    Context provideContext() {
        return mApplication;
    }

    @Singleton
    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    FirestoreHelper provideFirestoreHelper(AppFirestoreHelper appFirestoreHelper) {
        return appFirestoreHelper;
    }

    @Provides
    @Singleton
    FirebaseFirestore provideFirebaseFirestore() {
        return FirebaseFirestore.getInstance();
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }
}