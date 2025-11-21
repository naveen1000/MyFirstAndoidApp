package com.example.myfirstapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myfirstapplication.ui.theme.MyFirstApplicationTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    PositionsScreen(viewModel)
                }
            }
        }
        viewModel.fetchPositions("d6k2z8ev4jj41bm1", "IP6iI5QTxjXf35e9RgJhpZMlnxPds6TK")
    }
}

@Composable
fun PositionsScreen(viewModel: MainViewModel) {
    val positions by viewModel.positions.collectAsState()

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(positions) { position ->
            PositionItem(position)
        }
    }
}

@Composable
fun PositionItem(position: Position) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(text = "Symbol: ${position.tradingsymbol}")
        Text(text = "Quantity: ${position.quantity}")
        Text(text = "P&L: ${position.pnl}")
    }
}