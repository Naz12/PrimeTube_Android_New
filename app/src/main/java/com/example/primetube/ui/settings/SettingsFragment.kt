package com.example.primetube.ui.settings

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import com.example.primetube.R
import kotlinx.android.synthetic.main.settings_fragment.*

class SettingsFragment : Fragment() {


    companion object {
        fun newInstance() = SettingsFragment()
    }

     lateinit var viewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.settings_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(SettingsViewModel::class.java)
        val textsetting: TextView = root.findViewById(R.id.text_settings)
        textsetting.text= viewModel.text.value
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SettingsViewModel::class.java)
        // TODO: Use the ViewModel

        button.setOnClickListener{
            text_settings.text = editText.text
           viewModel.text.value = editText.text.toString()
        }
    }

}
