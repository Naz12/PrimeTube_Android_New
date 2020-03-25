package com.example.primetube.ui.Library

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer

import com.example.primetube.R

class Library : Fragment() {

    companion object {
        fun newInstance() = Library()
    }

    private lateinit var viewModel: LibraryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(this).get(LibraryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_library, container, false)
        val textView: TextView = root.findViewById(R.id.text_library)
        viewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LibraryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
