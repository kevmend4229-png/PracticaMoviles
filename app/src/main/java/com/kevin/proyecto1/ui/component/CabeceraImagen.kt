package com.kevin.proyecto1.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kevin.proyecto1.R

data class CabeceraImagenData(
    val imagen: Int,
    val onIconoIzq: () -> Unit,
    val onIconoDer: () -> Unit
)

@Composable
fun CabeceraImagen(data: CabeceraImagenData, modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .fillMaxWidth() //Rellena todo el ancho de la pantalla
            .height(200.dp)
    ) {
        Image(
            painter = painterResource(data.imagen),
            contentDescription = stringResource(R.string.imagen_de_cabecera),
            contentScale = ContentScale.Crop
        )

        IconButton(
            onClick = data.onIconoIzq,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(8.dp)

        ) {
            Icon(
                painterResource(R.drawable.ic_favorite),
                contentDescription = stringResource(R.string.favorito),
                tint = MaterialTheme.colorScheme.primary
            )

        }

        IconButton(
            onClick = data.onIconoDer,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)

        ) {
            Icon(
                painterResource(R.drawable.ic_share),
                contentDescription = stringResource(R.string.favorito),
                tint = MaterialTheme.colorScheme.primary
            )

        }
    }
}

@Preview
@Composable
fun CabeceraImagenPreview() {
    CabeceraImagen(
        data = CabeceraImagenData(
            imagen = R.drawable.cabecera,
            onIconoIzq = {},
            onIconoDer = {}
        ),
        modifier = Modifier
    )
}