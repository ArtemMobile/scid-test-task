package com.example.scid_test_task.ui.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.example.scid_test_task.R

@Composable
fun ImageByUrl(modifier: Modifier = Modifier, url: String, contentDescription: String?) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current).data(url).memoryCacheKey(url).build(),
        contentDescription = contentDescription,
        placeholder = painterResource(R.drawable.ic_placeholder),
        modifier = modifier,
        contentScale = ContentScale.Fit
    )
}