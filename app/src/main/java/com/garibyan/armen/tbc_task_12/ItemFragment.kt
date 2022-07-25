package com.garibyan.armen.tbc_task_12

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.garibyan.armen.tbc_task_12.databinding.FragmentItemBinding

class ItemFragment : Fragment() {
    private var binding:FragmentItemBinding? = null
    private val args by navArgs<ItemFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentItemBinding.inflate(inflater, container, false)

        binding?.apply {
            itemImage.setBackgroundResource(args.animal.imageSrc)
            tvitemTitle.text = args.animal.title
            tvItemDesctiption.text = args.animal.description
        }

        return binding!!.root
    }
}