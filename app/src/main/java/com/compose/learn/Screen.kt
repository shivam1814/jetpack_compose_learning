package com.compose.learn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, heightDp = 500)
@Composable
fun PreviewFun() {

    /*Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        getCategoryList().map { item ->
            BlogCategory(item.img, item.title, item.subTitle)
        }
    }*/

    LazyColumn(content = {
        items(getCategoryList()){ item ->
            BlogCategory(item.img, item.title, item.subTitle)
        }
    })

}


@Composable
fun BlogCategory(img: Int, title: String, subTitle: String) {

    Card(
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Image(
                painter = painterResource(img),
                contentDescription = "user image",
                Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )
            ItemDescription(title, subTitle, Modifier.weight(.8f))
        }
    }
}

@Composable
private fun ItemDescription(title: String, subTitle: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = subTitle,
            fontWeight = FontWeight.Thin,
            fontSize = 12.sp
        )
    }
}

data class Category(val img: Int, val title: String, val subTitle: String)

fun getCategoryList(): MutableList<Category> {
    val list = mutableListOf<Category>()
    list.add(Category(R.drawable.user, "Programming", "Learn Different Language"))
    list.add(Category(R.drawable.user, "Technology", "News about tech"))
    list.add(Category(R.drawable.user, "Full stack", "web development"))
    list.add(Category(R.drawable.user, "Android", "Kotlin development"))
    list.add(Category(R.drawable.user, "AI ML", "python programming"))
    list.add(Category(R.drawable.user, "Programming", "Learn Different Language"))
    list.add(Category(R.drawable.user, "Technology", "News about tech"))
    list.add(Category(R.drawable.user, "Full stack", "web development"))
    list.add(Category(R.drawable.user, "Android", "Kotlin development"))
    list.add(Category(R.drawable.user, "AI ML", "python programming"))
    return list
}