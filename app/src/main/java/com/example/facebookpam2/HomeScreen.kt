package com.example.facebookpam2


import android.net.wifi.WifiConfiguration.AuthAlgorithm.strings
import android.util.Log.d
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.SemanticsProperties.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.facebookpam2.ui.theme.ButtonGray
import java.io.FileDescriptor
import java.security.Key

@Preview
@Composable
fun HomeScreen(){
    Box(Modifier
        .background(MaterialTheme.colors.background)
        .fillMaxSize()){
        LazyColumn{
            item {
                TopAppBar()
            }
            item {
                TabBar()
            }
            item {
                StatusUPdateBar(
                   avatarUrl ="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQsyhc52ffNteD1GbD9FoOca9_pLGzXok1JOg&usqp=CAU",
                    onTextChange ={

                    },
                    onSendClick = {}
                )
            }
        }


    }
}
@Composable
private fun TopAppBar(){
    Surface {
    Row(Modifier
        .fillMaxWidth()
        .padding(horizontal = 8.dp, vertical = 8.dp),
        verticalAlignment = Alignment
            .CenterVertically) {
        Text("facebooK pam2", style = MaterialTheme.typography.h6)
        Spacer(Modifier.weight(1f))
        IconButton(onClick = { /*TODO*/ },
            modifier = Modifier
                .clip(CircleShape)
                .background(ButtonGray)

        ) {
            Icon(Icons.Rounded.Search,contentDescription ="search")
        }
        Spacer(modifier = Modifier.width(10.dp))
        IconButton(onClick = { /*TODO*/ },
            modifier = Modifier
                .clip(CircleShape)
                .background(ButtonGray)

        ) {
            Icon(Icons.Rounded.ChatBubble,contentDescription ="search")
        }

    }
}
}
data class TabItem(
    val icon:ImageVector,
    val contentDescription:String
)
@Composable
 fun TabBar(){
    Surface {
    var tabIndex by remember {
        mutableStateOf(0)
    }
    TabRow(selectedTabIndex = tabIndex,
        backgroundColor = Color.Transparent,
        contentColor =MaterialTheme.colors.primary

    ) {
        val tabs= listOf(
          TabItem( Icons.Rounded.Home,  stringResource(com.example.facebookpam2.R.string.home)) ,
            TabItem(Icons.Rounded.Tv,  stringResource(com.example.facebookpam2.R.string.reels) ),
            TabItem( Icons.Rounded.Store, stringResource(com.example.facebookpam2.R.string.store)) ,
            TabItem(Icons.Rounded.Newspaper,  stringResource(com.example.facebookpam2.R.string.News)),
            TabItem(Icons.Rounded.Notifications,  stringResource(com.example.facebookpam2.R.string.notification)),
            TabItem(Icons.Rounded.Menu,  stringResource(com.example.facebookpam2.R.string.menu)),
        )
        tabs.forEachIndexed{
            i,item->

            Tab(
                selected = tabIndex==i,
                onClick = { tabIndex=i },
                modifier = Modifier.padding(top = 8.dp)

                )
            {
                Icon(item.icon, item.contentDescription,
                    tint = if(i==tabIndex){
                    MaterialTheme.colors.primary
                }else{
                    MaterialTheme.colors.onSurface.copy(
                        alpha = 0.44f
                    )
                })
            }
        }


    }
}
}
@Composable
fun StatusUPdateBar(
    avatarUrl:String,
    onTextChange:(String)->Unit,
    onSendClick:()->Unit

    ){

    Surface {
        Column {


        Row(Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 12.dp),
             verticalAlignment = Alignment.CenterVertically
            ){
       AsyncImage(model = ImageRequest.Builder(
           LocalContext.current
       ).data(avatarUrl)
           .crossfade(true)
           .placeholder(com.example.facebookpam2.R.drawable.ic_placeholder)
           .build(), contentDescription =null ,
             modifier = Modifier
                 .size(40.dp)
                 .clip(CircleShape)

           )
            Spacer(Modifier.width(8.dp))
           /* Text(stringResource(com.example.facebookpam2.R.string.Quoi_de_neuf),
                  style = MaterialTheme.typography.body1.copy(
                      color=MaterialTheme.colors.onSurface.copy(
                          alpha = 0.66F
                      )
                  )
                )*/
            var text by remember {
                mutableStateOf("")
            }
            TextField(
                colors=TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                value =text ,

                modifier = Modifier.fillMaxWidth(),
                onValueChange ={
                      text=it
                    onTextChange(it)
            },
                placeholder = {
                    Text(stringResource(com.example.facebookpam2.R.string.Quoi_de_neuf))
                },
                keyboardActions = KeyboardActions(onSend = {
                    onSendClick()
                    text = ""
                }),
                keyboardOptions = KeyboardOptions(
                    imeAction = androidx.compose.ui.text.input.ImeAction.Send

                )
            )
        }
            Divider(Modifier.fillMaxWidth())
            Row(verticalAlignment = Alignment.CenterVertically) {
                  TextButton(onClick = { /*TODO*/ }) {
                      Row{
                          Icon(Icons.Rounded.VideoCall,contentDescription = stringResource(com.example.facebookpam2.R.string.live))
                          Spacer(Modifier.width(8.dp))
                          Text(stringResource(com.example.facebookpam2.R.string.Live))
                      }
                      
                  }
            }
    }
    }
}