package com.marazanil.personsapplication.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

//override ederek hangi geçiş hangi parametreye uygunsa ona göre sağlanacak.
fun Navigation.makeTransition(it:View , id:Int){
    findNavController(it).navigate(id)
}
fun Navigation.makeTransition(it:View , id:NavDirections){
    findNavController(it).navigate(id)
}