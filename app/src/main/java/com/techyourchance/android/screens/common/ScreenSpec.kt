package com.techyourchance.android.screens.common

import java.io.Serializable

@Suppress("ClassName")
sealed class ScreenSpec(val activityName: ActivityName): Serializable {
    object Home: ScreenSpec(ActivityName.MAIN)
    object StackOverflowQuestionsList: ScreenSpec(ActivityName.MAIN)
    data class StackOverflowQuestionDetails(val questionId: String): ScreenSpec(ActivityName.MAIN)
    object BiometricLock: ScreenSpec(ActivityName.MAIN)
    object NdkBasics: ScreenSpec(ActivityName.MAIN)
    object ForegroundService: ScreenSpec(ActivityName.MAIN)
    object WorkManager: ScreenSpec(ActivityName.MAIN)
    object Animations: ScreenSpec(ActivityName.MAIN)
    object StackedCardsAnimation: ScreenSpec(ActivityName.MAIN)

    companion object {
        /**
         * Intent extra key for Serialized ScreenSpec's
         */
        const val INTENT_EXTRA_SCREEN_SPEC = "INTENT_EXTRA_SCREEN_SPEC"
    }

}