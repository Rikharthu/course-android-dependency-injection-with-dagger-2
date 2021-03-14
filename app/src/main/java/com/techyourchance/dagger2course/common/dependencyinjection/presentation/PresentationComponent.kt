package com.techyourchance.dagger2course.common.dependencyinjection.presentation

import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListFragment
import dagger.Subcomponent

@PresentationScope
@Subcomponent
interface PresentationComponent {

    // Provision methods
//    fun viewMvcFactory(): ViewMvcFactory
//
//    fun dialogsNavigator(): DialogsNavigator
//
//    fun screensNavigator(): ScreensNavigator
//
//    fun fetchQuestionsUseCase(): FetchQuestionsUseCase
//
//    fun fetchQuestionDetailsUseCase(): FetchQuestionDetailsUseCase


    // Members-injection methods
    /*
    Void methods with single argument defined on components generate injectors for the type
    of the argument
     */

    fun inject(fragment: QuestionsListFragment)

    fun inject(fragment: QuestionDetailsActivity)

}