package com.troshchiy.roomtest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.troshchiy.roomtest.db.User
import com.troshchiy.roomtest.ui.theme.RoomTestTheme

// TODO: don't pass VM hoisting callbacks
@Composable fun MainScreen(users: State<List<User>>, viewModel: MainViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {
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
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)) {
            items(users.value.size) {
                val user = users.value[it]
                Text(
                    modifier = Modifier.height(36.dp),
                    text = "${user.lastName} ${user.firstName}"
                )
            }
        }
    }
}

@Preview(showBackground = true) @Composable fun DefaultPreview() {
    RoomTestTheme {
//        MainScreen(MainViewModel(null))
    }
}
