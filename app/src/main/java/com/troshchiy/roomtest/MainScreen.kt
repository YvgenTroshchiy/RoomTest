package com.troshchiy.roomtest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.troshchiy.roomtest.ui.theme.RoomTestTheme

// TODO: don't pass VM hoisting callbacks
@Composable fun MainScreen(viewModel: MainViewModel) {
    Column {
        Row() {
            Button(onClick = { viewModel.clearDb() }) {
                Text(text = "Clear")
            }
            Button(onClick = { viewModel.fillDb() }) {
                Text(text = "Fill")
            }
            Button(onClick = { viewModel.logDataBase() }) {
                Text(text = "Log")
            }
            Button(onClick = { }) {
                Text(text = "Add")
            }
        }
        LazyColumn(content = { })
    }
}

@Preview(showBackground = true) @Composable fun DefaultPreview() {
    RoomTestTheme {
//        MainScreen(MainViewModel(null))
    }
}
