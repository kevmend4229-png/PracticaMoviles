package com.kevin.proyecto1.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class TarjetaItemData(
    val titulo: String,
    val descripcion: String,
    val onBorrar: () -> Unit,
    val onVerMas: () -> Unit
)

@Composable
fun TarjetaItem(data: TarjetaItemData, modifier: Modifier = Modifier){
    Column (
        modifier = modifier.fillMaxWidth()
            .padding(10.dp)) {
        Text(text = data.titulo, color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(5.dp))
        Text(text = data.descripcion, color = Color.Black)
        Spacer(Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = data.onBorrar) {
                Text(text = "Borrar")
            }
            Button(onClick = data.onVerMas) {
                Text(text = "VerMas")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TarjetaItemPreview(){
    TarjetaItem(
        data = TarjetaItemData(
            titulo = "Titulo",
            descripcion = "Descripcion",
            onBorrar = {},
            onVerMas = {}
        ),

        modifier = Modifier
    )
}