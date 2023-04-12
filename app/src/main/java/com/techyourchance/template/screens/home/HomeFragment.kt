package com.techyourchance.template.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.techyourchance.template.R
import com.techyourchance.template.screens.common.ScreenSpec
import com.techyourchance.template.screens.common.ScreensNavigator
import com.techyourchance.template.screens.common.dialogs.DialogsNavigator
import com.techyourchance.template.screens.common.fragments.BaseFragment
import com.techyourchance.template.screens.common.mvcviews.ViewMvcFactory
import kotlinx.coroutines.*
import javax.inject.Inject

class HomeFragment : BaseFragment(), HomeViewMvc.Listener {

    @Inject lateinit var viewMvcFactory: ViewMvcFactory
    @Inject lateinit var dialogsNavigator: DialogsNavigator
    @Inject lateinit var screensNavigator: ScreensNavigator

    private lateinit var viewMvc: HomeViewMvc

    override fun onCreate(savedInstanceState: Bundle?) {
        controllerComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        if (!this::viewMvc.isInitialized) {
            viewMvc = viewMvcFactory.newHomeViewMvc(container)
            viewMvc.bindDestinations(getDestinations())
        }
        return viewMvc.getRootView()
    }

    private fun getDestinations(): List<FromHomeDestination> {
        return listOf(
            FromHomeDestination(
                getString(R.string.from_home_destination_stackoverflow),
                ScreenSpec.StackOverflowQuestionsList
            )
        )
    }

    override fun onStart() {
        super.onStart()
        viewMvc.registerListener(this)
    }

    override fun onStop() {
        super.onStop()
        viewMvc.unregisterListener(this)
    }

    override fun onDestinationClicked(destination: FromHomeDestination) {
        screensNavigator.toScreen(destination.screenSpec)
    }

    companion object {

        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}