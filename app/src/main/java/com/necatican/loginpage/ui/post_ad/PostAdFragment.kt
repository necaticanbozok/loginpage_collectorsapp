package com.necatican.loginpage.ui.post_ad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.necatican.loginpage.R
import com.necatican.loginpage.base.BaseFragment
import com.necatican.loginpage.databinding.FragmentLoginBinding


class PostAdFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_post_ad,container,false)
    }
}