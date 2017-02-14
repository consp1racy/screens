package com.cleverlance.mobile.android.screens.domain

import android.app.Activity
import com.cleverlance.mobile.android.screens.presenter.ScreenPresenter

abstract class ScreenInvoker {
    abstract val screenPresenter: ScreenPresenter
    abstract val screenFactory: ScreenFactory

    // TODO rename showScreen()
    open fun createScreen(back: ((Activity) -> Boolean)? = null) = with(screenPresenter) {
        setScreen(screenFactory.createScreen(
                back = back ?: screenPresenter.onBackShowPrevious()))
    }
}