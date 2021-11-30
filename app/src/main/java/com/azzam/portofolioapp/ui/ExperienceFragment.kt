package com.azzam.portofolioapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.azzam.portofolioapp.R
import com.azzam.portofolioapp.adapter.RVExperienceAdapter
import com.azzam.portofolioapp.data.Portofolio
import com.azzam.portofolioapp.data.PortofolioData
import com.azzam.portofolioapp.data.PortofolioData.listDataExperience
import com.azzam.portofolioapp.databinding.FragmentExperienceBinding


class ExperienceFragment : Fragment() {

    private var _binding: FragmentExperienceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExperienceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapterExperience = RVExperienceAdapter()

        adapterExperience.onItemCliked = { experience ->
            findNavController().navigate(
                ExperienceFragmentDirections.actionExperienceFragmentToExperienceDetailFragment(
                    experience
                )
            )
        }

        adapterExperience.setData(PortofolioData.listDataExperience)

        with(binding.rvExperience) {
            layoutManager = StaggeredGridLayoutManager( 2, LinearLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = adapterExperience
        }

    }

}