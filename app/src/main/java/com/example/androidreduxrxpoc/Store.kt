package com.example.androidreduxrxpoc

import org.reduxkotlin.createThreadSafeStore

val store = createThreadSafeStore(::rootReducer, AppState())