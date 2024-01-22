package com.qadeer.mvvmproject.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.qadeer.mvvmproject.ui.model.ActivityViewModel
import com.qadeer.mvvmproject.ui.theme.MVVMProjectTheme
import com.qadeer.mvvmproject.utils.ResourceStatus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var model = ViewModelProvider(this)[ActivityViewModel::class.java]


        setContent {
            MVVMProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }


        model.getUsers()

        model.userModel.observe(this) {
            when (it.status) {
                ResourceStatus.Status.LOADING -> {

                }

                ResourceStatus.Status.ERROR -> {

                }

                ResourceStatus.Status.VERIFY -> {

                }

                ResourceStatus.Status.SUCCESS -> {

                }


            }


        }

    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MVVMProjectTheme {
        Greeting("Android")
    }
}