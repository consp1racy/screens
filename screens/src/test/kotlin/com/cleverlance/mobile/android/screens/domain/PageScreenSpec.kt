package com.cleverlance.mobile.android.screens.domain

import com.cleverlance.mobile.android.screens.presenter.BasePresenterView
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.isA
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.spy
import com.nhaarman.mockito_kotlin.whenever
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
class PageScreenSpec : Spek({
    context("create view") {
        it("should create view") {
            val viewProvider = spy<ViewProvider<BasePresenterView>>()
            val createdView = mock<BasePresenterView>()
            viewProvider.viewProvider = mock { whenever(it.get()).thenReturn(createdView) }
            val screen = PageScreen(viewProvider)

            assertThat(screen.createView(), isA<BasePresenterView>())
        }
    }
})