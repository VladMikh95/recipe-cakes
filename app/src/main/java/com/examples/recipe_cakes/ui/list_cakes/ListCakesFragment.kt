package com.examples.recipe_cakes.ui.list_cakes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.examples.recipe_cakes.R
import com.examples.recipe_cakes.databinding.FragmentListCakesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListCakesFragment : Fragment() {

    private val viewModel by viewModels<ListCakesViewModel>()
    private lateinit var binding: FragmentListCakesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentListCakesBinding.inflate(inflater, container, false)


        /*binding.buttonUp.setOnClickListener() {
            findNavController().navigate(CategoryFragmentDirections.actionCategoryFragmentToStartFragment())
        }*/
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val recyclerView = binding.recyclerViewDesserts
        val adapter = DessertAdapter()
        recyclerView.adapter = adapter

        viewModel.getListDesserts()

        viewModel.state.observe(viewLifecycleOwner) { state ->

            binding.recyclerViewDesserts.visibility = if (state is ListCakesState.Loaded) View.VISIBLE else View.GONE
            //binding.textViewError.visibility = if (state is WeatherCityState.Error) View.VISIBLE else View.GONE
            //binding.imageViewInternetError.visibility = if (state is WeatherCityState.Error) View.VISIBLE else View.GONE

            /*if (state is WeatherCityState.Error) {

                binding.imageViewInternetError.visibility = if (state.error == ErrorWeather.CONNECTION_ERROR) View.VISIBLE else View.GONE
                binding.textViewError.text = when(state.error) {
                    ErrorWeather.CONNECTION_ERROR -> getString(R.string.text_error_connection_error)
                    ErrorWeather.CITY_UNKNOWN -> getString(R.string.text_error_city_unknown)
                    ErrorWeather.ERROR_UNKNOWN -> getString(R.string.text_error_error_unknown)
                }
            }*/


            if (state is ListCakesState.Loaded) {
                adapter.submitList(state.cake.desserts)
            }
        }
    }

}