package com.techyourchance.dagger2course.common.dependencyinjection.activity

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.common.dependencyinjection.presentation.PresentationComponent
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun newPresentationComponent(): PresentationComponent

    @Subcomponent.Builder
    interface Builder {
        fun build(): ActivityComponent

//        fun activityModule(activityModule: ActivityModule): Builder


        // Individual dependencies
        // Usually inject "bootstrap" objects (those needed by module itself)
        //  into the dependency graph
        @BindsInstance
        fun activity(activity: AppCompatActivity): Builder
    }
}