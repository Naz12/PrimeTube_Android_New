package com.example.primetube.ui.Title

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.primetube.MainActivity

import com.example.primetube.R
import com.example.primetube.databinding.SignupFragmentBinding
import kotlinx.android.synthetic.main.signup_fragment.*

class SignupFragment : Fragment() {

    companion object {
        fun newInstance() = SignupFragment()
    }

    private lateinit var binding : SignupFragmentBinding
    private lateinit var viewModel: SignupViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var binding = SignupFragmentBinding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SignupViewModel::class.java)

        binding.btnSingup.setOnClickListener{
            registerUser()
        }
    }



    fun registerUser(){
        var intent = Intent(context , MainActivity::class.java)
        startActivity(intent)
    }

}
