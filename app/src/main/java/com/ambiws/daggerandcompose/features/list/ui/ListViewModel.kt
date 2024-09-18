package com.ambiws.daggerandcompose.features.list.ui

import com.ambiws.daggerandcompose.base.BaseViewModel
import com.ambiws.daggerandcompose.features.list.data.dataSource.ListDataSource
import com.ambiws.daggerandcompose.utils.logd
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val dataSource: ListDataSource
) : BaseViewModel() {

    fun printCharactersData() {
        logd("Printing Characters...")
        launch {
            logd(dataSource.getCharacters().toString())
        }
    }
}
