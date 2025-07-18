package com.ambiws.daggerandcompose.features.home.ui.list

import com.ambiws.daggerandcompose.databinding.ItemHouseBinding
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object HousesAdapterDelegate {

    fun housesDefaultAdapterDelegate(): AdapterDelegate<List<HouseBaseItemModel>> {
        return adapterDelegateViewBinding<HouseItemModel, HouseBaseItemModel, ItemHouseBinding>(
            { layoutInflater, parent ->
                ItemHouseBinding.inflate(layoutInflater, parent, false)
            }
        ) {
            bind {
                with(binding) {
                    tvHouse.text = item.house
                    tvHouseEmoji.text = item.emoji
                    tvFounder.text = item.founder
                    tvColors.text = item.colors
                    tvAnimal.text = item.animal
                }
            }
        }
    }
}
