package com.kevin.proyecto1.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


//Estado de la pantalla
data class PantallaPrincipalUIState(
    val datosTarjeta: List<DatosTarjeta> = listOf()
)



class PantallaPrincipalVM: ViewModel() {

    private val _uiState = MutableStateFlow(PantallaPrincipalUIState())
    val uiState = _uiState.asStateFlow()

    fun load(){
        //Cargo los datos
        _uiState.value = _uiState.value.copy(datosTarjeta = listOf(
            DatosTarjeta("Titulo1", "Descripcion1"),
            DatosTarjeta("Titulo2", "Descripcion2"),
            DatosTarjeta("Titulo3", "Descripcion3")

        ))
    }

    fun onBorrar(item: DatosTarjeta) {

        Log.d("PantallaPrincipalVM", "accion borrar ${item.titulo}" )
    }

    fun onVerMas(item: DatosTarjeta) {

        Log.d("PantallaPrincipalVM", "accion verMas ${item.titulo}" )
    }

}



data class DatosTarjeta(
    val titulo: String,
    val descripcion: String
)
