package com.cuile.shicang.dagger

import android.app.Activity

interface BaseComponent<T> {
    fun inject(target: T)
}

interface BaseActivityComponent<T: Activity> : BaseComponent<T>