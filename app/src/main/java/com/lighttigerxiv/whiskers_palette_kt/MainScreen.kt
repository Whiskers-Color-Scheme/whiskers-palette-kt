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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lighttigerxiv.layout_scaffold.LayoutScaffold
import com.lighttigerxiv.whiskers_palette_kt.ui.theme.ChangeNavigationBarsColor
import com.lighttigerxiv.whiskers_palette_kt.ui.theme.ChangeStatusBarColor

@Composable
fun MainScreen(vm: MainViewModel = viewModel()) {
    val uiState = vm.uiState.collectAsState().value
    val textColor = getComposeColor(uiState.palette.text)
    val neutralTwoColor = getComposeColor(uiState.palette.neutralTwo)
    val neutralForColor = getComposeColor(uiState.palette.neutralFor)

    ChangeStatusBarColor(color = neutralTwoColor)
    ChangeNavigationBarsColor(color = neutralForColor)

    LayoutScaffold(
        portraitNavigationBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(getComposeColor(uiState.palette.neutralFor)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .weight(1f, fill = true)
                        .clickable { vm.switchToPanther() },
                    contentAlignment = Alignment.Center
                ) {
                    NavbarTab(
                        iconId = R.drawable.panther,
                        text = "Panther",
                        active = uiState.tab == 0,
                        textColor = textColor
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .weight(1f, fill = true)
                        .clickable { vm.switchToTiger() },
                    contentAlignment = Alignment.Center
                ) {
                    NavbarTab(
                        iconId = R.drawable.tiger,
                        text = "Tiger",
                        active = uiState.tab == 1,
                        textColor = textColor
                    )
                }
            }
        },
        landscapeNavigationBar = {

        }
    ) { isTablet, inLandscape ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(getComposeColor(uiState.palette.neutralTwo))
                .padding(16.dp)
        ) {
            item {
                Text(
                    text = if (uiState.tab == 0) "Panther" else "Tiger",
                    color = getComposeColor(uiState.palette.text),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                ColorPreview(
                    paletteColor = uiState.palette.banana,
                    background = neutralForColor,
                    textColor = textColor,
                    secondaryBackground = neutralTwoColor,
                    mainViewModel = vm
                )

                Spacer(modifier = Modifier.height(16.dp))
                ColorPreview(
                    paletteColor = uiState.palette.blueberry,
                    background = neutralForColor,
                    textColor = textColor,
                    secondaryBackground = neutralTwoColor,
                    mainViewModel = vm
                )

                Spacer(modifier = Modifier.height(16.dp))
                ColorPreview(
                    paletteColor = uiState.palette.cherry,
                    background = neutralForColor,
                    textColor = textColor,
                    secondaryBackground = neutralTwoColor,
                    mainViewModel = vm
                )

                Spacer(modifier = Modifier.height(16.dp))
                ColorPreview(
                    paletteColor = uiState.palette.grape,
                    background = neutralForColor,
                    textColor = textColor,
                    secondaryBackground = neutralTwoColor,
                    mainViewModel = vm
                )

                Spacer(modifier = Modifier.height(16.dp))
                ColorPreview(
                    paletteColor = uiState.palette.kiwi,
                    background = neutralForColor,
                    textColor = textColor,
                    secondaryBackground = neutralTwoColor,
                    mainViewModel = vm
                )

                Spacer(modifier = Modifier.height(16.dp))
                ColorPreview(
                    paletteColor = uiState.palette.tangerine,
                    background = neutralForColor,
                    textColor = textColor,
                    secondaryBackground = neutralTwoColor,
                    mainViewModel = vm
                )

                Spacer(modifier = Modifier.height(16.dp))
                ColorPreview(
                    paletteColor = uiState.palette.neutral,
                    background = neutralForColor,
                    textColor = textColor,
                    secondaryBackground = neutralTwoColor,
                    mainViewModel = vm
                )

                Spacer(modifier = Modifier.height(16.dp))
                ColorPreview(
                    paletteColor = uiState.palette.neutralTwo,
                    background = neutralForColor,
                    textColor = textColor,
                    secondaryBackground = neutralTwoColor,
                    mainViewModel = vm
                )

                Spacer(modifier = Modifier.height(16.dp))
                ColorPreview(
                    paletteColor = uiState.palette.neutralThree,
                    background = neutralForColor,
                    textColor = textColor,
                    secondaryBackground = neutralTwoColor,
                    mainViewModel = vm
                )

                Spacer(modifier = Modifier.height(16.dp))
                ColorPreview(
                    paletteColor = uiState.palette.neutralFor,
                    background = neutralForColor,
                    textColor = textColor,
                    secondaryBackground = neutralTwoColor,
                    mainViewModel = vm
                )

                Spacer(modifier = Modifier.height(16.dp))
                ColorPreview(
                    paletteColor = uiState.palette.neutralFive,
                    background = neutralForColor,
                    textColor = textColor,
                    secondaryBackground = neutralTwoColor,
                    mainViewModel = vm
                )

                Spacer(modifier = Modifier.height(16.dp))
                ColorPreview(
                    paletteColor = uiState.palette.neutralSix,
                    background = neutralForColor,
                    textColor = textColor,
                    secondaryBackground = neutralTwoColor,
                    mainViewModel = vm
                )

                Spacer(modifier = Modifier.height(16.dp))
                ColorPreview(
                    paletteColor = uiState.palette.neutralSeven,
                    background = neutralForColor,
                    textColor = textColor,
                    secondaryBackground = neutralTwoColor,
                    mainViewModel = vm
                )

                Spacer(modifier = Modifier.height(16.dp))
                ColorPreview(
                    paletteColor = uiState.palette.neutralEight,
                    background = neutralForColor,
                    textColor = textColor,
                    secondaryBackground = neutralTwoColor,
                    mainViewModel = vm
                )

                Spacer(modifier = Modifier.height(16.dp))
                ColorPreview(
                    paletteColor = uiState.palette.text,
                    background = neutralForColor,
                    textColor = textColor,
                    secondaryBackground = neutralTwoColor,
                    mainViewModel = vm
                )

                Spacer(modifier = Modifier.height(16.dp))
                ColorPreview(
                    paletteColor = uiState.palette.textTwo,
                    background = neutralForColor,
                    textColor = textColor,
                    secondaryBackground = neutralTwoColor,
                    mainViewModel = vm
                )

                Spacer(modifier = Modifier.height(16.dp))
                ColorPreview(
                    paletteColor = uiState.palette.textThree,
                    background = neutralForColor,
                    textColor = textColor,
                    secondaryBackground = neutralTwoColor,
                    mainViewModel = vm
                )

                Spacer(modifier = Modifier.height(16.dp))
                ColorPreview(
                    paletteColor = uiState.palette.textFor,
                    background = neutralForColor,
                    textColor = textColor,
                    secondaryBackground = neutralTwoColor,
                    mainViewModel = vm
                )
            }
        }
    }
}

@Composable
fun NavbarTab(
    iconId: Int,
    text: String,
    active: Boolean,
    textColor: Color,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(28.dp),
            painter = painterResource(id = iconId),
            contentDescription = null,
            tint = textColor
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = text,
            fontSize = 20.sp,
            color = textColor,
            fontWeight = if (active) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@Composable
fun ColorPreview(
    paletteColor: com.lighttigerxiv.whiskers_palette_kt.Color,
    textColor: Color,
    background: Color,
    secondaryBackground: Color,
    mainViewModel: MainViewModel
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
                .background(getComposeColor(paletteColor))
                .border(1.dp, secondaryBackground, CircleShape)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {

            Text(text = paletteColor.name, color = textColor)

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
                    text = paletteColor.hex,
                    color = textColor
                )

                Spacer(modifier = Modifier.width(16.dp))

                Box(
                    modifier = Modifier
                        .clickable { mainViewModel.copyText(paletteColor.hex) }
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
                    text = paletteColor.rgb.rgb,
                    color = textColor
                )

                Spacer(modifier = Modifier.width(16.dp))

                Box(
                    modifier = Modifier
                        .clickable { mainViewModel.copyText(paletteColor.rgb.rgb) }
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
                    text = paletteColor.hsl.hsl,
                    color = textColor
                )

                Spacer(modifier = Modifier.width(16.dp))

                Box(
                    modifier = Modifier
                        .clickable { mainViewModel.copyText(paletteColor.hsl.hsl) }
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
