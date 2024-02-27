package com.marazanil.personsapplication.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

//Kişiler nesnesini sayfalar arası aktarım yapacağız bu nedenle
// dataları platform bağımsız hale getirmek için Serializable kullandık.
@Entity(tableName = "persons")
data class Persons( @PrimaryKey(autoGenerate = true)
                    @ColumnInfo(name = "personId") @NotNull var personId : Int,
                    @ColumnInfo(name = "personName") @NotNull var personName: String,
                    @ColumnInfo(name = "personPhoneNumber") @NotNull var personPhoneNumber: String) : Serializable
