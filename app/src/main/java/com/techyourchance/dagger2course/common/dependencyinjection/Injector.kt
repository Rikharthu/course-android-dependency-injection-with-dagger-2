package com.techyourchance.dagger2course.common.dependencyinjection

import android.util.Log
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMvcFactory
import java.lang.reflect.Field

private val TAG = Injector::class.java.simpleName

/*
Basically, that's what Dagger 2 generates along with managing dependency lifecycles
 */
class Injector(private val compositionRoot: PresentationCompositionRoot) {

    fun inject(client: Any) {
        for (field in getAllFields(client)) {
            if (isAnnotatedForInjection(field)) {
                injectField(client, field)
            }
        }
    }

    private fun getAllFields(client: Any): Array<out Field> {
        val clientClass = client::class.java
        return clientClass.declaredFields
    }

    private fun isAnnotatedForInjection(field: Field): Boolean {
        val fieldAnnotations = field.annotations
        for (annotation in fieldAnnotations) {
            if (annotation is Service) {
                return true
            }
        }
        return false
    }

    private fun injectField(client: Any, field: Field) {
        val isAccessibleInitially = field.isAccessible
        field.isAccessible = true
        Log.d(
            TAG,
            "Injecting ${client.javaClass.simpleName}.${field.name} with instance of type ${field.type.simpleName}"
        )
        field.set(client, getServiceForClass(field.type))
        field.isAccessible = isAccessibleInitially
    }

    private fun getServiceForClass(type: Class<*>): Any {
        when (type) {
            DialogsNavigator::class.java -> {
                return compositionRoot.dialogsNavigator
            }
            ScreensNavigator::class.java -> {
                return compositionRoot.screensNavigator
            }
            FetchQuestionsUseCase::class.java -> {
                return compositionRoot.fetchQuestionsUseCase
            }
            FetchQuestionDetailsUseCase::class.java -> {
                return compositionRoot.fetchQuestionDetailsUseCase
            }
            ViewMvcFactory::class.java -> {
                return compositionRoot.viewMvcFactory
            }
            else -> {
                throw IllegalStateException("Unsupported state type: $type")
            }
        }
    }

}