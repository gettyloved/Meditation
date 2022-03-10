package com.ciru.meditation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ciru.meditation.ui.theme.*
import androidx.compose.ui.graphics.Canvas as Canvas1

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeditationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Meditation()
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun Meditation(){
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            GreetingsSection()
            ChipSection(chips = listOf("Sweet Sleep", "Insomnia", "Depression"))
            CurrentMeditation()
            FeatureSection(
                feature = listOf(
                    Feature(
                        title = "Sleep Motivation",
                        R.drawable.ic_baseline_headset_24,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for Sleeping",
                        R.drawable.ic_baseline_videocam_24,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night Island",
                        R.drawable.ic_baseline_headset_24,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming Sounds",
                        R.drawable.ic_baseline_videocam_24,
                        Beige1,
                        Beige2,
                        Beige3
                    ),
                    Feature(
                        title = "Night Island",
                        R.drawable.ic_baseline_headset_24,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming Sounds",
                        R.drawable.ic_baseline_videocam_24,
                        Beige1,
                        Beige2,
                        Beige3
                    )
                )
            )
        }
        BottomMenu(
            items = listOf(
                BottomMenuContent("Home", R.drawable.ic_baseline_home_24),
                BottomMenuContent("Meditate", R.drawable.ic_baseline_bubble_chart_24),
                BottomMenuContent("Sleep", R.drawable.ic_baseline_moon_2_24),
                BottomMenuContent("Music", R.drawable.ic_baseline_music_note_24),
                BottomMenuContent("Profile", R.drawable.ic_baseline_person_24),
            ),
            modifier = Modifier.align(Alignment.BottomCenter))
    }
}


@Composable
fun GreetingsSection(
    name:String = "Philip"
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ){
        Column {
            Text(
                text ="Good morning, $name",
                color = Color.White,
                style = MaterialTheme.typography.h4)

            Text(
                text ="We wish you have a good name",
                color = Color.White,
                style = MaterialTheme.typography.body1)
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "search",
            tint = Color.White,
            modifier = Modifier.size(24.dp))
    }
}

@Composable
fun ChipSection(
    chips: List<String>
){
   var selectedChipIndex by remember {
       mutableStateOf(0)
   }

    LazyRow{
        items(chips.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, bottom = 15.dp, top = 15.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .clickable {
                        selectedChipIndex = it
                    }
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = TextWhite )
            }
        }
    }
}

@Composable
fun CurrentMeditation(
    color: Color = LightRed
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 10.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text ="Daily Thought",
                style = MaterialTheme.typography.h5)

            Text(
                text ="Meditation .3-10 min",
                style = MaterialTheme.typography.body1,
                color = TextWhite)
        }

        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(ButtonBlue)
                .size(40.dp)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_play_arrow_24),
                contentDescription = "play",
                tint = Color.White,
                modifier = Modifier
                    .size(16.dp))
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun FeatureSection(feature: List<Feature>){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(15.dp)
        )
        
         LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
            ){
                items(feature.size){
                    FeaturedItem(feature = feature[it] )
                }
        }
    }
}

@Composable
fun FeaturedItem(
    feature: Feature
){
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

//        medium colored path

        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())


        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)

            lineTo(width.toFloat() + 100f , height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() +100f)
            close()
        }

        //            light colored path

        val lightColored1 = Offset(0f,height * 0.35f)
        val lightColored2 = Offset(width * 0.1f , height * 0.4f)
        val lightColored3 = Offset(width * 0.3f, height * 0.35f)
        val lightColored4 = Offset(width * 0.65f, height.toFloat())
        val lightColored5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightColored1.x, lightColored1.y)
            standardQuadFromTo(lightColored1, lightColored2)
            standardQuadFromTo(lightColored2, lightColored3)
            standardQuadFromTo(lightColored3, lightColored4)
            standardQuadFromTo(lightColored4, lightColored5)

            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        Canvas(
           modifier = Modifier
               .fillMaxSize()
        ){
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )

            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        } 
        
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.h6,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )

            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)

            )
//            var onClick: () -> String
            Text(
                text = "start",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .clickable {
//                        onClick
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 12.dp)
            )
        }
    }
}

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex:Int = 0
){
    var selectedItemIndex by remember{
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
                items.forEachIndexed { index, item ->
                        BottomMenuItem(
                            item = item,
                            isSelected = index == selectedItemIndex,
                            activeHighlightColor = activeHighlightColor,
                            inactiveTextColor = inactiveTextColor,
                            activeTextColor = activeTextColor
                        ) {
                                selectedItemIndex = index
                        }
                }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.clickable { onItemClick }
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(15.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (isSelected) activeHighlightColor else Color.Transparent)
            ) {
                Icon(
                    painter = painterResource(id = item.iconId),
                    contentDescription = item.title,
                    tint = if (isSelected) activeTextColor else inactiveTextColor,
                    modifier = Modifier.size(40.dp)
                )
            }
            Text(
                text = item.title,
                color = if (isSelected) activeTextColor else inactiveTextColor
            )
        }
}


@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Meditation()
}