package com.example.prak4

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormDataDiri(modifier: Modifier
) {
    var textNama by remember { mutableStateOf(value = "") }
    var textAlamat by remember { mutableStateOf(value = "") }
    var textJK by remember { mutableStateOf(value = "") }
    var textStatus by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf(value = "") }
    var alamat by remember { mutableStateOf(value = "") }
    var jenis by remember { mutableStateOf(value = "") }
    var status by remember { mutableStateOf("") }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")
    val status1: List<String> = listOf("Janda", "Lajang", "Duda")

    Box(modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFB39DDB))
                    .padding(vertical = 20.dp)
            ){
                Text(
                    text = "Formulir Pendaftaran",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            ElevatedCard(modifier = Modifier
                .fillMaxWidth(1f)
                .padding(all = 10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 50.dp)
            ) {
                Text(text = "NAMA LENGKAP",modifier = Modifier.padding(all = 10.dp), fontWeight = FontWeight.Bold)
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    singleLine = true,
                    shape = MaterialTheme.shapes.large,
                    label = { Text(text = "Isian Nama Lengkap")},
                    modifier = Modifier.padding(10.dp)
                        .fillMaxWidth(1f),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.DarkGray,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedBorderColor = Color.Blue,
                        unfocusedBorderColor = Color.Gray,
                    )
                )

                Text(text = "JENIS KELAMIN",modifier = Modifier.padding(all = 10.dp), fontWeight = FontWeight.Bold)
                Column() {
                    gender.forEach { item ->
                        Column(
                            modifier = Modifier
                                .selectable(
                                    selected = textJK == item,
                                    onClick = { textJK == item }
                                )
                        ){
                            Row() {
                                RadioButton(
                                    selected = textJK == item,
                                    onClick = { textJK = item }
                                )
                                Text(
                                    text = item,
                                    modifier = Modifier.padding(top = 10.dp)
                                )
                            }
                        }
                    }
                }
                Text(text = "STATUS PERKAWINAN",modifier = Modifier.padding(all = 10.dp), fontWeight = FontWeight.Bold)

        Row {
            gender.forEach { item ->
                Row(
                    modifier = Modifier.selectable(
                    selected = textJK == item,
                    onClick = { textJK = item }
                ), verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = textJK == item,
                        onClick = {
                            textJK = item
                        })
                    Text(text = item)
                }
            }
        }
        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            modifier = Modifier.width(width = 250.dp),
            label = { Text(text = "Alamat Lengkap") },
            onValueChange = {
                textAlamat = it
            }
        )

        HorizontalDivider(
            modifier = Modifier.padding(
                bottom = dimensionResource(id = R.dimen.padding_medium),
                top = dimensionResource(id = R.dimen.padding_medium)
            ),
            thickness = dimensionResource(id = R.dimen.divider_tipis),
            color = Color.DarkGray
        )
        Button(
            modifier = Modifier.fillMaxWidth(fraction = 1f),
            enabled = textAlamat.isNotEmpty(),
            onClick = {
                nama = textNama
                jenis = textJK
                alamat = textAlamat
            }
        ) {
            Text(text = stringResource(id = R.string.submit))
        }

        HorizontalDivider(
            modifier = Modifier.padding(
                bottom = dimensionResource(id = R.dimen.padding_medium),
                top = dimensionResource(id = R.dimen.padding_medium)
            ),
            thickness = dimensionResource(id = R.dimen.divider_tipis),
            color = Color.DarkGray
        )

        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black),
            modifier = Modifier
                .height(100.dp)
                .width(300.dp)
        ) {
            Column(modifier = Modifier.padding(horizontal = 5.dp, vertical = 15.dp),) {
                Text(text = "Nama   : " + nama, color = Color.White)
                Text(text = "Gender : " + jenis, color = Color.White)
                Text(text = "Alamat : " + alamat, color = Color.White)

            }
        }
    }
}

