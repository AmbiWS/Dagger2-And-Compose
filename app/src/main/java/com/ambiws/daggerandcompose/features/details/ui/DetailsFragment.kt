package com.ambiws.daggerandcompose.features.details.ui

import com.ambiws.daggerandcompose.R
import com.ambiws.daggerandcompose.base.BaseFragment
import com.ambiws.daggerandcompose.databinding.FragmentDetailsBinding
import com.squareup.picasso.Picasso

class DetailsFragment : BaseFragment<DetailsViewModel, FragmentDetailsBinding>(
    FragmentDetailsBinding::inflate
) {

    private val args: DetailsFragmentArgs by lazy {
        DetailsFragmentArgs.fromBundle(requireArguments())
    }

    override fun setupUi() {
        super.setupUi()
        args.itemModel?.let {
            val model = it
            with(binding) {
                Picasso.get().load(model.image).into(ivPicture)
                tvName.text = model.name
                tvNickname.text = getString(R.string.parentheses, model.nickname)
                tvHouse.text = getString(R.string.house, model.house)
                tvBirthday.text = getString(R.string.birthday, model.birthdate)
                tvChildren.text = model.children
            }
        } ?: {
            binding.tvName.text = getString(R.string.dataError)
        }
    }

    override fun setupListeners() {
        super.setupListeners()
        binding.customToolbar.ivLeftAction.setOnClickListener {
            viewModel.navigateBack()
        }
    }
}
