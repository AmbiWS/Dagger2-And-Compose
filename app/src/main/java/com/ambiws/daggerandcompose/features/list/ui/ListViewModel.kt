package com.ambiws.daggerandcompose.features.list.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ambiws.daggerandcompose.base.BaseViewModel
import com.ambiws.daggerandcompose.features.list.domain.ListInteractor
import com.ambiws.daggerandcompose.features.list.domain.mapper.toItemModel
import com.ambiws.daggerandcompose.features.list.ui.list.CharacterItemModel
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val listInteractor: ListInteractor
) : BaseViewModel() {

    private val _charactersLiveData = MutableLiveData<List<CharacterItemModel>>()
    val charactersLiveData: LiveData<List<CharacterItemModel>> = _charactersLiveData

    init {
        initCharacters()
    }

    private fun initCharacters() {
        launch {
            val characters = withContext(ioContext) {
                listInteractor.getCharacters().map { it.toItemModel() }
            }
            _charactersLiveData.value = characters
        }
    }
}
