package com.example.androidreduxrxpoc.stores

import com.example.androidreduxrxpoc.reducers.AppState
import com.example.androidreduxrxpoc.reducers.rootReducer
import org.reduxkotlin.createThreadSafeStore

// Ininitialize the store; reducers found in ./Reducers.kt
val store = createThreadSafeStore(::rootReducer, AppState())