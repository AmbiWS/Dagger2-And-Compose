package com.ambiws.daggerandcompose.features.list.ui

import com.ambiws.daggerandcompose.base.BaseViewModel
import com.ambiws.daggerandcompose.features.list.domain.ListInteractor
import com.ambiws.daggerandcompose.features.list.domain.mapper.toItemModel
import com.ambiws.daggerandcompose.utils.logd
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val listInteractor: ListInteractor
) : BaseViewModel() {

    fun printCharactersData() {
        logd("Printing Characters...")
        launch {
            logd(listInteractor.getCharacters().map { it.toItemModel() }.toString())
        }
    }
}
