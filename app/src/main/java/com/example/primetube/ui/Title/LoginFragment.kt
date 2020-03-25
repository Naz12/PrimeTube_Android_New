package com.example.primetube.ui.Title

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.primetube.MainActivity

import com.example.primetube.R
import com.example.primetube.databinding.LoginFragmentBinding
import com.example.primetube.model.Login
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel
    private lateinit var loginBinding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginBinding = LoginFragmentBinding.inflate(inflater, container, false)
        return loginBinding.root
//        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        loginBinding.btnSignin.setOnClickListener { view ->
            signin()
        }

        viewModel.error.observe(viewLifecycleOwner, Observer { appError ->
            Toast.makeText(context, appError.errorMessage, Toast.LENGTH_LONG).show()
        })

        tvForgetpassword.setOnClickListener {

            findNavController().navigate(R.id.forgetFragment, null)
        }
        btnSignup.setOnClickListener {
            var intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
//            findNavController().navigate(R.id.signinFragment, null)
        }

    }

    fun signin() {
        var username = loginBinding.etUsername.text.toString()
        var password = loginBinding.etPassword.text.toString()
        viewModel.signinwithEmail(Login(username, password))
            .observe(viewLifecycleOwner, Observer { isAuthenticated ->
                if (isAuthenticated) {
                    var intent = Intent(context, MainActivity::class.java)
                    startActivity(intent)
                }
            })

//

    }

}
