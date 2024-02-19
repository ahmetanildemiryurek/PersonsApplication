package com.marazanil.personsapplication.data.entity

import java.io.Serializable

//Kişiler nesnesini sayfalar arası aktarım yapacağız bu nedenle
// dataları platform bağımsız hale getirmek için Serializable kullandık.
data class Persons(var personId : Long,
                    var personName: String,
                    var personNumber: String) : Serializable
