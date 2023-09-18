package com.example.giphy.section.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.giphy.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ListFragment: Fragment() {
    private val vm by viewModels<ListVM>()

    private lateinit var vv: FragmentListBinding
    private val v
        get() = vv

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        vv = FragmentListBinding.inflate(inflater, container, false)
        return v.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = GifsAdapter()
        v.list.adapter = adapter

        lifecycleScope.launch {
            vm.getGifs().collectLatest {
                adapter.submitData(it)
            }
        }

        v.buttonSearch.setOnClickListener {
            val searchText = v.editQuery.text.toString()
            vm.setSearch(searchText)

            adapter.refresh()
        }


    }

}