package com.ambiws.daggerandcompose.features.dashboard.ui.navbar

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.ambiws.daggerandcompose.R
import com.ambiws.daggerandcompose.databinding.ViewBottomNavbarBinding

class BottomNavbarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : BottomNavbar, ConstraintLayout(context, attrs) {
    private val binding: ViewBottomNavbarBinding =
        ViewBottomNavbarBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )

    private val viewsList = listOf(
        binding.ivHome to binding.tvHome,
        binding.ivList to binding.tvList,
        binding.ivProfile to binding.tvProfile
    )

    override var currentActiveTab = BottomItem.HOME

    override var prevActiveTab = BottomItem.HOME

    override var destinationListener: ((activeBottomItem: BottomItem, commitNow: Boolean) -> Unit)? =
        null

    init {
        setActiveTabsColor()
        setActiveTab(currentActiveTab)
        setListeners()
    }

    private fun setActiveTabsColor() {
        BottomItem.HOME.colorTitleActive = R.color.secondary
        BottomItem.HOME.iconResActive = R.drawable.ic_home_selected
        BottomItem.LIST.colorTitleActive = R.color.secondary
        BottomItem.LIST.iconResActive = R.drawable.ic_list_selected
        BottomItem.PROFILE.colorTitleActive = R.color.secondary
        BottomItem.PROFILE.iconResActive = R.drawable.ic_profile_selected
    }

    private fun setListeners() {
        with(binding) {
            val homeListener = OnClickListener {
                setActiveTab(BottomItem.HOME)
            }
            ivHome.setOnClickListener(homeListener)
            tvHome.setOnClickListener(homeListener)

            val listListener = OnClickListener {
                setActiveTab(BottomItem.LIST)
            }
            ivList.setOnClickListener(listListener)
            tvList.setOnClickListener(listListener)

            val profileListener = OnClickListener {
                setActiveTab(BottomItem.PROFILE)
            }
            ivProfile.setOnClickListener(profileListener)
            tvProfile.setOnClickListener(profileListener)
        }
    }

    override fun setActiveTab(activeBottomItem: BottomItem) {
        destinationListener?.invoke(activeBottomItem, true)
        prevActiveTab = currentActiveTab
        currentActiveTab = activeBottomItem
        viewsList.forEach {
            if (it.first.id == activeBottomItem.viewId) {
                it.first.setImageResource(activeBottomItem.iconResActive)
                it.second.setTextColor(context.getColor(activeBottomItem.colorTitleActive))
            } else {
                it.first.setImageResource(BottomItem.findByViewID(it.first.id).iconResDefault)
                it.second.setTextColor(context.getColor(BottomItem.findByViewID(it.first.id).colorTitleDefault))
            }
        }
    }

    override fun onSaveInstanceState(): Parcelable {
        val bundle = Bundle()
        bundle.putInt(SELECTED_TAB_STATE, currentActiveTab.viewId)
        bundle.putParcelable(SUPER_STATE, super.onSaveInstanceState())
        return bundle
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        if (state is Bundle) {
            val activeTab = state.getInt(SELECTED_TAB_STATE, R.id.ivHome)
            setActiveTab(BottomItem.findByViewID(activeTab))
            super.onRestoreInstanceState(state.getParcelable(SUPER_STATE))
        }
    }

    companion object {
        private const val SELECTED_TAB_STATE = "selectedTab"
        private const val SUPER_STATE = "superState"
    }
}
