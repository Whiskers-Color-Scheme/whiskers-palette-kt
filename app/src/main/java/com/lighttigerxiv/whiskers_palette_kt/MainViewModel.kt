package com.lighttigerxiv.whiskers_palette_kt

import android.app.Application
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val context = application

    data class UiState(
        val palette: Palette,
        val tab: Int
    )

    private val _uiState = MutableStateFlow(UiState(palette = getPantherPalette(), tab = 0))
    val uiState = _uiState.asStateFlow()

    fun switchToPanther() {
        viewModelScope.launch(Dispatchers.Main) {
            _uiState.update { it.copy(palette = getPantherPalette(), tab = 0) }
        }
    }

    fun switchToTiger() {
        viewModelScope.launch(Dispatchers.Main) {
            _uiState.update { it.copy(palette = getTigerPalette(), tab = 1) }
        }
    }

    fun copyText(text: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipboard.setPrimaryClip(ClipData.newPlainText(text, text))
    }
}