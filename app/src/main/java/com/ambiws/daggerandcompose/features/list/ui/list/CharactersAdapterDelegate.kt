package com.ambiws.daggerandcompose.features.list.ui.list

import com.ambiws.daggerandcompose.databinding.ItemCharacterBinding
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.squareup.picasso.Picasso

object CharactersAdapterDelegate {

    fun charactersDefaultAdapterDelegate(): AdapterDelegate<List<CharacterBaseItemModel>> {
        return adapterDelegateViewBinding<CharacterItemModel, CharacterBaseItemModel, ItemCharacterBinding>(
            { layoutInflater, parent ->
                ItemCharacterBinding.inflate(layoutInflater, parent, false)
            }
        ) {
            bind {
                with(binding) {
                    Picasso.get().load(item.image).into(ivPicture)
                    tvName.text = item.name
                    tvNickname.text = item.nickname
                    tvHouse.text = item.house
                    tvBirthday.text = item.birthdate
                }
            }
        }
    }
}
