package com.example.nycschoolsnomerge_compose.view

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.nycschoolsnomerge_compose.MainThemeApp
import com.example.nycschoolsnomerge_compose.model.UIState
import com.example.nycschoolsnomerge_compose.viewmodel.SchoolViewModel
import com.example.repository.model.SchoolListUseCaseDTO

private const val TAG = "SchoolsHome"

@Composable
fun SchoolsHome(schoolViewModel: SchoolViewModel) {
    val uiState = schoolViewModel.uiData.collectAsState().value
//    var isVisible by remember {
//        mutableStateOf(false)
//    }
    var isVisibleConfigChanges by rememberSaveable {
        mutableStateOf(true)
    }
    Log.d(TAG, "SchoolsHome: uiState: $uiState")

    when (uiState) {
        is UIState.Success -> {
            SchoolsHomeContent(uiState.data)
        }

        is UIState.Failure -> {

            SchoolHomeFailureContent(uiState.error, isVisibleConfigChanges) {isDismiss ->
                isVisibleConfigChanges = isDismiss
            }
        }

        else -> {
            Log.d(TAG, "SchoolsHome: else")
        }
    }
}

@Composable
fun SchoolHomeFailureContent(
    error: String,
    isVisible: Boolean,
    dismiss: (Boolean) -> Unit) {

    AlertDialog(
        onDismissRequest = {
            dismiss(true)
        },
        confirmButton = {
            Button(onClick = { dismiss(true) }) {
                Text(text = "Accept!")
            }
        }
    )
}

@Composable
fun SchoolsHomeContent(data: List<SchoolListUseCaseDTO>) {
    LazyColumn {
        items(items = data) {
            SchoolItem(it)
        }
    }
}

@Composable
fun SchoolItem(schoolItem: SchoolListUseCaseDTO) {
    Card {
        Column {
            Text(
                text = "",
                style = TextStyle(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    lineHeight = 24.sp,
                    letterSpacing = 0.5.sp)
            )
            Row {
                Text(
                    text = schoolItem.city,
                    style = TextStyle(
                        fontWeight = FontWeight.Light,
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.5.sp
                    )
                )
                Text(
                    text = schoolItem.zip,
                    style = TextStyle(
                        fontWeight = FontWeight.Light,
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.5.sp
                    ))
            }
        }
    }
}


@Preview
@Composable
fun PrevSchoolItem() {
    val prevData = SchoolListUseCaseDTO(
        "Some school name",
        "some zip code",
        "some city"
    )
    MainThemeApp {
        SchoolItem(schoolItem = prevData)
    }
}

