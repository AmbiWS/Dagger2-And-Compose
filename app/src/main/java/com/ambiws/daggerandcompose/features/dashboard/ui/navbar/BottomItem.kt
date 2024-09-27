package com.ambiws.daggerandcompose.features.dashboard.ui.navbar

import com.ambiws.daggerandcompose.R

@Suppress("unused")
enum class BottomItem(
    val rootId: Int,
    val viewId: Int,
    val iconResDefault: Int,
    var iconResActive: Int,
    val title: Int,
    val colorTitleDefault: Int,
    var colorTitleActive: Int,
) {
    HOME(
        1,
        R.id.ivHome,
        R.drawable.ic_home,
        R.drawable.ic_home_selected,
        R.string.home,
        R.color.grey,
        R.color.secondary
    ),
    LIST(
        2,
        R.id.ivList,
        R.drawable.ic_list,
        R.drawable.ic_list_selected,
        R.string.list,
        R.color.grey,
        R.color.secondary
    ),
    PROFILE(
        3,
        R.id.ivProfile,
        R.drawable.ic_profile,
        R.drawable.ic_profile_selected,
        R.string.profile,
        R.color.grey,
        R.color.secondary
    );

    companion object {
        fun findByViewID(viewId: Int): BottomItem =
            values().firstOrNull { it.viewId == viewId } ?: HOME
    }
}
