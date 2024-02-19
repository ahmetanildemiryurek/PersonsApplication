package com.marazanil.personsapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.marazanil.personsapplication.R
import com.marazanil.personsapplication.databinding.FragmentMainBinding

class MainFragment : Fragment(),SearchView.OnQueryTextListener{

    private lateinit var binding : FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.toolbarMain.title = "Kişiler"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarMain)


        binding.addPersonFabBtn.setOnClickListener {
            findNavController().navigate(R.id.toPersonRegistrationFragment)
            Toast.makeText(context,"Kişi Ekleme Sayfasına Yönlendirildi",Toast.LENGTH_SHORT).show()
        }

        requireActivity().addMenuProvider(object :MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu , menu)

                //kullanıcının arama metninde yapacağı herhangi bir değişiklik(silme-yazma) veya
                //arama gibi işlemler için gerekli olan onMenuItemSelected ve onQueryTextSubmit
                //kodlarını onCreate içinde tanımlamış olduk.
                val item = menu.findItem(R.id.action_find)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@MainFragment)

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)


        return binding.root


    }
    //aramak için butona tıkladığımızda ise bu çalışır
    override fun onQueryTextSubmit(query: String): Boolean {
        search(query)
        return true
    }

    //aramak için yazmış veya silmiş olduğumuz her kelime için bu çalışır
    override fun onQueryTextChange(newText: String): Boolean {
        search(newText)
        return true
    }

    fun search(searchingWords : String){
    Log.d("Aranan Kelime" , searchingWords)
    }
}
