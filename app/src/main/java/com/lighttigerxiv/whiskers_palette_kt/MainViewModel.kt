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

class MainViewModel(private val application: Application) : AndroidViewModel(application) {

    companion object {
        data class State(
            val palette: Palette = getTigerPalette()
        )

        sealed class Action {
            data object OnSetTigerPalette : Action()
            data object OnSetPantherPalette : Action()
            data class OnCopy(val text: String) : Action()
        }
    }

    private val _state = MutableStateFlow(State())
    val state = _state.asStateFlow()

    fun onAction(action: Action) {
        when (action) {
            is Action.OnCopy -> {
                copyText(action.text)
            }

            Action.OnSetPantherPalette -> {
                setPantherPalette()
            }

            Action.OnSetTigerPalette -> {
                setTigerPalette()
            }
        }
    }

    private fun copyText(text: String) {
        val clipboard = application.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipboard.setPrimaryClip(ClipData.newPlainText(text, text))
    }

    private fun setPantherPalette() {
        _state.update {
            it.copy(palette = getPantherPalette())
        }
    }

    private fun setTigerPalette() {
        _state.update {
            it.copy(palette = getTigerPalette())
        }
    }
}