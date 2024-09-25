package com.ambiws.daggerandcompose.features.list.ui

import androidx.recyclerview.widget.LinearLayoutManager
import com.ambiws.daggerandcompose.base.BaseFragment
import com.ambiws.daggerandcompose.base.list.DefaultListDiffer
import com.ambiws.daggerandcompose.databinding.FragmentListBinding
import com.ambiws.daggerandcompose.features.list.ui.list.CharacterBaseItemModel
import com.ambiws.daggerandcompose.features.list.ui.list.CharactersAdapterDelegate
import com.ambiws.daggerandcompose.utils.extensions.subscribe
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class ListFragment : BaseFragment<ListViewModel, FragmentListBinding>(
    FragmentListBinding::inflate
) {

    private val adapter by lazy {
        AsyncListDifferDelegationAdapter(
            DefaultListDiffer<CharacterBaseItemModel>(),
            CharactersAdapterDelegate.charactersDefaultAdapterDelegate(),
        )
    }

    override fun setupUi() {
        super.setupUi()
        with(binding) {
            rvCharacters.layoutManager = LinearLayoutManager(requireContext())
            rvCharacters.adapter = adapter
        }
    }

    override fun setupObservers() {
        super.setupObservers()
        subscribe(viewModel.charactersLiveData) {
            adapter.items = it
        }
    }
}
