package com.example.challengekonfio.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenStarted
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengekonfio.databinding.FragmentDogsBinding
import com.example.challengekonfio.domain.model.Dog
import com.example.challengekonfio.presentation.adapter.DogsAdapter
import com.example.challengekonfio.presentation.viewModel.DogViewModel
import com.example.challengekonfio.utils.DataState
import com.example.challengekonfio.utils.LoadingDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DogsFragment : Fragment() {

    private var uiJob: Job? = null
    private val dogModel : DogViewModel by viewModels()
    private var binding : FragmentDogsBinding? = null
    private lateinit var dogAdapter : DogsAdapter

    private var loadingDialog: LoadingDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dogModel.getListDogs()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDogsBinding.inflate(inflater, container, false)
        return binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initArgumentsAndUI()
    }

    override fun onStart() {
        super.onStart()
        getDogs()
    }

    private fun initArgumentsAndUI(){
        binding?.ivBack?.setOnClickListener {
            requireActivity().finish()
        }
    }

    private fun getDogs(){
        uiJob = lifecycleScope.launch{
            whenStarted {
                dogModel.getResponse.collect {
                    when(it){
                        is DataState.Loading -> {
                            loadingDialog?.startLoadingDialog()
                        }
                        is DataState.Success ->{
                            loadingDialog?.dismisDialog()
                            fillRecyclerView(it.data)
                        }
                        is DataState.Error -> {
                            loadingDialog?.startLoadingDialog()
                        }
                    }
                }
            }
        }
    }

    private fun fillRecyclerView(listDogResponses: List<Dog>){
        dogAdapter = DogsAdapter(listDogResponses,requireContext())
        binding?.rvDogs?.apply {
            adapter = dogAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }

    override fun onStop() {
        super.onStop()
        uiJob?.cancelChildren()
    }

    companion object {
        val TAG = DogsFragment::class.java.canonicalName!!
    }

}