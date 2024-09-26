package com.example.appdatabaseinsert.viewModel

import com.example.appdatabaseinsert.roomDB.Pessoa
import com.example.appdatabaseinsert.roomDB.PessoaDataBase

class Repository(private val db: PessoaDataBase) {
    suspend fun upsertPessoa(pessoa: Pessoa){
        db.PessoaDao().upsertPessoa(pessoa)
    }

    suspend fun deletePessoa(pessoa: Pessoa){
        db.PessoaDao().upsertPessoa(pessoa)
    }

    fun getAllPessoas() = db.PessoaDao().getAllPessoa()
}