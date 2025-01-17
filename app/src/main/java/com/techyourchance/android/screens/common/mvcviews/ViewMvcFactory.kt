package com.techyourchance.android.screens.common.mvcviews

import android.view.LayoutInflater
import android.view.ViewGroup
import com.techyourchance.android.common.imageloader.ImageLoader
import com.techyourchance.android.screens.animations.AnimationsViewMvc
import com.techyourchance.android.screens.animations.AnimationsViewMvcImpl
import com.techyourchance.android.screens.animations.stackedcards.StackedCardsAnimationViewMvc
import com.techyourchance.android.screens.animations.stackedcards.StackedCardsAnimationViewMvcImpl
import com.techyourchance.android.screens.biometricauth.BiometricAuthViewMvc
import com.techyourchance.android.screens.biometricauth.BiometricAuthViewMvcImpl
import com.techyourchance.android.screens.foregroundservice.ForegroundServiceViewMvc
import com.techyourchance.android.screens.foregroundservice.ForegroundServiceViewMvcImpl
import com.techyourchance.android.screens.home.HomeViewMvc
import com.techyourchance.android.screens.home.HomeViewMvcImpl
import com.techyourchance.android.screens.ndkbasics.NdkBasicsViewMvc
import com.techyourchance.android.screens.ndkbasics.NdkBasicsViewMvcImpl
import com.techyourchance.android.screens.questiondetails.QuestionDetailsViewMvc
import com.techyourchance.android.screens.questiondetails.QuestionDetailsViewMvcImpl
import com.techyourchance.android.screens.questionslist.QuestionsListViewMvc
import com.techyourchance.android.screens.questionslist.QuestionsListViewMvcImpl
import com.techyourchance.android.screens.workmanager.WorkManagerViewMvc
import com.techyourchance.android.screens.workmanager.WorkManagerViewMvcImpl
import javax.inject.Inject
import javax.inject.Provider

class ViewMvcFactory @Inject constructor(
    private val layoutInflaterProvider: Provider<LayoutInflater>,
    private val imageLoaderProvider: Provider<ImageLoader>
) {

    private val inflater get() = layoutInflaterProvider.get()
    private val imageLoader get() = imageLoaderProvider.get()


    fun newHomeViewMvc(container: ViewGroup?): HomeViewMvc {
        return HomeViewMvcImpl(inflater, container)
    }

    fun newQuestionsListViewMvc(container: ViewGroup?): QuestionsListViewMvc {
        return QuestionsListViewMvcImpl(inflater, container)
    }

    fun newQuestionDetailsViewMvc(container: ViewGroup?): QuestionDetailsViewMvc {
        return QuestionDetailsViewMvcImpl(inflater, container)
    }

    fun newBiometricLockViewMvc(container: ViewGroup?): BiometricAuthViewMvc {
        return BiometricAuthViewMvcImpl(inflater, container)
    }

    fun newNdkBasicsViewMvc(container: ViewGroup?): NdkBasicsViewMvc {
        return NdkBasicsViewMvcImpl(inflater, container)
    }

    fun newForegroundServiceViewMvc(container: ViewGroup?): ForegroundServiceViewMvc {
        return ForegroundServiceViewMvcImpl(inflater, container)
    }

    fun newWorkManagerViewMvc(container: ViewGroup?): WorkManagerViewMvc {
        return WorkManagerViewMvcImpl(inflater, container)
    }

    fun newAnimationsViewMvc(container: ViewGroup?): AnimationsViewMvc {
        return AnimationsViewMvcImpl(inflater, container)
    }

    fun newStackedCardsAnimationViewMvc(container: ViewGroup?): StackedCardsAnimationViewMvc {
        return StackedCardsAnimationViewMvcImpl(inflater, container)
    }
}