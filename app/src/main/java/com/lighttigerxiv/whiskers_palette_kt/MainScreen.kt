package com.lighttigerxiv.whiskers_palette_kt

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lighttigerxiv.layout_scaffold.LayoutScaffold
import com.lighttigerxiv.whiskers_palette_kt.MainViewModel.Companion.Action
import com.lighttigerxiv.whiskers_palette_kt.Color as WhColor

@Composable
fun MainScreen(vm: MainViewModel) {
    val state = vm.state.collectAsState().value
    val palette = state.palette

    LayoutScaffold(
        navigationBar = { _, inLandscape ->
            if (inLandscape) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f, fill = true)
                            .clip(CircleShape)
                            .clickable {
                                vm.onAction(Action.OnSetTigerPalette)
                            }
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "\uD83D\uDC05 \nTiger",
                            color = getComposedColor(palette.text),
                            textAlign = TextAlign.Center
                        )
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f, fill = true)
                            .clip(CircleShape)
                            .clickable {
                                vm.onAction(Action.OnSetPantherPalette)
                            }
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "\uD83D\uDC08\u200D⬛ \nPanther",
                            color = getComposedColor(palette.text),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f, fill = true)
                            .clip(CircleShape)
                            .clickable {
                                vm.onAction(Action.OnSetTigerPalette)
                            }
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "\uD83D\uDC05 \nTiger",
                            color = getComposedColor(palette.text),
                            textAlign = TextAlign.Center
                        )
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f, fill = true)
                            .clip(CircleShape)
                            .clickable {
                                vm.onAction(Action.OnSetPantherPalette)
                            }
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "\uD83D\uDC08\u200D⬛ \nPanther",
                            color = getComposedColor(palette.text),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    ) { _, _ ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                items = palette.colors(),
                key = { it.hex }
            ) { color ->
                ColorPreview(
                    whColor = color,
                    textColor = getComposedColor(palette.text),
                    background = getComposedColor(palette.neutralFour),
                    secondaryBackground = getComposedColor(palette.neutralSix),
                    onCopy = { text ->
                        vm.onAction(Action.OnCopy(text))
                    }
                )
            }
        }
    }
}

@Composable
fun ColorPreview(
    whColor: WhColor,
    textColor: Color,
    background: Color,
    secondaryBackground: Color,
    onCopy: (text: String) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .clip(RoundedCornerShape(8.dp))
            .background(background)
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(32.dp)
                .clip(CircleShape)
                .background(getComposedColor(whColor))
                .border(1.dp, secondaryBackground, CircleShape)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {

            Text(text = whColor.name, color = textColor)

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(secondaryBackground)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, fill = true),
                    text = "HEX",
                    color = textColor,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = whColor.hex,
                    color = textColor
                )

                Spacer(modifier = Modifier.width(16.dp))

                Box(
                    modifier = Modifier
                        .clickable { onCopy(whColor.hex) }
                        .clip(RoundedCornerShape(8.dp))
                        .background(background)
                        .padding(4.dp),
                ) {

                    Icon(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(id = R.drawable.copy),
                        contentDescription = null,
                        tint = textColor,
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(secondaryBackground)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, fill = true),
                    text = "RGB",
                    color = textColor,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = whColor.rgb.rgb,
                    color = textColor
                )

                Spacer(modifier = Modifier.width(16.dp))

                Box(
                    modifier = Modifier
                        .clickable { onCopy(whColor.rgb.rgb) }
                        .clip(RoundedCornerShape(8.dp))
                        .background(background)
                        .padding(4.dp),
                ) {

                    Icon(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(id = R.drawable.copy),
                        contentDescription = null,
                        tint = textColor,
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(secondaryBackground)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f, fill = true),
                    text = "HSL",
                    color = textColor,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = whColor.hsl.hsl,
                    color = textColor
                )

                Spacer(modifier = Modifier.width(16.dp))

                Box(
                    modifier = Modifier
                        .clickable { onCopy(whColor.hsl.hsl) }
                        .clip(RoundedCornerShape(8.dp))
                        .background(background)
                        .padding(4.dp),
                ) {

                    Icon(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(id = R.drawable.copy),
                        contentDescription = null,
                        tint = textColor,
                    )
                }
            }
        }
    }
}
