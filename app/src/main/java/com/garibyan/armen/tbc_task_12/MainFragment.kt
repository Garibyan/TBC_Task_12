package com.garibyan.armen.tbc_task_12

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.garibyan.armen.tbc_task_12.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private val animalAdapter by lazy { AnimalsAdapter() }

    private var setData = mutableListOf(
        Animal(R.drawable.cat, "just a cat", "The cat is a domestic species of small carnivorous mammal. It is the only domesticated species in the family Felidae and is often referred to as the domestic cat to distinguish it from the wild members of the family. "),
        Animal(R.drawable.dog, "dog", "The dog or domestic dog is a domesticated descendant of the wolf, characterized by an upturning tail. The dog is derived from an ancient, extinct wolf, and the modern wolf is the dog's nearest living relative."),
        Animal(R.drawable.german_shepherd, "German Shepherd", "The German Shepherd or Alsatian is a German breed of working dog of medium to large size. The breed was developed by Max von Stephanitz using various traditional German herding dogs from 1899. It was originally bred as a herding dog, for herding sheep"),
        Animal(R.drawable.labrador, "Labrador Retriever", "The Labrador Retriever or Labrador is a British breed of retriever gun dog. It was developed in the United Kingdom from fishing dogs imported from the colony of Newfoundland, and was named after the Labrador region of that colony."),
        Animal(R.drawable.husky, "Siberian Husky", "The Siberian Husky is a medium-sized working sled dog breed. The breed belongs to the Spitz genetic family. It is recognizable by its thickly furred double coat, erect triangular ears, and distinctive markings, and is smaller than the similar-looking Alaskan Malamute."),
        Animal(R.drawable.british_shorthair, "British Shorthair", "The British Shorthair is the pedigreed version of the traditional British domestic cat, with a distinctively stocky body, dense coat, and broad face. The most familiar colour variant is the \"British Blue\", with a solid grey-blue coat, orange eyes, and a medium-sized tail."),
        Animal(R.drawable.maine_coon, "Maine Coon", "The Maine Coon is a large domesticated cat breed. It is one of the oldest natural breeds in North America. The breed originated in the U.S. state of Maine, where it is the official state cat")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        animalAdapter.onItemClickListener = {

            val action = MainFragmentDirections.actionMainFragmentToItemFragment(it)

            findNavController().navigate(action)
        }

        binding!!.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val list = mutableListOf<Animal>()

                if (!newText.isNullOrEmpty()) {
                    list.addAll(setData.filter {
                        it.title.lowercase().contains(newText.lowercase())
                    })
                } else {
                    list.addAll(setData)
                }
                animalAdapter.submitList(list)
                return true
            }
        })
    }

    private fun init() {
        binding!!.rv.apply {
            layoutManager =
                GridLayoutManager(requireContext(), 3, GridLayoutManager.VERTICAL, false)
            adapter = animalAdapter
            animalAdapter.submitList(setData)
        }
    }
}

