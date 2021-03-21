package com.techyourchance.dagger2course.screens.common.dialogs

import androidx.fragment.app.DialogFragment
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity

abstract class BaseDialog : DialogFragment() {

    private val activityComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent
    }

    private val presentationComponent by lazy {
        activityComponent.newPresentationComponent()
    }
}