package com.example.myapp.ui.skill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.R
import com.example.myapp.databinding.FragmentSkillBinding
import com.example.myapp.ui.skill.SkillFragmentDirections.ActionNavigationSkillToNavigationSkillDetail
import java.util.Locale


class SkillFragment : Fragment() {
    private var _binding: FragmentSkillBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<SkillViewModel>()
    private lateinit var adapter: SkillAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSkillBinding.inflate(inflater, container, false)
        val root: View = binding.root

        recyclerView = root.findViewById(R.id.recyclerView)
        searchView = root.findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext()) // Menggunakan requireContext() untuk mendapatkan konteks fragment
        addDataToList()
        adapter = SkillAdapter(mList){
            navigateToDetail(it)
        }
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })

        return root
    }

    private fun filterList(query: String?) {
        if (query != null) {
            val filteredList = ArrayList<SkillViewModel>()
            for (i in mList) {
                if (i.title.lowercase(Locale.ROOT).contains(query.lowercase(Locale.ROOT))) { // Membandingkan dengan query dalam huruf kecil
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(requireContext(), "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList() {
        mList.add(SkillViewModel("Java", R.drawable.java))
        mList.add(SkillViewModel("Kotlin", R.drawable.kotlin))
        mList.add(SkillViewModel("C++", R.drawable.cplusplus))
        mList.add(SkillViewModel("Python", R.drawable.python))
        mList.add(SkillViewModel("HTML", R.drawable.html))
        mList.add(SkillViewModel("Swift", R.drawable.swift))
        mList.add(SkillViewModel("C#", R.drawable.csharp))
        mList.add(SkillViewModel("JavaScript", R.drawable.javascript))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun navigateToDetail(extraName: String) {
        val action = SkillFragmentDirections.actionNavigationSkillToNavigationSkillDetail(extraName)
        findNavController().navigate(action)
    }

}
