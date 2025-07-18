package com.ambiws.daggerandcompose.features.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ambiws.daggerandcompose.base.BaseViewModel
import com.ambiws.daggerandcompose.features.home.domain.HousesInteractor
import com.ambiws.daggerandcompose.features.home.domain.mapper.toItemModel
import com.ambiws.daggerandcompose.features.home.ui.list.HouseItemModel
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val housesInteractor: HousesInteractor
) : BaseViewModel() {

    private val _housesLiveData = MutableLiveData<List<HouseItemModel>>()
    val housesLiveData: LiveData<List<HouseItemModel>> = _housesLiveData

    init {
        initHouses()
    }

    private fun initHouses() {
        launch {
            val houses = withContext(ioContext) {
                housesInteractor.getHouses().map {
                    it.toItemModel()
                }
            }
            _housesLiveData.value = houses
        }
    }
}
