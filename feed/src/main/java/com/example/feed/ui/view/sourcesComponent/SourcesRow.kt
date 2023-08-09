package com.example.feed.ui.view

import android.content.res.Resources
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.compose.rememberImagePainter
import com.example.feed.R
import com.example.model.dto.article.ArticleDto
import com.example.model.dto.sources.SourceDto
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import timber.log.Timber

@Composable
fun SourcesRow(
    sourcesDto: SourceDto,
    onDetailClick: () -> Unit = {},
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable { onDetailClick() }
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(50.dp)
                .width(50.dp)
                .clip(CircleShape)
        ) {
            val storage = Firebase.storage
            var storageRef = storage.reference

            val imageUrl = remember { mutableStateOf<String?>(null) }
            storageRef.child(sourcesDto.id + ".png").downloadUrl.addOnFailureListener() {
                Timber.e(it.toString())
                imageUrl.value = ""
            }.addOnSuccessListener {
                imageUrl.value = it.toString()
            }
            imageUrl.value?.let { url ->
                val painter = rememberImagePainter(data = url, builder = {
                    crossfade(true)
                    error(R.drawable.placeholder)
                })
                Image(
                    painter = painter,
                    contentDescription = "Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = sourcesDto.name,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }

}