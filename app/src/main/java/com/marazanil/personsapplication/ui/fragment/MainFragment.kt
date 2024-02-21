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
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.marazanil.personsapplication.R
import com.marazanil.personsapplication.data.entity.Persons
import com.marazanil.personsapplication.databinding.FragmentMainBinding
import com.marazanil.personsapplication.ui.adapter.PersonAdapter

class MainFragment : Fragment(),SearchView.OnQueryTextListener{

    private lateinit var binding : FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main,container, false)
        binding.mainFragment = this
        binding.toolbarMainTitle= "Kişiler"

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarMain)

        val personList = ArrayList<Persons>()
        val p1 = Persons(1,"Anil","1234")
        val p2 = Persons(2,"Anil2","12345")
        val p3 = Persons(3,"Anil3","123456")
        val p4 = Persons(4,"Anil4","1234567")
        val p5 = Persons(5,"Anil5","1234568")
            personList.add(p1)
            personList.add(p2)
            personList.add(p3)
            personList.add(p4)
            personList.add(p5)

        val personAdapter = PersonAdapter(requireContext(),personList)
        binding.personAdapter = personAdapter


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
    fun clickAddPersonFabBtn(it:View){
        Navigation.findNavController(it).navigate(R.id.toPersonRegistrationFragment)
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

    //bu sayfaya geri döndüğümüzü anlamamızı sağlayacak olan lifecycle fun
    override fun onResume() {
        super.onResume()
        Log.d("Ana Sayfaya dönüldü" , "Döndük")

    }
}
