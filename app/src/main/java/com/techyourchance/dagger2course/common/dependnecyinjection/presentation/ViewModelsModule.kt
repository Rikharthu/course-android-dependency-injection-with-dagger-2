package com.techyourchance.dagger2course.common.dependnecyinjection.presentation

import androidx.lifecycle.ViewModel
import com.techyourchance.dagger2course.common.dependnecyinjection.ViewModelKey
import com.techyourchance.dagger2course.screens.viewmodel.MyViewModel
import com.techyourchance.dagger2course.screens.viewmodel.MyViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @IntoMap
    @ViewModelKey(MyViewModel::class)
    @Binds
    abstract fun bindMyViewModel(myViewModel: MyViewModel): ViewModel

    @IntoMap
    @ViewModelKey(MyViewModel2::class)
    @Binds
    abstract fun bindMyViewModel2(myViewModel: MyViewModel2): ViewModel
}