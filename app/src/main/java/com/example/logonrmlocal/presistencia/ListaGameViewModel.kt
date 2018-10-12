package com.example.logonrmlocal.presistencia

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.logonrmlocal.presistencia.dao.BancoDeDados
import com.example.logonrmlocal.presistencia.model.Game

class ListaGameViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var games: LiveData<List<Game>>

    private val bd: BancoDeDados =
            BancoDeDados.getDataBase(application.applicationContext)!!

    init {
        carregarDados()
    }

    private fun carregarDados() {
        games = bd.GameDAO().lerGames()
    }
}
