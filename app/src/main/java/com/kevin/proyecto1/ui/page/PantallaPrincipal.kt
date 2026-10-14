package com.kevin.proyecto1.ui.page

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kevin.proyecto1.R
import com.kevin.proyecto1.ui.component.CabeceraImagen
import com.kevin.proyecto1.ui.component.CabeceraImagenData
import com.kevin.proyecto1.ui.component.TarjetaItem
import com.kevin.proyecto1.ui.component.TarjetaItemData
import com.kevin.proyecto1.viewModel.PantallaPrincipalVM

private const val TAG = "PantallaPrincipal"

@Composable
fun PantallaPrincipal(viewModel: PantallaPrincipalVM = viewModel(), modifier: Modifier) {

    Column(modifier = modifier) {
        CabeceraImagen(
            CabeceraImagenData(
                imagen = R.drawable.cabecera,
                onIconoDer = {
                    Log.d(
                        TAG,
                        "Se ha realizado un click en el icono derecho (Compartir)"
                    )
                },
                onIconoIzq = {
                    Log.d(
                        TAG,
                        "Se ha realizado un click en el icono izquierdo (Favorito)"
                    )
                }),
        )

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(viewModel.uiState.value.datosTarjeta) { item ->
                TarjetaItem(
                    data = TarjetaItemData(
                    titulo = item.titulo,
                    descripcion = item.descripcion,
                    onBorrar = {
                        viewModel.onBorrar(item)
                    },
                    onVerMas = {
                        viewModel.onVerMas(item)
                    }
                ))
            }
        }

    }

}