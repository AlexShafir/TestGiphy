package com.example.giphy.section.show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.giphy.databinding.FragmentShowBinding

class ShowFragment: Fragment() {

    private lateinit var vv: FragmentShowBinding
    private val v
        get() = vv

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        vv = FragmentShowBinding.inflate(inflater, container, false)
        return v.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val url = requireArguments().getString("url")
        Glide.with(requireContext()).asGif().load(url).into(v.image)
    }
}