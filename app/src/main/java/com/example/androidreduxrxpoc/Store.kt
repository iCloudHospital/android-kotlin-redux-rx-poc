package com.example.androidreduxrxpoc

import org.reduxkotlin.createThreadSafeStore

// Ininitialize the store; reducers found in ./Reducers.kt
val store = createThreadSafeStore(::rootReducer, AppState())