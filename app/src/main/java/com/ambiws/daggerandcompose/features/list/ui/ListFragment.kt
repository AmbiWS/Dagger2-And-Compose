package com.ambiws.daggerandcompose.features.list.ui

import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.ambiws.daggerandcompose.base.BaseFragment
import com.ambiws.daggerandcompose.base.UiState
import com.ambiws.daggerandcompose.base.list.DefaultListDiffer
import com.ambiws.daggerandcompose.databinding.FragmentListBinding
import com.ambiws.daggerandcompose.features.list.ui.list.CharacterBaseItemModel
import com.ambiws.daggerandcompose.features.list.ui.list.CharactersAdapterDelegate
import com.ambiws.daggerandcompose.utils.extensions.subscribe
import com.google.android.material.snackbar.Snackbar
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class ListFragment : BaseFragment<ListViewModel, FragmentListBinding>(
    FragmentListBinding::inflate
) {

    private val adapter by lazy {
        AsyncListDifferDelegationAdapter(
            DefaultListDiffer<CharacterBaseItemModel>(),
            CharactersAdapterDelegate.charactersDefaultAdapterDelegate { itemModel ->
                viewModel.navigateToDetails(itemModel)
            },
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
        subscribe(viewModel.stateLiveEvent) {
            when (it) {
                is UiState.Error -> {
                    binding.rvCharacters.isVisible = false
                    binding.cpiLoader.isVisible = true
                    Snackbar
                        .make(
                            requireContext(),
                            binding.root,
                            "${it.error} is occurred",
                            Snackbar.LENGTH_SHORT
                        )
                        .show()
                }
                UiState.Loading -> {
                    binding.rvCharacters.isVisible = false
                    binding.cpiLoader.isVisible = true
                }
                UiState.Success -> {
                    binding.rvCharacters.isVisible = true
                    binding.cpiLoader.isVisible = false
                }
            }
        }
    }
}
