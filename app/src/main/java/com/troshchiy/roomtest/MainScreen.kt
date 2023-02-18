package com.troshchiy.roomtest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.troshchiy.roomtest.db.DbManager
import com.troshchiy.roomtest.ui.theme.RoomTestTheme

@Composable fun MainScreen() {
    Column {
        Row() {
            Button(onClick = { DbManager.clearDb() }) {
                Text(text = "Clear")
            }
            Button(onClick = { DbManager.fillDb() }) {
                Text(text = "Fill")
            }
            Button(onClick = { DbManager.logDataBase() }) {
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
        MainScreen()
    }
}
